package com.demo.voiture.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@Configuration
public class FireBaseConfig {
    @Bean
FirebaseMessaging firebaseMessaging() throws IOException {
    GoogleCredentials googleCredentials = GoogleCredentials
            .fromStream(new ClassPathResource("gasy-si-s5-cloud-firebase-adminsdk-7839u-c2b6d2a8e3.json").getInputStream());
    FirebaseOptions firebaseOptions = FirebaseOptions
            .builder()
            .setCredentials(googleCredentials)
            .build();
    FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
    return FirebaseMessaging.getInstance(app);
}
}
