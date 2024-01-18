package com.demo.voiture.controller;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.StatGlobalService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat_global")
@RequiredArgsConstructor
public class StatGlobalController {

    private final StatGlobalService statGlobalService;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour stat() {
        return statGlobalService.all_stat();
    }


}
