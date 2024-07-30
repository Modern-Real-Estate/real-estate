package com.loinguyen1905.realestate.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.multipart.MultipartFile;

import com.loinguyen1905.realestate.model.dto.FileDTO;

public interface IFileService {
    void handleCreateDirectory(String folder) throws URISyntaxException;
    FileDTO handleUploadFile(String dest, MultipartFile file) throws URISyntaxException, IOException;
}