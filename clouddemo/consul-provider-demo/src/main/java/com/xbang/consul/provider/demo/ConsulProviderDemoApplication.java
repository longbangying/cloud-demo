package com.xbang.consul.provider.demo;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderDemoApplication.class,args);
    }

    @RequestMapping("/ping")
    public Result ping(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"pong");
    }
}
