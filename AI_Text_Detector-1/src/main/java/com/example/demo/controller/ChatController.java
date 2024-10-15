package com.example.demo.controller;

import com.example.demo.entity.ChatResponce;

import com.example.demo.entity.Prompt;
import com.example.demo.entity.UserMessage;
import com.example.demo.entity.UserMessage;
import com.example.demo.service.MistralAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final MistralAiService mistralAiService;

    @Autowired
    public ChatController(MistralAiService mistralAiService) {
        this.mistralAiService = mistralAiService;
    }

    @GetMapping("/ai/generate")
    public Mono<Map<String, String>> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return mistralAiService.analyzeText(message)
                .map(generation -> Map.of("generation", generation)); // Map the response to a key-value pair
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponce> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        var prompt = new Prompt(new UserMessage(message));
        // Assuming Mistral supports streaming responses
        return mistralAiService.stream(prompt);
    }
}
