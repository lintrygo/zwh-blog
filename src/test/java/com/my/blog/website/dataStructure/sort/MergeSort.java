package com.my.blog.website.dataStructure.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {10,9};
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array,int left,int right,int[] temp){
        if(left<right){
            int mid =  (right+left)/2;
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }
    }


    public static void merge(int[] array,int left,int mid,int right,int[] temp){

        int i = left;
        int j = mid+1;
        //临时数组指针
        int t = 0;

        while(i<=mid && j<=right){
            if(array[i]<=array[j]){
                temp[t] = array[i];
                t++;
                i++;
            }else{
                temp[t] = array[j];
                t++;
                j++;
            }
        }

        while(i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }

        while(j<=right){
            temp[t] = array[j];
            t++;
            j++;
        }
        //合并数组
        int tempLeft = left;
        t = 0;
        while(tempLeft<=right){
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


    @Test
    public void test(){
        int[] array ={10,9,8,7,6,5};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array,int low,int high){
        if(low<high){
            int index = getIndex(array,low,high);
            quickSort(array,low,index-1);
            quickSort(array,index+1,high);
        }
    }


    public static int getIndex(int[] array,int low ,int high){
        int temp  = array[low];
        while(low<high){

            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            while (low<high &&array[low]<=temp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

}
