package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loinguyen1905.realestate.service.IFileService;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("${release.api.prefix}/files")
public class FileController {
    @Autowired
    private IFileService fileService;

    @Value("${realestate.upload-file.base-uri}")
    private String uri;

    @PostMapping
    public ResponseEntity<Void> upload(
        @RequestParam(name = "file") MultipartFile file,
        @RequestParam(name = "folder") String folderName
    ) throws URISyntaxException, IOException {
        this.fileService.handleCreateDirectory(this.uri + folderName);
        this.fileService.handleUploadFile(this.uri + folderName, file);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(null);
    }
}
