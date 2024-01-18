package com.demo.voiture.controller;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.dto.SearchAnnonceDto;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.AnnonceService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("")
    public Retour creer(@RequestBody AnnonceDto annonceDto) {
        return  annonceService.creer(annonceDto); 
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/{id}")
    public Retour modifier(@PathVariable String id, @RequestBody AnnonceDto annonceDto) {
        return  annonceService.modifier(id,annonceDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{id}")
    public Retour supprimer(@PathVariable String id) {
        return  annonceService.supprimer(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/valider/{id}")
    public Retour valider(@PathVariable String id) {
        return annonceService.valider(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/refuser/{id}")
    public Retour refuser(@PathVariable String id) {
        return annonceService.refuser(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/vendre/{id}")
    public Retour vendre(@PathVariable String id) {
        return annonceService.vendre(id);
    }


    @GetMapping("/valider")
    public Retour listvalide() {
        return annonceService.listValide();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/refuser")
    public Retour listrefuse() {
        return annonceService.listRefuse();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/vendre")
    public Retour listvendu() {
        return annonceService.listVendu();
    }

    @GetMapping("/search/{motcle}")
    public Retour seacrh(@PathVariable String motcle) {
        return annonceService.listMotCle(motcle);
    }

    @GetMapping("/search")
    public Retour seacrh(@RequestBody SearchAnnonceDto searchAnnonceDto) {
        //System.out.println(searchAnnonceDto.getKilometrage());
        return annonceService.listMotCle(searchAnnonceDto);
        
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users")
    public Retour findByIdUsers() {
        return annonceService.getDetailsAnnonceIdusers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/test")
    public String test() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
        
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/test1")
    public String test1() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
        
    }
    
    




}
