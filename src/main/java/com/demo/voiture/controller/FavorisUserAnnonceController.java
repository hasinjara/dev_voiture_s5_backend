package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.models.FavorisUserAnnonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.User;
import com.demo.voiture.services.FavorisUserAnnonceService;
import com.demo.voiture.services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
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
    private final UserService userService;
   
    @GetMapping("/all")
    public Retour findAll() {
        return favorisUserAnnonceService.find(null);
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour findByIdUsers() {
        try {
            User u = userService.getByToken();
            return favorisUserAnnonceService.find(u.getIdUsers());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(),"Failed",null);
        }
        
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour create(@RequestBody FavorisUserAnnonce favorisUserAnnonce) {
        //TODO: process POST request
        return favorisUserAnnonceService.create(favorisUserAnnonce);
    }
    

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour delete(@PathVariable String id) {
        return favorisUserAnnonceService.delete(id);
    }

    @DeleteMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Retour delete( @RequestBody FavorisUserAnnonce favorisUserAnnonce) {
        return favorisUserAnnonceService.delete(favorisUserAnnonce);
    }



}
