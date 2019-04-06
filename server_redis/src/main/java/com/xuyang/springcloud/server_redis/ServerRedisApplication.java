package com.xuyang.springcloud.server_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRedisApplication.class, args);
    }

}
