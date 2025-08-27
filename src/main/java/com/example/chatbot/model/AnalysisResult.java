package com.example.chatbot.model;

public class AnalysisResult {

    private String fileName;   // uploaded file name
    private String analysisText; // prediction result

    // Getter and setter for fileName
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // Getter and setter for analysisText
    public String getAnalysisText() {
        return analysisText;
    }

    public void setAnalysisText(String analysisText) {
        this.analysisText = analysisText;
    }
}
