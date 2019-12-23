package com.exmple.provider;


import com.exmple.provider.config.prooertis.FileStoreProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableDiscoveryClient
@EnableConfigurationProperties({FileStoreProperty.class})
@EnableHystrixDashboard
public class ProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDemoApplication.class,args);
    }
}
