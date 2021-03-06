package com.my.blog.website.dataStructure.kmp;

import org.junit.Test;

import java.util.Arrays;

public class KmpDemo {

    @Test
    public void kmpTestDemo(){
        String str1 = "zhengwuhao";
        String str2 = "ha";
        int[] next = getNext(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(str1,str2,next));
    }



    public int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j=0;i<str1.length();i++){
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(str2.length() == j){
                return i-j+1;
            }
        }
        return -1;
    }

    public int[] getNext(String str){
        int[] next = new int[str.length()];
        next[0] = 0;
        for(int i = 1,j=0;i<str.length();i++){
            while (j>0 && str.charAt(i)!=str.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
