package com.demo.voiture.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.voiture.dto.ConversationDto;
import com.demo.voiture.dto.MessageDto;
import com.demo.voiture.dto.MessageUserDto;
import com.demo.voiture.models.Marque;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.User;
import com.demo.voiture.models.message.Conversation;
import com.demo.voiture.models.message.Message;
import com.demo.voiture.models.message.NotificationMessage;
import com.demo.voiture.repositories.ConversationRepository;
import com.demo.voiture.repositories.MessageRepository;
import com.demo.voiture.repositories.UserRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
    
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final FirebaseMessagingService firebaseMessagingService;

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

    public void verifyConversationExist(String id1, String id2) throws Exception {
        try {
            List<String> cmb1 = new ArrayList<String>();
            List<String> cmb2 = new ArrayList<String>();

            cmb1.add(id2);
            cmb1.add(id1);

            cmb2.add(id1);
            cmb2.add(id2);

            Conversation c1 = conversationRepository.findByIdParticipants(cmb2);
            Conversation c2 = conversationRepository.findByIdParticipants(cmb1);
            boolean exist = true;
            if(c1 == null && c2 == null) {
                exist = false;
            }

            if(exist) {
                throw new Exception("Cette conversation existe deja");
            }

        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }


    public Retour create_conversation(ConversationDto conversationDto) {
        try {
            User u = userService.getByToken();
            
            if(u.getIdUsers().compareTo(conversationDto.getIdUsers()) == 0) {
                return new Retour("Meme user", "Failed", null);
            }

            verifyConversationExist(u.getIdUsers(), conversationDto.getIdUsers());
            
        
            Conversation conversation = new Conversation();
            //id participants
            List<String> idParticipants = new ArrayList<String>();
            idParticipants.add(u.getIdUsers());
            idParticipants.add(conversationDto.getIdUsers());
            // participants
            List<String> participants = new ArrayList<String>();
            participants.add(u.getNom() + " "+ u.getPrenom());
            User find = userRepository.findById(conversationDto.getIdUsers()).orElse(null);
            if(find == null) {
                return new Retour("ID user not found", "Failed", null);
            }
            if(find.getRole().name().compareToIgnoreCase("ROLE_ADMIN") == 0) {
                return new Retour("Ne peut pas creer une conversation avec admin ", "Failed", null);
            }
            participants.add(find.getNom() + " "+find.getPrenom());

            conversation.setIdParticipants(idParticipants);
            conversation.setParticipants(participants);
            
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
            User u = userService.getByToken();
            verifyIdUsers(u.getIdUsers(), messageDto.getConversationId());
            Message m = new Message(u.getIdUsers(), messageDto.getContent(), messageDto.getConversationId());
            Message send = messageRepository.save(m);
            NotificationMessage notificationMessage = new NotificationMessage();
            if(u.getFirebaseToken() != null) {
                Map<String, String> data = new HashMap<>();

                // Ajout de données
                data.put("sender", u.getNom());
                data.put("content", send.getContent()  );
                data.put("date", send.getTimeCreated().toString());

                
                String userDateSend = u.getNom() + " " + u.getPrenom() + " " + send.getTimeCreated();
                notificationMessage.setRecipientToken(u.getFirebaseToken());
                notificationMessage.setTitle(userDateSend);
                notificationMessage.setBody(send.getContent());
                notificationMessage.setImage("");
                notificationMessage.setData(data);
                firebaseMessagingService.sendNotification(notificationMessage);
            }
            return new Retour(send);
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour getConversation(String id) {
        try {
            String id1 = id;
            User u = userService.getByToken();
            String id2 = u.getIdUsers();
            List<String> cmb1 = new ArrayList<String>();
            List<String> cmb2 = new ArrayList<String>();

            cmb1.add(id2);
            cmb1.add(id1);

            cmb2.add(id1);
            cmb2.add(id2);
            Conversation c1 = conversationRepository.findByIdParticipants(cmb2);
            Conversation c2 = conversationRepository.findByIdParticipants(cmb1);
            if(c1 != null) {
                return new Retour(c1) ;
            }
            return new Retour(c2);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour messages(MessageUserDto messageDto){
        try {
            User u = userService.getByToken();
            verifyIdUsers(u.getIdUsers(), messageDto.getConversationId());
            return new Retour(messageRepository.findByConversationIdOrderByTimeCreated(messageDto.getConversationId()) );
        } catch (Exception e) {
            e.printStackTrace();
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

}
