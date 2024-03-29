package com.demo.voiture.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Categorie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.CategorieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorie")
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;

    
    @GetMapping("")
    public Retour listCategories() {
        return categorieService.find(null);
    }

   
    @GetMapping("/{id}")
    public Retour categorieById(@PathVariable String id) {
        return categorieService.find(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public Retour create(@RequestBody Categorie categorie) {
        return categorieService.create(categorie);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public Retour update(@PathVariable String id, @RequestBody Categorie categorieDto) {
        return categorieService.update(id, categorieDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public Retour delete(@PathVariable String id) {
        return categorieService.delete(id);
    }
}
