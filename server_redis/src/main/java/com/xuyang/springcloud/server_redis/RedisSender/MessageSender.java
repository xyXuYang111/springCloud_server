package com.xuyang.springcloud.server_redis.RedisSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 00:26
 * @Description:
 */
@Component
public class MessageSender {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void sendMessage(String message){
        stringRedisTemplate.convertAndSend("chat", message);
    }
}
