package com.my.blog.website.config.rabbitmq;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class RabbitMQConfiguration {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    private static  final org.slf4j.Logger log = LoggerFactory.getLogger(RabbitMQConfiguration.class);

    /**
     *  rabbit 初始化连接
     * @return
     */
    @Bean
    @RefreshScope
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        log.info("host:"+host);
        return connectionFactory;
    }

    /**
     * 获取mq连接实例
     * @return
     * @throws Exception
     */

    public Connection getConnection() throws Exception{
        return connectionFactory().newConnection();
    }

    public void ttt(){
        connectionFactory();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
