package com.springai.ollama_llama_llm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ChatController {
    private final LlamaService llamaService;

    public ChatController(LlamaService llamaService) {
        this.llamaService = llamaService;
    }

    @GetMapping("/ai/generate")
    public String generateResponse(@RequestParam(value = "prompt", defaultValue = "what is spring ai?") String prompt) {
        log.info("Sending prompt:: {} to Llama model ", prompt);
        return llamaService.generateResponse(prompt);
    }

    @GetMapping("/ai/generateStream")
    public Flux<String> generateStreamResponse(@RequestParam(value = "prompt", defaultValue = "what is python") String prompt) {
        log.info("Sending prompt message:: {} to Llama model ", prompt);
        return llamaService.generateStreamResponse(prompt);
    }
}
