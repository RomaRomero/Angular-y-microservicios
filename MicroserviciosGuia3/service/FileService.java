package com.MicroserviciosGuia3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.MicroserviciosGuia3.model.FileEntity;
import com.MicroserviciosGuia3.repository.FileRepository;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public void uploadFile(String filename, byte[] fileBytes) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFilename(filename);
        fileEntity.setFileBytes(fileBytes);
        fileRepository.save(fileEntity);
    }
}