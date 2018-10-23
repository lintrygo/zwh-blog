package com.my.blog.website.config.rabbitmq;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class RabbitMQConfiguration {
//
//    @Value("${spring.rabbitmq.host}")
//    private String host;
//
//    @Value("${spring.rabbitmq.port}")
//    private int port;
//
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//
//    /**
//     *  rabbit 初始化连接
//     * @return
//     */
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost(host);
//        connectionFactory.setPort(port);
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
//        return connectionFactory;
//    }
//
//    /**
//     * 获取mq连接实例
//     * @return
//     * @throws Exception
//     */
//
//    public Connection getConnection() throws Exception{
//        return connectionFactory().newConnection();
//    }

}
