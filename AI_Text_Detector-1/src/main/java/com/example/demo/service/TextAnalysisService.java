package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TextAnalysisService {

    @Autowired
    private MistralAiService MistralAiService;

    public Mono<Boolean> isAiGenerated(String text) {
        return MistralAiService.analyzeText(text)
            .map(response -> response.contains("AI Generated")); // Update based on Ollama's response structure
    }
}

