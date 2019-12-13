package com.xbang.gateway;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.xbang.gateway.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableConfigurationProperties({TestConfig.class})
public class GateWayApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(GateWayApplication.class, args);
        log.info("网关启动成功...");
        TestConfig testConfig = configurableApplicationContext.getBean(TestConfig.class);
        if(!testConfig.isEnable()){
            System.exit(-1);
        }
        RateLimitProperties rateLimitProperties = configurableApplicationContext.getBean(RateLimitProperties.class);
        if(!rateLimitProperties.isEnabled()){
            configurableApplicationContext.close();
            System.exit(-1);
        }
    }
}
