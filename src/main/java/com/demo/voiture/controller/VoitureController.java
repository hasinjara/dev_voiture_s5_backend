package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Retour;
import com.demo.voiture.models.Voiture;
import com.demo.voiture.services.VoitureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/voiture")
@RequiredArgsConstructor
public class VoitureController {
    private final VoitureService voitureService;

    @GetMapping("")
    public Retour listVoitures() {
        return voitureService.find(null);
    }

    @GetMapping("/{id}")
    public Retour voitureById(@PathVariable String id) {
        return voitureService.find(id);
    }

    @PostMapping()
    public Retour create(@RequestBody Voiture voiture) {
        return voitureService.create(voiture);
    }

    @PutMapping("/{id}")
    public Retour update(@PathVariable String id, @RequestBody Voiture voitureDto) {
        return voitureService.update(id, voitureDto);
    }

    @DeleteMapping("/{id}")
    public Retour delete(@PathVariable String id) {
        return voitureService.delete(id);
    }
}
