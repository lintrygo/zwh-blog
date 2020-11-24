package com.my.blog.website.dataStructure.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i <array.length ; i++) {
            array[i] = (int)(Math.random()*80000);
        }
        long startTime = System.currentTimeMillis();
        sortA(array);
        long endTime = System.currentTimeMillis();
        System.out.println("排序持续时间:"+(endTime-startTime));

    }

    public static void sort(int[] array){
        //插入排序
        int j;
        for (int i = 1; i <array.length ; i++) {
            int temp = array[i];
            for (j = i-1; j>=0 && array[j]> temp ; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
    }

    //第二种插入排序
    public static void sortA(int[] array){
        int insertIndex;
        int insertValue;
        for (int i = 1; i < array.length ; i++) {
             insertIndex = i - 1;
             insertValue = array[i];
            while (insertIndex>=0 && insertValue<array[insertIndex]){
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex+1] = insertValue;
        }
    }


}
