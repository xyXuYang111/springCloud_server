package com.xuyang.springcloud.server_quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerQuartzApplication.class, args);
    }

}
