package com.exmple.consumerdemo.service.face;

import com.example.commons.vo.result.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(value = "PROVIDER-DEMO",path = "/file")
public interface FileService {

    @RequestMapping("upload")
    Result upload(@RequestPart("file")MultipartFile multipartFile);

    @RequestMapping("uploads")
    Result uploads(@RequestPart("file") List<MultipartFile> multipartFiles);
}
