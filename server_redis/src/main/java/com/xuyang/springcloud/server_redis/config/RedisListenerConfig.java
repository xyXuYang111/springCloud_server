package com.xuyang.springcloud.server_redis.config;

import com.xuyang.springcloud.server_redis.RedisRecevier.MessageReceiver;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 00:32
 * @Description:
 */
@Data
@Slf4j
@Configuration
public class RedisListenerConfig {

    @Bean(name = "redisMessageListener1")
    public RedisMessageListenerContainer redisMessageListenerContainer(
            @Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory,
            @Qualifier("listenerAdapter") MessageListenerAdapter listenerAdapter){
        log.info("redis服务监听者---redisMessageListener1");
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(jedisConnectionFactory);
        //订阅了一个叫chat 的通道
        redisMessageListenerContainer.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return redisMessageListenerContainer;
    }

    /**
     * 消息监听器适配器，绑定消息处理器，利用反射技术调用消息处理器的业务方法
     * @param receiver
     * @return
     */
    @Bean(name = "listenerAdapter")
    public MessageListenerAdapter listenerAdapter(MessageReceiver receiver) {
        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        //也有好几个重载方法，这边默认调用处理器的方法 叫handleMessage 可以自己到源码里面看
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
