package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.models.FavorisUserAnnonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.FavorisUserAnnonceService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/favoris_user_annonce")
@RequiredArgsConstructor
public class FavorisUserAnnonceController {
    
    private final FavorisUserAnnonceService favorisUserAnnonceService;
   
    @GetMapping("")
    public Retour findAll() {
        return favorisUserAnnonceService.find(null);
    }

    @GetMapping("/{idUsers}")
    public Retour findByIdUsers(@PathVariable String idUsers) {
        return favorisUserAnnonceService.find(idUsers);
    }

    @PostMapping("")
    public Retour create(@RequestBody FavorisUserAnnonce favorisUserAnnonce) {
        //TODO: process POST request
        return favorisUserAnnonceService.create(favorisUserAnnonce);
    }
    


    @DeleteMapping("/{id}")
    public Retour delete(@PathVariable String id) {
        return favorisUserAnnonceService.delete(id);
    }

    @DeleteMapping("")
    public Retour delete( @RequestBody FavorisUserAnnonce favorisUserAnnonce) {
        return favorisUserAnnonceService.delete(favorisUserAnnonce);
    }



}
