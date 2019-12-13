package com.exmple.consumerdemo.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 添加feign 文件上传的支持
     * @return
     */
   /* @Bean
    public Encoder springFormEncoder(){
        return new SpringFormEncoder();
    }*/

    /*@Bean
    public IRule iRule(){

        return new RandomRule();

    }*/




    public static  class  MyRule  extends AbstractLoadBalancerRule {

        @Override
        public void initWithNiwsConfig(IClientConfig iClientConfig) {

        }

        @Override
        public Server choose(Object o) {
            return null;
        }
    }






}
