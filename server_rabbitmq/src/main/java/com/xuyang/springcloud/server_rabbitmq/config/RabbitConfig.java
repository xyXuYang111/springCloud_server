package com.xuyang.springcloud.server_rabbitmq.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
public class RabbitConfig {

    /**
     * 消息列队管道---hello
     * @return
     */
    @Bean(name = "hello")
    public Queue helloQueue(){
        log.info("创建通道：hello");
        return new Queue("hello");
    }

    /**
     * 消息列队管道---topic_message
     * @return
     */
    @Bean(name = "topic_message")
    public Queue queueMessage(){
        log.info("创建通道：topic_message");
        return  new Queue("topic_message");
    }

    /**
     * 消息列队管道---topic_messages
     * @return
     */
    @Bean(name = "topic_messages")
    public Queue queueMessages(){
        log.info("创建通道：topic_messages");
        return  new Queue("topic_messages");
    }

    //交换机
    @Bean(name = "exchange")
    public TopicExchange exchange(){
        log.info("创建交换机：exchange");
        return new TopicExchange("exchage");
    }

    //Direct交换机的绑定
    @Bean(name = "Direct")
    public Binding bindingExchangeMessage(@Qualifier("topic_message") Queue queueMessage,
                                          @Qualifier("exchange") TopicExchange exchange){
        log.info("Direct交换机的绑定");
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    //Topic交换机的绑定
    @Bean(name = "Topic")
    public Binding bindingExchangeMessages(@Qualifier("topic_messages") Queue queueMessages,
                                           @Qualifier("exchange") TopicExchange exchange){
        log.info("Topic交换机的绑定");
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
