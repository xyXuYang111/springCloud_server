package com.xuyang.springcloud.server_redis.RedisRecevier;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 00:27
 * @Description:
 */
@Data
@Slf4j
@Component
public class MessageReceiver {

    public void receiveMessage(String message){
        log.info("测试接受数据");
        log.info("测试接受的数据：" + message);
    }
}
