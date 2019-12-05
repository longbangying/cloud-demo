package com.xbang.resource.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class TestController {
    @PostMapping("test")
    public Result test(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"success");
    }
}
