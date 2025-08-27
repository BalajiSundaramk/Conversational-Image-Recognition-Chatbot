package com.example.chatbot.service;

import ai.djl.Application;
import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.translate.TranslateException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ImageRecognitionService {

    public String recognizeImage(File file) {
        try {
            Image img = ImageFactory.getInstance().fromFile(file.toPath());

            Criteria<Image, Classifications> criteria =
                    Criteria.builder()
                            .optApplication(Application.CV.IMAGE_CLASSIFICATION)
                            .setTypes(Image.class, Classifications.class)
                            .optFilter("layers", "50")
                            .build();

            try (ZooModel<Image, Classifications> model = ModelZoo.loadModel(criteria);
                 Predictor<Image, Classifications> predictor = model.newPredictor()) {

                Classifications.Classification best = predictor.predict(img).best();
                return "This image likely contains: " + best.getClassName() +
                        " (confidence: " + String.format("%.2f", best.getProbability() * 100) + "%)";
            }

        } catch (IOException | ModelException | TranslateException e) {
            e.printStackTrace();
            return "⚠️ Unable to analyze the image. Please try again.";
        }
    }
}
