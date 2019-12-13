package com.exmple.consumerdemo.controller;

import com.exmple.consumerdemo.service.face.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("test")
    public String test(){
        return testService.test();
    }

}
