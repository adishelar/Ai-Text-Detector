package com.example.demo.service;

import com.example.demo.config.MistralAiConfig;
import com.example.demo.entity.Prompt;
import com.example.demo.entity.ChatResponce;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MistralAiService {
    private final WebClient webClient;
    private final String apiKey;

    public MistralAiService(WebClient.Builder webClientBuilder, MistralAiConfig MistralAiConfig) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:11434").build();
        this.apiKey = MistralAiConfig.getApiKey();
    }

    public Flux<ChatResponce> stream(Prompt prompt) {
        return webClient.post()
                .uri("/generateStream")
                .bodyValue(prompt)
                .retrieve()
                .bodyToFlux(ChatResponce.class);
    }

    public Mono<String> analyzeText(String text) {
        return webClient.post()
                .uri("/generate")
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue("{\"prompt\":\"" + text + "\"}")
                .retrieve()
                .bodyToMono(String.class);
    }
}
