package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.models.message.NotificationMessage;
import com.demo.voiture.services.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/notif")
@RequiredArgsConstructor
public class NotificationController {
    
    private final FirebaseMessagingService firebaseMessagingService;

    @PostMapping
    public String sendNotif(@RequestBody NotificationMessage notif) {
        //TODO: process POST request
        
        try {
            return firebaseMessagingService.sendNotification(notif);
        } catch (FirebaseMessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "erero";
        }
    }
    

}
