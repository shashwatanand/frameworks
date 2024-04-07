package in.shashwat.springai.llama.controller;

import in.shashwat.springai.llama.dto.LlamaResponse;
import in.shashwat.springai.llama.service.ChatService;
import in.shashwat.springai.llama.service.ILlamaAiService;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class LlamaRestController {
    private final ILlamaAiService llamaAiService;
    private final ChatService chatService;

    @Autowired
    public LlamaRestController(ILlamaAiService llamaAiService, ChatService chatService) {
        this.llamaAiService = llamaAiService;
        this.chatService = chatService;
    }

    @GetMapping("api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(
            @RequestParam(value = "promptMessage", defaultValue = "Why is the sky blue?")
            String promptMessage) {
        final LlamaResponse aiResponse = llamaAiService.generateMessage(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @GetMapping("api/v1/ai/generate/joke/{topic}")
    public ResponseEntity<LlamaResponse> generateJoke(@PathVariable String topic) {
        final LlamaResponse aiResponse = llamaAiService.generateJoke(topic);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @GetMapping("api/v1/ai/{message}")
    public Flux<ChatResponse> question(@PathVariable String message) {
        String chatId = chatService.establishChat();
        return chatService.chat(chatId, message);
    }
}
