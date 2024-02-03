package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.VVoitureCategorieRepository;
import com.demo.voiture.services.VoitureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voiture_categorie")
@RequiredArgsConstructor
public class VoitureCategorieController {
    private final VoitureService voitureService;
    private final VVoitureCategorieRepository vVoitureCategorieRepository;

    @GetMapping("")
    public Retour listCategoriesVoitures() {
        return new Retour(vVoitureCategorieRepository.findAll());
    }

    @GetMapping("/{id}")
    public Retour voitureCategorieById(@PathVariable String id) {
        return new Retour( vVoitureCategorieRepository.findById(id) );
    }
}
