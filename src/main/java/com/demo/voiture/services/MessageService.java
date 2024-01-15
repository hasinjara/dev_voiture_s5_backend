package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.dto.MessageDto;
import com.demo.voiture.models.Marque;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.message.Conversation;
import com.demo.voiture.models.message.Message;
import com.demo.voiture.repositories.ConversationRepository;
import com.demo.voiture.repositories.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
    
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    public Retour all_conversation(String participans) {
        try {
            if(participans == null) {
                return new Retour(conversationRepository.findAll());
            }
            else {
                return new Retour(conversationRepository.findByIdParticipantsContains(participans) ); 
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour create_conversation(Conversation conversation) {
        try {
            return new Retour(conversationRepository.save(conversation) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    void verifyIdUsers(String sender, String idConversation) throws Exception {
        try {
            Conversation c = conversationRepository.findById(idConversation).get();
            if( c == null ) {
                throw new Exception("Conversation not found");
            }
            else {
                List<String> idParticipants = c.getIdParticipants();
                boolean in = idParticipants.contains(sender);
                if(in == false ) {
                    throw new Exception("User not in conversation");
                }  
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Retour sendMessage(MessageDto messageDto){
        try {
            verifyIdUsers(messageDto.getSender(), messageDto.getConversationId());
            Message m = new Message(messageDto.getSender(), messageDto.getContent(), messageDto.getConversationId());
            return new Retour(messageRepository.save(m));
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour messages(MessageDto messageDto){
        try {
            verifyIdUsers(messageDto.getSender(), messageDto.getConversationId());
            return new Retour(messageRepository.findByConversationIdOrderByTimeCreated(messageDto.getConversationId()) );
        } catch (Exception e) {
            e.printStackTrace();
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

}
