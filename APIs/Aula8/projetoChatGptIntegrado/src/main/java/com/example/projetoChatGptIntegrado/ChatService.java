package com.example.projetoChatGptIntegrado;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatModel chatModel;

    public String gerarResposta(String mensagem){
        Prompt prompt = new Prompt(mensagem);


    }
}
