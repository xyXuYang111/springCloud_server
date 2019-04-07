package com.xuyang.springcloud.server_ecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerEcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerEcacheApplication.class, args);
    }

}
