package com.xuyang.springcloud.server_kafka.listener;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuy
 * @Date: 2019/4/8 00:58
 * @Description: topics 和send方法有关，第一个属性值就是这个意思
 */
@Data
@Slf4j
@Component
public class KafkConsumerListener {

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("kafka的key: " + record.key());
        log.info("kafka的value: " + record.value().toString());
    }
}
