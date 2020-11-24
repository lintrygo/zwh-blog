package com.my.blog.website.dataStructure.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        int[] arr = {4,1,26,5,100,45,5,3,34,56};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序 时间复杂O(n2)
     * @param array
     */
    public void sort(int[] array){
        int temp = 0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j+1]<array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        List<String> arr = new ArrayList<>();
    }

    public void sortA(int[] array){
        int temp = 0;
        boolean flag = false;
        for(int i=0;i<array.length;i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag)
                break;
            else
                flag = false;

        }
    }

}
