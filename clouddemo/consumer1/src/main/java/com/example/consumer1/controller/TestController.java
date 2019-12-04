package com.example.consumer1.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import com.example.consumer1.feign.client.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired(required = false)
    TestService testService;

    @RequestMapping("feign/port")
    public Result portForFeign(@RequestParam("sleep") long sleep){
        Result result = null;
        try {
            result = testService.port(sleep);
        } catch (Exception e) {
           log.error("error:{}",e.getMessage());
        }
        return result;
    }

    /**
     * execution.isolation.thread.timeoutInMilliseconds   配置超时阈值
     * coreSize  配置线程信息
     * @param sleep
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")},
            threadPoolProperties = {@HystrixProperty(name = "coreSize",value = "1"),
                                    @HystrixProperty(name = "maxQueueSize",value = "10")
            },threadPoolKey = "hystrix")
    @RequestMapping("port")
    public Result port(@RequestParam("sleep") long sleep){
        ResponseEntity<BaseResult> resultResponseEntity
                = restTemplate.getForEntity("http://PROVIDER-DEMO/test/port?sleep=" + sleep, BaseResult.class);
        return resultResponseEntity.getBody();
    }



    @SuppressWarnings("unused")
    public Result fallbackMethod(long sleep,Throwable throwable){
        log.error("执行回退方法..............{}",sleep);
        log.error(throwable.getMessage(),throwable);
        return BaseResult.getResult(ResultEnum.RESULT_SERVICE_UNAVAILABLE,null);
    }




}
