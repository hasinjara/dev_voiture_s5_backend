package com.demo.voiture.models.message;

import java.util.Date;
import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "message")
public class Message {
    @Id
    private String id;

    private String sender;
    private String content;
    private Date timeCreated;
    private String conversationId;
    
    public Message(String sender, String content, String conversationId) {
        this.sender = sender;
        this.content = content;
        this.conversationId = conversationId;
        this.timeCreated = new Date(System.currentTimeMillis()) ;
    }

    

}
