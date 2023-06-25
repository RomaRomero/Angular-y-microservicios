package com.MicroserviciosGuia3.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.MicroserviciosGuia3.service.FileService;

@RestController
@RequestMapping("/api/files")
@Api(tags = "File API")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("Subir archivo")
    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        byte[] fileBytes;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            // Manejo de excepciones si ocurre un error al obtener los bytes del archivo
            throw new RuntimeException("Error al obtener los bytes del archivo", e);
        }
        fileService.uploadFile(file.getOriginalFilename(), fileBytes);
    }
}