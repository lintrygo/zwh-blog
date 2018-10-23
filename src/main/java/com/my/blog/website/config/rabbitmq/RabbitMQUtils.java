package com.my.blog.website.config.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQUtils {
    private static  final org.slf4j.Logger log = LoggerFactory.getLogger(RabbitMQUtils.class);

//    @Autowired
//    RabbitMQConfiguration rabbitMQConfiguration;
//
//    /**
//     * 发送消息
//     */
//    public void sendMsg(String exchange){
//        try {
//            Connection connection = rabbitMQConfiguration.getConnection();
//            Channel channel = connection.createChannel();
//            channel.queueDeclare(exchange,true,false,false,null);
//            for (int i = 0; i < 9; i++) {
//                channel.basicPublish("", exchange, null, String.valueOf(i).getBytes());
//            }
////            channel.basicPublish("",exchange, null, SerializationUtils.serialize(Object));
////            log.info("["+exchange+"] Sent '" + Object + "'");
//            channel.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
