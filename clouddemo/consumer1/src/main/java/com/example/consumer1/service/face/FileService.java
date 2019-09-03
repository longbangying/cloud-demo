package com.example.consumer1.service.face;

import com.example.commons.vo.result.BaseResult;
import com.example.commons.vo.result.Result;
import com.example.consumer1.config.FeignFormSuportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

//@FeignClient(value = "PROVIDER-DEMO",path = "file" ,configuration = FeignFormSuportConfig.class)
public interface FileService {
    @RequestMapping(value = "upload",method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    Result upload(@RequestPart("file") MultipartFile multipartFile);


    @RequestMapping(value = "upload",method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    String upload1(@RequestPart("file") MultipartFile multipartFile);
}
