package com.my.blog.website.dataStructure.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {10,9,8,7,6,5,4,3,2,1};
        int[] test = new int[80000];
        for (int i = 0; i <test.length ; i++) {
            test[i] = (int)(Math.random()*80000);
        }
        long start = System.currentTimeMillis();
        quickSort(test,0,test.length-1);
        long end = System.currentTimeMillis();
        System.out.println("所需时间:"+(end - start));
        //System.out.println(Arrays.toString(test));

    }

    public static void quickSort(int[]array,int low,int high ){
        if(low<high){
            int index = partition(array,low,high);
            //左遍历
            quickSort(array,low,index - 1);
            //右遍历
            quickSort(array,index+1,high);
        }

    }

    public static int partition(int[] array ,int low ,int high){

        int temp = array[low];
        while(low<high){

            while(low<high && array[high]>=temp){
                high--;
            }
            array[low] = array[high];
            while (low <high && array[low]<=temp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;

        return low;
    }



}
