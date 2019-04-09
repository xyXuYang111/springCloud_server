package com.xuyang.springcloud.server_elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerElasticsearchApplication.class, args);
	}

}
