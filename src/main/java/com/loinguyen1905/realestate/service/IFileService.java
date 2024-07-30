package com.loinguyen1905.realestate.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import com.loinguyen1905.realestate.model.dto.FileDTO;

public interface IFileService {
    void handleCreateDirectory(String folder) throws URISyntaxException;
    FileDTO handleUploadFile(String dest, MultipartFile file) throws URISyntaxException, IOException;
    Long getFileLength(String fileName, String dest) throws URISyntaxException;
    InputStreamResource getResource(String fileName, String dest) throws FileNotFoundException, URISyntaxException;
}