package com.springai.ollama_llama_llm;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class LlamaService {

    private final OllamaChatModel ollamaChatModel;

    public LlamaService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public String generateResponse(String prompt) {
        ChatResponse response = ollamaChatModel.call(new Prompt(prompt));
        return response.getResult().getOutput().getContent();
    }

    public Flux<String> generateStreamResponse(String propmt) {
        Flux<String> response = ollamaChatModel.stream(propmt);
        return response;
    }
}
