package com.demo.voiture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.CommissionService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/commission")
@RequiredArgsConstructor
public class CommissionController {
    
    private final CommissionService commissionService;

    @GetMapping("") 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour findAll() {
        return commissionService.findAll();    
    }


}
