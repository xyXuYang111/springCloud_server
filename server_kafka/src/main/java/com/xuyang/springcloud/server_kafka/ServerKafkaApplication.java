package com.xuyang.springcloud.server_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerKafkaApplication.class, args);
    }

}
