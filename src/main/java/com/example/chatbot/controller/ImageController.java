package com.example.chatbot.controller;

import com.example.chatbot.model.AnalysisResult;
import com.example.chatbot.service.ImageRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ImageController {

    @Autowired
    private ImageRecognitionService imageRecognitionService;

    @GetMapping("/")
    public String home() {
        return "upload"; // Upload page
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        // Save uploaded file temporarily
        // Save file to uploads folder
File uploadsDir = new File("C:/image/uploads/");
if (!uploadsDir.exists()) uploadsDir.mkdirs();

File savedFile = new File(uploadsDir, file.getOriginalFilename());
file.transferTo(savedFile);

        // Analyze image
        String analysisText = imageRecognitionService.recognizeImage(savedFile);

        // Populate AnalysisResult
        AnalysisResult result = new AnalysisResult();
        result.setFileName(file.getOriginalFilename());
        result.setAnalysisText(analysisText);

        model.addAttribute("result", result);

        return "result"; // Result page
    }
}
