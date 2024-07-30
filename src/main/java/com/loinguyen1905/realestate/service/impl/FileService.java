package com.loinguyen1905.realestate.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.loinguyen1905.realestate.model.dto.FileDTO;
import com.loinguyen1905.realestate.service.IFileService;

@Service
public class FileService implements IFileService {
    @Override
    public void handleCreateDirectory(String folder) throws URISyntaxException {
        URI uri = new URI(folder);
        Path path = Paths.get(uri);
        File tmpDir = new File(path.toString());
        if(!tmpDir.isDirectory()) {
            try {
                Files.createDirectories(tmpDir.toPath());
                System.out.println(">>> Create folder success");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(">>> Exception occurs when try to create new folder");
            }
        } else System.out.println(">>> folder existing");
    }

    @Override
    public FileDTO handleUploadFile(String dest, MultipartFile file) throws URISyntaxException, IOException {
        String uniqueName = System.currentTimeMillis() + "-" + file.getOriginalFilename().replace(" ", "%");
        URI uri = new URI(dest + "/" + uniqueName);
        Path path = Paths.get(uri);
        try(InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        }
        return new FileDTO(uniqueName, Instant.now());
    }
}