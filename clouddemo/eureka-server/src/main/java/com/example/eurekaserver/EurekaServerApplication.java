package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {

        /*Scanner scanner =new Scanner(System.in);

        String profile = scanner.nextLine();

        new SpringApplicationBuilder(EurekaServerApplication.class).web(WebApplicationType.SERVLET).profiles(profile).run(args);*/

        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
