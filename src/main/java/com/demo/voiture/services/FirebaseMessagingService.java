package com.demo.voiture.services;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.message.NotificationMessage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;



@Service
public class FirebaseMessagingService {
    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(NotificationMessage notif) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(notif.getTitle())
                .setBody(notif.getBody())
                .setImage(notif.getImage())
                .build();

        Message message = Message
                .builder()
                .setToken(notif.getRecipientToken())
                .setNotification(notification)
                .putAllData(notif.getData())
                .build();
        
        try {
            return firebaseMessaging.send(message);
        } catch (FirebaseMessagingException e) {
            // TODO: handle exception
            throw e;
        }

        
    }
}
