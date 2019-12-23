package com.example.turbine.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("ping")
    public Result test(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,System.currentTimeMillis());
    }
}
