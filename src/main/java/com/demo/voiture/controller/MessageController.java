package com.demo.voiture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.dto.ConversationDto;
import com.demo.voiture.dto.MessageDto;
import com.demo.voiture.dto.MessageUserDto;
import com.demo.voiture.models.Marque;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.User;
import com.demo.voiture.models.message.Conversation;
import com.demo.voiture.services.MessageService;
import com.demo.voiture.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final UserService userService;

    // @GetMapping("/conversation")
    // public Retour allConversation(){
    //     return messageService.all_conversation(null);
    // }

    @GetMapping("/conversation/users")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour allConversation(){
        try {
            User u = userService.getByToken();
            return messageService.all_conversation(u.getIdUsers());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(),"Failed",null);
        }
    }

    @PostMapping("/conversation")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour createConversation(@RequestBody ConversationDto conversationDto) {
        return messageService.create_conversation(conversationDto);
    }

    @GetMapping("/conversation/users/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour createConversation(@PathVariable String id) {
        return messageService.getConversation(id);
    }

    @PostMapping("/envoyer")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour envoyer(@RequestBody MessageDto messageDto) {
        return messageService.sendMessage(messageDto);
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour user_message(@RequestBody MessageUserDto messageDto) {
        return messageService.messages(messageDto);
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour user_message_path(@PathVariable String id) {
        MessageUserDto messageDto = new MessageUserDto(id);
        return messageService.messages(messageDto);
    }
    
}
