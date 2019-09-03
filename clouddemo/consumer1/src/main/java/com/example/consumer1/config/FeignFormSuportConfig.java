package com.example.consumer1.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignFormSuportConfig {
    /**
     * 添加feign 文件上传支持
     * @return
     */
    @Bean
    public Encoder encoder (){
        return new SpringFormEncoder();
    }
}
