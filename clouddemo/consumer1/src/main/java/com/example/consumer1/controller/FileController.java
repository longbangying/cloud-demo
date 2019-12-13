package com.example.consumer1.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import com.example.consumer1.service.face.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @Autowired(required = false)
    FileService fileService;


    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile multipartFile){
        return fileService.upload(multipartFile);
    }

    @PostMapping("upload1")
    public Result upload1(@RequestParam("file") MultipartFile multipartFile){
        String result = fileService.upload1(multipartFile);
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,result);
    }
    @GetMapping("test")
    public Result test(){
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,null);

    }
}
