package com.example.demo.controller;

import com.example.demo.entity.ChatResponce;
import com.example.demo.entity.Prompt;
import com.example.demo.entity.TextEntity;
import com.example.demo.entity.UserMessage;
import com.example.demo.service.MistralAiService;
import com.example.demo.service.TextAnalysisService;
import com.example.demo.service.TextService;
import com.example.demo.service.WebScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TextController {

    @Autowired
    private TextAnalysisService textAnalysisService;

    @Autowired
    private WebScrapingService webScrapingService;

    @Autowired
    private TextService textService;

    private final MistralAiService mistralAiService;

    @Autowired
    public TextController(MistralAiService mistralAiService) {
        this.mistralAiService = mistralAiService;
    }

    @PostMapping("/analyze")
    public Mono<AnalysisResponse> analyzeText(@RequestBody String text) {
        return mistralAiService.analyzeText(text)
                .map(analysisResult -> {
                    AnalysisResponse response = new AnalysisResponse();
                    response.setResult(analysisResult);
                    return response;
                });
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponce> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        var prompt = new Prompt(new UserMessage(message));
        return mistralAiService.stream(prompt);
    }

    
    
    
    
    @PostMapping("/save")
    public String saveText(@RequestBody TextEntity textEntity) {
        textService.saveText(textEntity);
        return "Text saved successfully";
    }

    @GetMapping("/texts")
    public List<TextEntity> getTexts() {
        return textService.getTexts();
    }

    @GetMapping("/ai-generated-texts")
    public List<TextEntity> getAiGeneratedTexts() {
        return textService.getAiGeneratedTexts();
    }

    @GetMapping("/texts-by-website")
    public List<TextEntity> getTextsByWebsite(@RequestParam String website) {
        return textService.getTextsByWebsite(website);
    }
}
