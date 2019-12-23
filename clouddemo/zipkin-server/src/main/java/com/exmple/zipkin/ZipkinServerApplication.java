package com.exmple.zipkin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import zipkin.storage.mysql.MySQLStorage;
import zipkin2.autoconfigure.storage.mysql.TracingZipkinMySQLStorageAutoConfiguration;
import zipkin2.server.internal.EnableZipkinServer;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
@EnableHystrixDashboard
@Transactional
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class,args);
        log.info("ZipkinServer 启动成功.");
    }

    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }
}
