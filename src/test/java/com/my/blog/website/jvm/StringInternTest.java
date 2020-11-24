package com.my.blog.website.jvm;

import org.junit.Test;

public class StringInternTest {

    @Test
    public void stringInternTest(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2); // jdk6:false jdk7/8:false

        String s3 = new String("1") + new String("1");
        s3.intern();// jdk7：此时常量池并没有创建"11",而是创建一个指向堆中的引用
        String s4 = "11";
        System.out.println(s3 == s4);// jdk6:false jdk7/8:true

    }

}
