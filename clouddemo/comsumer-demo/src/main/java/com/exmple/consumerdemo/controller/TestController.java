package com.exmple.consumerdemo.controller;

import com.exmple.consumerdemo.service.face.TestService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TestService testService;

    @RequestMapping("test")
    public String test(){
        /*ResponseEntity<String> responseEntity =  restTemplate.getForEntity("http://procider-demo/test/port",String.class);
        return responseEntity.getBody();*/
        return testService.test();
    }

}
