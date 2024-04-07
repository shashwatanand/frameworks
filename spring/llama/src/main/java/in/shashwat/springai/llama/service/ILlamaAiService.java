package in.shashwat.springai.llama.service;

import in.shashwat.springai.llama.dto.LlamaResponse;

public interface ILlamaAiService {
    LlamaResponse generateMessage(String prompt);
    LlamaResponse generateJoke(String topic);
}
