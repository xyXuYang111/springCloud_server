package com.xuyang.springcloud.server_redis.controller;

import com.xuyang.springcloud.server_redis.RedisRecevier.MessageReceiver;
import com.xuyang.springcloud.server_redis.RedisSender.MessageSender;
import com.xuyang.springcloud.server_redis.model.MessageModel;
import com.xuyang.springcloud.server_redis.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 00:37
 * @Description:
 */
@Data
@Slf4j
@RestController
public class RedisListenController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping(value = "messageSuccess.do", method = RequestMethod.GET)
    public String messageSuccess(@RequestBody  MessageModel messageModel){
        log.info("消息接受机制");
        log.info("消息内容：" + messageModel.getDesc());
        messageSender.sendMessage(messageModel.toString());
        return "消息机制发送";
    }

    @RequestMapping(value = "messageError.do", method = RequestMethod.GET)
    public String messageError(@RequestBody  MessageModel messageModel){
        log.info("接受成功消息机制");
        log.info("消息内容：" + messageModel.getDesc());
        messageSender.sendMessage(messageModel.toString());
        return "消息机制发送";
    }
}
