package com.xbang.oauth2.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("test")
public class TestController {
    @PostMapping("sayHi")
    public Result sayHi(){
        log.info("sayHi...............................................");
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"HI");
    }

    @GetMapping("page")
    public Result test(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"success");
    }
}
