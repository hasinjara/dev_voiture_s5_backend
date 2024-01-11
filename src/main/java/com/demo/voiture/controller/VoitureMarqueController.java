package com.demo.voiture.controller;


import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.MarqueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voiture_marque")
@RequiredArgsConstructor
public class VoitureMarqueController {

    private final MarqueService marqueService;


    @GetMapping("")
    public Retour listVoitureMarque() {
        return marqueService.findVoitureByIdMarque(null);
    }

    @GetMapping("/{id}")
    public Retour voitureCategorieById(@PathVariable String id) {
        return marqueService.findVoitureByIdMarque(id);
    }
    
}
