<<<<<<< HEAD
# Conversational-Image-Recognition-Chatbot
An AI-powered chatbot that analyzes uploaded images, identifies objects with high accuracy, and provides clear, interactive results in real-time, combining advanced image recognition and a user-friendly interface.
=======
# Java Image Chatbot (Lite, No Native Deps)

A clean Spring Boot app that analyzes images (brightness, edges, dominant color) without heavy native libraries.
Professional UI with Tailwind (CDN).

## Run
```bash
mvn spring-boot:run
# open http://localhost:8080
```

## What it does
- Computes average brightness
- Computes edge density via Sobel (pure Java)
- Finds dominant color (coarse histogram)
- Generates an edge preview image in `/outputs/...`
- Simple Q&A about the analysis (size, brightness, edges, color)
>>>>>>> c45f2bf (Initial commit)
