package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/valider/{id}")
    public Retour valider(@PathVariable String id) {
        return annonceService.valider(id);
    }

    @GetMapping("/refuser/{id}")
    public Retour refuser(@PathVariable String id) {
        return annonceService.refuser(id);
    }

    @GetMapping("/vendre/{id}")
    public Retour vendre(@PathVariable String id) {
        return annonceService.vendre(id);
    }
}
