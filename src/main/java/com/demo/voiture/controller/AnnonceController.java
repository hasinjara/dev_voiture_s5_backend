package com.demo.voiture.controller;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.AnnonceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/annonce")
@RequiredArgsConstructor
public class AnnonceController {

    private final AnnonceService annonceService;

    @GetMapping("")
    public Retour list_annonces() {
        return annonceService.getDetailsAnnonce(null);
    }

    @GetMapping("/{id}")
    public Retour annonce_id(@PathVariable String id) {
        return annonceService.getDetailsAnnonce(id);
    }

    @PostMapping()
    public Retour creer(@RequestBody AnnonceDto annonceDto) {
        return  annonceService.creer(annonceDto); 
    }

    @PutMapping("/{id}")
    public Retour modifier(@PathVariable String id, @RequestBody AnnonceDto annonceDto) {
        return  annonceService.modifier(id,annonceDto);
    }

    @DeleteMapping("/{id}")
    public Retour supprimer(@PathVariable String id) {
        return  annonceService.supprimer(id);
    }




}
