package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.*;


import com.demo.voiture.models.Retour;
import com.demo.voiture.models.Boite;
import com.demo.voiture.services.BoiteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/boite")
@RequiredArgsConstructor
public class BoiteController {
    private final BoiteService BoiteService;

    @GetMapping("")
    public Retour list_Boites() {
        return BoiteService.find(null);
    }

    @GetMapping("/{id}")
    public Retour boite_id(@PathVariable String id) {
        return BoiteService.find(id);
    }

    @PostMapping()
    public Retour create(@RequestBody Boite boite) {
        return  BoiteService.create(boite); 
    }

    @PutMapping("/{id}")
    public Retour update(@PathVariable String id, @RequestBody Boite BoiteDto) {
        return  BoiteService.update(id,BoiteDto);
    }

    @DeleteMapping("/{id}")
    public Retour delete(@PathVariable String id) {
        return  BoiteService.delete(id);
    }
}
