package com.my.blog.website.springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class X {

    @Autowired
    private Y y;


    public X() {

        System.out.println("x对象创建完成!");

    }

    @PostConstruct
    public void xPostConstruct(){
        System.out.println("x bean生命周期回调!");
    }
}
