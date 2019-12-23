package com.xbang.gateway;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.xbang.gateway.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrixDashboard
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

   /* @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/

}
