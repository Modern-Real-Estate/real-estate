package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loinguyen1905.realestate.model.dto.FileDTO;
import com.loinguyen1905.realestate.service.IFileService;
import com.loinguyen1905.realestate.util.FileValidationUtils;
import com.loinguyen1905.realestate.util.annotation.MetaMessage;

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
    @MetaMessage(message = "Upload file success")
    public ResponseEntity<FileDTO> upload(
        @RequestParam(name = "file", required = false) MultipartFile file,
        @RequestParam(name = "folder") String folderName
    ) throws Exception {
        FileValidationUtils.validation(file);
        this.fileService.handleCreateDirectory(this.uri + folderName);
        return ResponseEntity
            .status(HttpStatus.CREATED.value())
            .body(this.fileService.handleUploadFile(this.uri + folderName, file));
    }
}