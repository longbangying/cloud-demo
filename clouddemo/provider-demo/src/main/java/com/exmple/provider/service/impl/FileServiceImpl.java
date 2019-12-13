package com.exmple.provider.service.impl;

import com.exmple.provider.config.prooertis.FileStoreProperty;
import com.exmple.provider.service.face.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    //配置文件
    private FileStoreProperty fileStoreProperty;
    //文件存放的位置
    private Path path;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public FileServiceImpl(FileStoreProperty fileStoreProperty) {
        this.fileStoreProperty = fileStoreProperty;
        log.info(this.fileStoreProperty.getStorePath());
        path = Paths.get(this.fileStoreProperty.getStorePath()).toAbsolutePath().normalize();

        File file = new File(this.fileStoreProperty.getStorePath());

        if(!file.exists() && !file.mkdir()){
           throw  new RuntimeException("创建文件夹失败");
        }
        file = null;

    }

    /**
     * 保存一个文件
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @Override
    public String storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile == null ){
            return "none";
        }
        String oldName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        int index = oldName.lastIndexOf(".");

        oldName = index > 0 ? oldName.substring(index,oldName.length()) : oldName;

        String fileName = dateTimeFormatter.format(LocalDateTime.now()) + oldName;

        log.info("stored file {} at {} named {}",multipartFile.getOriginalFilename(),path.toString(),fileName);

        Path targetPath = this.path.resolve(fileName);
        Files.copy(multipartFile.getInputStream(),targetPath, StandardCopyOption.REPLACE_EXISTING);
        fileName = ServletUriComponentsBuilder.fromCurrentContextPath().path("/static/").path(fileName).toUriString();
        log.info("file-location:{}" ,fileName);
        return fileName;
    }

    /**
     * 保存多个文件
     * @param multipartFiles
     * @return
     * @throws IOException
     */
    @Override
    public List<String> storeMultipleFile(List<MultipartFile> multipartFiles) throws IOException {
        if(null == multipartFiles || multipartFiles.isEmpty()){
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>(multipartFiles.size());

        for(MultipartFile item : multipartFiles){
            result.add(storeFile(item));
        }
        return result;
    }
}
