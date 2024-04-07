package in.shashwat.springai.llama.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.List;

@Slf4j
@Service
public class ChatService {
    private final OllamaChatClient chatClient;
    private final PromptManagementService promptManagementService;

    public ChatService(OllamaChatClient chatClient, PromptManagementService promptManagementService) {
        this.chatClient = chatClient;
        this.promptManagementService = promptManagementService;
    }

    public String establishChat() {
        String chatId = UUID.randomUUID().toString();
        log.debug("Establishing chat with chatId: {}", chatId);
        promptManagementService.establishChat(chatId);
        return chatId;
    }

    public Flux<ChatResponse> chat(String chatId, String message) {
        Message systemMessage = promptManagementService.getSystemMessage(chatId, message);
        UserMessage userMessage = new UserMessage(message);
        promptManagementService.addMessage(chatId, userMessage);
        log.debug("Chatting with chatId: {} and message: {}", chatId, message);
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        return chatClient.stream(prompt);
    }
}
