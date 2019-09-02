package com.exmple.provider.service.face;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    String storeFile(MultipartFile multipartFile) throws IOException;

    List<String> storeMultipleFile(List<MultipartFile> multipartFiles) throws IOException;
}
