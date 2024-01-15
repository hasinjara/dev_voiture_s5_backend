package com.demo.voiture.models.message;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "conversation")
public class Conversation {
    @Id
    private String id;
    @Field(name="id_participants")
    List<String> idParticipants;
    @Field(name="participants")
    List<String> participants;
}
