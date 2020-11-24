package com.my.blog.website.springTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Y {

    @Autowired
    private X x;

    public Y(){
        System.out.println("Y对象创建完成");
    }

    @PostConstruct
    public void yPostConstruct(){
        System.out.println("Y bean生命周期回调");
    }

}
