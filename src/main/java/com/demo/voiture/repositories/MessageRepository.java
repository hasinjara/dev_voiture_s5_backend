package com.demo.voiture.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.voiture.models.message.Message;
import java.util.List;
import java.sql.Date;


public interface MessageRepository extends MongoRepository<Message, String> { 
    List<Message> findByConversationIdOrderByTimeCreated(String conversationId);
    List<Message> findByConversationId(String conversationId);
}
