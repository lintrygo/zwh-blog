package com.my.blog.website.jvm;

import org.junit.Test;

public class StringTableTest {

    @Test
    public void test1(){
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = new String("a")+new String("b");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a==b);
        System.out.println(a.intern() == c);
        System.out.println(b.intern() == c);
    }
}
