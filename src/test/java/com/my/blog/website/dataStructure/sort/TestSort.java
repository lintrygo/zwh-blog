package com.my.blog.website.dataStructure.sort;

import com.google.inject.internal.cglib.reflect.$FastMember;
import org.junit.Test;

import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {

    }
    public void bubbleSort(int[] array){
        int temp;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length-1-i ; j++) {
                if(array[j]<array[j+1]){
                    temp = array[j];
                    array[j] =  array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    @Test
    public void test(){
        int[] array = {10,9,8,7,6,5};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
    public void selectSort(int[] array){
        int minValue;
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minValue = array[i];
            minIndex = i;
            for (int j = i+1; j <array.length ; j++) {
                if(minValue>array[j]){
                    minValue = array[j];
                    minIndex = j;
                }
            }
            //交换最小值
            if(minValue!=array[i]){
                array[minIndex] = array[i];
                array[i] = minValue;
            }
        }
    }
    
    public void insertSort(int[] array){

        int j;
        for(int i = 1;i<array.length;i++){
            int temp = array[i];
            for(j=i-1;j>=0 &&array[j]>temp;j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }

    }



    public void shellSort(int[] array){
        int j;
        for(int gap = array.length/2;gap>0;gap/=2){
            for(int i = gap;i<array.length;i++){
                int temp = array[i];
                for(j = i-gap;j>=0&&temp<array[j];j-=gap){
                    array[j+gap] = array[j];
                }
                array[j+gap] = temp;
            }
        }
    }


    @Test
    public void testQuickSort(){
        int[] array = {10,9,8,7,6,6};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array,int left,int right){

        if(left<right){
            int index = getIndex(array,left,right);
            quickSort(array,left,index-1);
            quickSort(array,index+1,right);
        }

    }

    public int getIndex(int[] array ,int left ,int right){

        int temp = array[left];
        while(left<right){

            while(left<right && array[right]>=temp){
                right--;
            }
            array[left] = array[right];

            while (left<right &&array[left]<=temp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }





    @Test
    public void mergeSortTest(){
        int[] array = {10,9,8,7,6,5,5,2,1};
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }

    }

   public void merge(int[] array,int left,int mid,int right,int[] temp){

       int i = left;
       int j = mid + 1;
       int t = 0;
       while (i <= mid && j <= right) {
           if (array[i] > array[j]) {
               temp[t] = array[j];
               j++;
            }else{
                temp[t] = array[i];
                i++;
            }
            t++;
        }
        while (i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = array[j];
            t++;
            j++;
        }

        t = 0;
        while (left<=right){
            array[left] = temp[t];
            t++;
            left++;
        }
   }

}
