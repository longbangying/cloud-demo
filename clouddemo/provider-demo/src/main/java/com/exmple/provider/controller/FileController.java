package com.exmple.provider.controller;

import com.exmple.provider.service.face.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
@Slf4j
public class FileController {

    @Autowired
    FileService fileService;



}
