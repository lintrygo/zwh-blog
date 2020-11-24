package com.my.blog.website.dataStructure.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {


    @Test
    public void test(){
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(search(array,0,array.length-1,6));
    }

    @Test
    public void test2(){
        int[] array = {1,2,3,4,5,6,6,6,6,6};
        List<Integer> result = search2(array,0,array.length-1,6);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public int search(int[] array,int left,int right,int value){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(array[mid] == value){
            return mid;
        }else if(array[mid]<value){
            return search(array,mid+1,right,value);
        }else{
            return search(array,left,mid-1,value);
        }

    }


    /**
     * 查询所有值的集合
     * @param array
     * @param left
     * @param right
     * @param value
     * @return
     */
    public List<Integer> search2(int[] array,int left,int right,int value){

        if(left>right){
            return new ArrayList<>();
        }

        int mid = (left+right)/2;
        if(value == array[mid]){
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if(temp<0 || array[temp]!=value){
                    break;
                }
                list.add(temp);
                temp-=1;
            }
            list.add(mid);
            temp = mid + 1;
            while (true){
                if(temp>array.length-1||array[temp]!=value){
                    break;
                }
                list.add(temp);
                temp+=1;
            }
            return list;
        }else if(value>array[mid]){
            return search2(array,mid+1,right,value);
        }else{
            return search2(array, left, mid - 1, value);
        }
    }












}


