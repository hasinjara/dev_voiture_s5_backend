package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Energie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.EnergieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/energie")
@RequiredArgsConstructor
public class EnergieController {
    private final EnergieService energieService;

    @GetMapping("")
    public Retour listEnergies() {
        return energieService.find(null);
    }

    @GetMapping("/{id}")
    public Retour energieById(@PathVariable String id) {
        return energieService.find(id);
    }

    @PostMapping()
    public Retour create(@RequestBody Energie energie) {
        return energieService.create(energie);
    }

    @PutMapping("/{id}")
    public Retour update(@PathVariable String id, @RequestBody Energie energieDto) {
        return energieService.update(id, energieDto);
    }

    @DeleteMapping("/{id}")
    public Retour delete(@PathVariable String id) {
        return energieService.delete(id);
    }
}
