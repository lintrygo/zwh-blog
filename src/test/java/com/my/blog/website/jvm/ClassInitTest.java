package com.my.blog.website.jvm;

public class ClassInitTest {

    static {
        a = 100;
        //System.out.println(a);
    }

    private static int a = 1;

    public void test(){
        "d".intern();
        String A = "dddddddddddd";
    }

}
