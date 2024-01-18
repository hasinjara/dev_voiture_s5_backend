package com.demo.voiture.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.voiture.models.message.Conversation;
import java.util.List;


public interface ConversationRepository extends MongoRepository<Conversation, String> {
    List<Conversation> findByParticipants(List<String> participants);
    List<Conversation> findByParticipantsContains(String participant);
    List<Conversation> findByIdParticipantsContains(String participant);
    Conversation findByIdParticipants(List<String> idParticipants);
    
}
