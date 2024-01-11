package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.VoitureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voiture_categorie")
@RequiredArgsConstructor
public class VoitureCategorieController {
    private final VoitureService voitureService;

    @GetMapping("")
    public Retour listCategoriesVoitures() {
        return voitureService.findCategorie(null);
    }

    @GetMapping("/{id}")
    public Retour voitureCategorieById(@PathVariable String id) {
        return voitureService.findCategorie(id);
    }
}
