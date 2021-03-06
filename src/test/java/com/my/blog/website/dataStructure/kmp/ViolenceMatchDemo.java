package com.my.blog.website.dataStructure.kmp;

import com.sun.org.apache.xpath.internal.objects.XStringForChars;
import org.junit.Test;

import java.util.Arrays;

public class ViolenceMatchDemo {

    public static void main(String[] args) {
        String str1 = "zhengwuhao";
        String str2 = "gz";
        int index = demo(str1,str2);
        System.out.println(index);
    }

    public static int demo(String str1,String str2){
        str1.indexOf(str2);
        int index = -1;
        if(str1.length()<str2.length()||str2.length() == 0)
            return index;
        for(int i=0;i<str1.length();i++){
            int temp = i;
            int j = 0;
            for(j = 0;j<str2.length();j++){
                if(str2.charAt(j)!=str1.charAt(temp)){
                    break;
                }
                temp++;
            }
            if(str2.length() == j){
                return i;
            }
        }
        return index;
    }

    public int[] getNext(String str){

        int[] next = new int[str.length()];
        next[0] = 0;
        int j = 0 ;
        for(int i = 0;i<str.length();i++){

            while(j>0 && str.charAt(i)!=str.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;

        }
        return next;

    }

    @Test
    public void test(){
        int[] next = kmpNext("ABCDEABCDD");
        System.out.println(Arrays.toString(next));
    }



    public static int[] kmpNext(String dest) {
        // 创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; // 如果字符串是长度为1 部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            // 直到我们发现 有 dest.charAt(i) == dest.charAt(j)成立才退出
            // 这是kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            // 当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        // 遍历
        for (int i = 0, j = 0; i < str1.length(); i++) {

            // 需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            // KMP算法核心点, 可以验证...
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) { // 找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    @Test
    public void kmpTestDemo(){
        String str1 = "zhengwuhao";
        String str2 = "ha";
        int[] next = kmpNextTest(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpTest(str1,str2,next));
    }



    public int kmpTest(String str1,String str2,int[] next){
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

    public int[] kmpNextTest(String str){

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
