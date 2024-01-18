package com.demo.voiture.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.AnnonceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/valider")
@RequiredArgsConstructor
public class ValdationController {

    private final AnnonceService annonceService;
    
    @PutMapping("/valider/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour valider(@PathVariable String id) {
        return annonceService.valider(id);
    }

    @PutMapping("/refuser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour refuser(@PathVariable String id) {
        return annonceService.refuser(id);
    }

    @PutMapping("/vendre/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour vendre(@PathVariable String id) {
        return annonceService.vendre(id);
    }
}
