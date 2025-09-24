package com.example.projetoChatGptIntegrado;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @PostMapping
    @RequestMapping("/{animal}")
    public String chat(@PathVariable String animal){
        String pergunta = "Me de a REFICOFAGE desse animal: "+ animal;
        return chatService.gerarResposta(pergunta);
    }
}
