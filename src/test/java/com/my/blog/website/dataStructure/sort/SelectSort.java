package com.my.blog.website.dataStructure.sort;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {
        int[] array = {44,11,444,5,6,78,9};
        sort(array);
        System.out.println(Arrays.toString(array));
    }



    /**
     * 选择排序
     * @param array
     */
    public static void sort(int[] array){

        int min;
        int temp;
        for (int i = 0; i <array.length-1 ; i++) {
            min = i;
            for(int j = i+1; j<array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            //交换最小值
            if(min!=i){
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

}
