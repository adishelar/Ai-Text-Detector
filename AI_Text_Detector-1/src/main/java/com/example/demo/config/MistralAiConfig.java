package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MistralAiConfig {

    @Value("${mistral.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
