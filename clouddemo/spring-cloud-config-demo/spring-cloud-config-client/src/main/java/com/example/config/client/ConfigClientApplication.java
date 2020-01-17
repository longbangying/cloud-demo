package com.example.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
@RefreshScope
@RestController
public class ConfigClientApplication {


    @Value("${xbang.name:xbangss}")
    private String xbangName;

    @Value("${xbang.passwd}")
    private String passwd;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
    }

    @PostMapping("info")
    public Map info(){
        Map resultMap = new HashMap();
        resultMap.put("name",xbangName);
        resultMap.put("passwd",passwd);
        return resultMap;
    }
}
