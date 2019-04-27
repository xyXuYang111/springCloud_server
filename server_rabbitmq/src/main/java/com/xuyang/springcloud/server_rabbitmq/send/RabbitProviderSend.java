package com.xuyang.springcloud.server_rabbitmq.send;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: cypc
 * @Date: 2019-4-11 15:47
 * @Description:
 */
@Data
@Slf4j
@Component
public class RabbitProviderSend {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    /**
     * 发送消息
     * queues = "hello" 的消息
     */
    public void send1(){
        String content = "hello" + new Date();
        System.out.println("Sender:" +content);
        rabbitmqTemplate.convertAndSend("hello", content);
    }

    public void send2(){
        String content = "hello" + new Date();
        rabbitmqTemplate.convertAndSend("exchage","topic.message","topic_message");
        rabbitmqTemplate.convertAndSend("exchage","topic.messages","topic_messages");
    }

}
