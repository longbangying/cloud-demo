package com.xbang.consul.consumer.demo;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Configuration
public class ConsulConsumerDemoApplication {

    @Autowired
    DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerDemoApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public  RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @RequestMapping("/ping")
    public Object ping(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-provider-demo");
        if(null == instances || instances.isEmpty()){
            return BaseResult.getResult(ResultEnum.RESULT_SERVICE_UNAVAILABLE,"");
        }
        ServiceInstance serviceInstance = instances.get(0);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity("http://"+ serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/ping", null,Map.class);
        return responseEntity.getBody();
    }


    @RequestMapping("/ping1")
    public Object ping1(){
        ResponseEntity<Map> responseEntity = restTemplate().postForEntity("http://consul-provider-demo/ping",null,Map.class);
        return responseEntity.getBody();
    }
}
