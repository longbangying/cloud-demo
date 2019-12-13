package com.exmple.provider.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @Value("${server.port}")
    private String port;
    @GetMapping("port")
    public BaseResult<String> test(@RequestParam("sleep") long sleep){
        try {
            Thread.sleep(sleep);  //休眠
        }catch (InterruptedException e){
            log.error(e.getMessage(),e);
            return BaseResult.getResult(ResultEnum.RESULT_EXCEPTION,"");
        }
        log.info(port);
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,port);

    }
}
