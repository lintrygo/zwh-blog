package com.my.blog.website.dataStructure.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] array = {100,4,23,56,78,99,123};
        sortA(array);
        System.out.println(Arrays.toString(array));
        System.out.println("v22");
    }

    /**
     * 希尔排序 交换法
     * @param array
     */
    public static void sort(int[] array){

        int temp = 0;
        for (int gap = array.length/2; gap >0 ; gap = gap/2) {

            for (int i = gap; i < array.length ; i++) {

                for (int j = i - gap; j >=0 ; j -=gap) {

                    if(array[j]>array[j+gap]){
                        temp = array[j+gap];
                        array[j+gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序 插入法
     * @param array
     */
    public static void sortA(int[] array){

        int j = 0;
        int temp = 0;
        for (int gap = array.length/2; gap >0 ; gap = gap/2) {

            for (int i = gap; i < array.length ; i++) {
                temp =  array[i];
                for (j = i - gap; j>=0 && array[j]>temp; j = j - gap) {
                    array[j+gap] = array[j];
                }
                array[j+gap] = temp;
            }
        }

    }






















    public void sortInsert(int[] array){

        int j = 0;
        int temp = 0;
        for(int i = 1;i<array.length;i++){
            temp = array[i];
            for(j = i - 1;j>=0&&array[j]>temp;j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
    }

    public void sortTest(int[] array){
        int j = 0;
        int temp = 0;
        for(int gap = array.length/2;gap>0;gap = gap/2){

            for (int i = gap; i < array.length ; i++) {

                temp = array[i];
                for (j = i - gap; j>=0 && array[j]>temp ; j++) {
                    array[j+gap] = array[j];
                }
                array[j+gap] = temp;

            }
        }


    }








}


