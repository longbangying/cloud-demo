package com.exmple.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemoApplication.class,args);
    }
}
