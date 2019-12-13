package com.example.consumer1.service.face;

import com.example.commons.vo.result.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

//@FeignClient(value = "PROVIDER-DEMO",path = "file" ,configuration = FeignFormSuportConfig.class)
public interface FileService {
    @PostMapping(value = "upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    Result upload(@RequestPart("file") MultipartFile multipartFile);


    @PostMapping(value = "upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    String upload1(@RequestPart("file") MultipartFile multipartFile);
}
