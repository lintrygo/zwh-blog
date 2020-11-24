package com.my.blog.website.dataStructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
    }

    @Test
    public void test(){
        int[] arr = {10000,9,8,7,6};

        int maxDigit = getMaxDigit(arr);
         radixSort(arr, maxDigit);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                //求
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    @Test
    public void test1(){
        int[] array = {10,8,7,6,5};
        radixSortTest(array);
        System.out.println(Arrays.toString(array));
    }


    public void radixSortTest(int[] array){
        //求最大值
        int maxValue = array[0];
        for(int value:array){
            if(value>maxValue){
                maxValue = value;
            }
        }
        //求最大值位数
        int digit = (maxValue+"").length();

        //桶数量
        int[][] buckets = new int[10][array.length];
        //每个桶计数
        int[] bucketNum  = new int[10];
        for(int i = 0,n = 1;i<digit;i++,n*=10){
            //元素放入桶中
            for(int j=0;j<array.length;j++){
                int digitValue = array[j]/n%10;
                buckets[digitValue][bucketNum[digitValue]] = array[j];
                bucketNum[digitValue]++;
            }
            int index = 0;
            //将元素放入回数组中
            for (int k = 0; k <bucketNum.length ; k++) {
                if(bucketNum[k]!=0){
                    for(int l = 0;l<bucketNum[k];l++){
                        array[index++] = buckets[k][l];
                    }
                }
                bucketNum[k] = 0;
            }

        }


    }

}
