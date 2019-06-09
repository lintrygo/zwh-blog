package com.my.blog.website.controller;

import com.my.blog.website.config.rabbitmq.MqConfig;
import com.my.blog.website.config.rabbitmq.RabbitMQConfiguration;
import com.my.blog.website.config.rabbitmq.RabbitMQUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    private static  final org.slf4j.Logger log = LoggerFactory.getLogger(Test.class);

    @Autowired
    private RabbitMQUtils rabbitMQUtils;

    @Autowired
    RabbitMQConfiguration rabbitMQConfiguration;

    @Autowired
    MqConfig mqConfig;

    @GetMapping("/affff")
    public void test(){
        log.info("test Configuration:"+rabbitMQConfiguration.getHost());
        log.info("test pro:"+mqConfig.getHost());
    }

}