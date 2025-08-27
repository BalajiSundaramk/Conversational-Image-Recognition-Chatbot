package com.example.chatbot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    private final String uploadDir = "uploads";

    public String storeFile(MultipartFile file) throws IOException {
        File dest = new File(uploadDir, file.getOriginalFilename());
        dest.getParentFile().mkdirs();
        file.transferTo(dest);
        return dest.getAbsolutePath();
    }
}
