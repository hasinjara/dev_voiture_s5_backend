package com.demo.voiture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.dto.MessageDto;
import com.demo.voiture.dto.MessageUserDto;
import com.demo.voiture.models.Marque;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.message.Conversation;
import com.demo.voiture.services.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    // @GetMapping("/conversation")
    // public Retour allConversation(){
    //     return messageService.all_conversation(null);
    // }

    @GetMapping("/conversation/{idUsers}")
    public Retour allConversation(@PathVariable String idUsers){
        List<String> id = new ArrayList<String>();
        id.add(idUsers);
        return messageService.all_conversation(idUsers);
    }

    @PostMapping("/conversation")
    public Retour createConversation(@RequestBody Conversation conversation) {
        return messageService.create_conversation(conversation);
    }

    @PostMapping("/envoyer")
    public Retour envoyer(@RequestBody MessageDto messageDto) {
        return messageService.sendMessage(messageDto);
    }

    @GetMapping("/user")
    public Retour user_message(@RequestBody MessageUserDto messageDto) {
        return messageService.messages(messageDto);
    }
    
}
