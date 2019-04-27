package com.xuyang.springcloud.server_rabbitmq.receiver;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@RabbitListener(queues = "topic_message")
public class RabbitSendService {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver1:" + hello);
    }

}
