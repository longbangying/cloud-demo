package com.exmple.consumerdemo.controller;

import com.example.commons.vo.result.Result;
import com.exmple.consumerdemo.service.face.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("file")
@Slf4j
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 上传单个文件
     * @param multipartFile
     * @return
     */
    @PostMapping("upload")
    public Result upload(@RequestParam("file")MultipartFile multipartFile){
        return fileService.upload(multipartFile);
    }

    /**
     * 上传多个文件
     * @param multipartFiles
     * @return
     */
    @PostMapping("uploads")
    public Result uploads(@RequestParam("file") List<MultipartFile> multipartFiles){
        return fileService.uploads(multipartFiles);
    }
}
