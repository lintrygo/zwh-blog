package com.my.blog.website.springTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(configTest.class);
        System.out.println(a.getBean(X.class));
    }

}
