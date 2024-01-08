package com.demo.voiture.controller;


import com.demo.voiture.dto.SignInRequest;
import com.demo.voiture.dto.SignUpRequest;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public Retour signup(@RequestBody SignUpRequest request) {
        return authenticationService.signup(request);
    }

    @PostMapping("/signin")
    public Retour signin(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }

}
