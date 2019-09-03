package com.exmple.provider.controller;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.commons.vo.result.ResultEnum;
import com.exmple.provider.service.face.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("file")
@Slf4j
public class FileController {

    @Autowired
    FileService fileService;

    /**
     * 单文件上传
     * @param multipartFile
     * @return
     */
    @RequestMapping("upload")
    public BaseResult<String> upload(@RequestParam ("file")MultipartFile multipartFile){
        try {
            return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,fileService.storeFile(multipartFile));
        }catch (IOException ex){
            log.error(ex.getMessage(),ex);
            return BaseResult.getResult(ResultEnum.RESULT_EXCEPTION,null);
        }
    }

    /**
     * 上传多个文件
     * @param multipartFiles
     * @return
     */
    @RequestMapping("uploads")
    public BaseResult<List<String>> uploads(@RequestParam("files")List<MultipartFile> multipartFiles){
        try{
            return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,fileService.storeMultipleFile(multipartFiles));
        }catch (IOException ex){
            return BaseResult.getResult(ResultEnum.RESULT_EXCEPTION,null);
        }
    }

}
