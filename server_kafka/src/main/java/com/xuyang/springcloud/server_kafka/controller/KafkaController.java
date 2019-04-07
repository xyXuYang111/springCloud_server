package com.xuyang.springcloud.server_kafka.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: xuy
 * @Date: 2019/4/8 01:02
 * @Description:
 */
@Data
@Slf4j
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "send.do", method = RequestMethod.GET)
    public String sendKafka() {
        log.info("kafka的消息");
        String message = "消息";
        kafkaTemplate.send("test", "key", message);
        log.info("发送kafka成功.");
        return "kafka消息发送成功";
    }

}
