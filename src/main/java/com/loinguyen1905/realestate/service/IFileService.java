package com.loinguyen1905.realestate.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    void handleCreateDirectory(String folder) throws URISyntaxException;
    void handleUploadFile(String dest, MultipartFile file) throws URISyntaxException, IOException;
}