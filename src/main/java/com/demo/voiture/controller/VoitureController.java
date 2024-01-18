package com.demo.voiture.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.demo.voiture.dto.VoitureDto;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour create(@RequestBody VoitureDto voitureDto) {
        return voitureService.create(voitureDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour update(@PathVariable String id, @RequestBody Voiture voitureDto) {
        return voitureService.update(id, voitureDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour delete(@PathVariable String id) {
        return voitureService.delete(id);
    }

    @GetMapping("/marque")
    public Retour listVoituresMarques() {
        return voitureService.findMarque(null);
    }

    @GetMapping("marque/{idMarque}")
    public Retour voitureByIdMarque(@PathVariable String idMarque) {
        return voitureService.findMarque(idMarque);
    }

    @GetMapping("/fiche_tech")
    public Retour listVoituresFicheTech() {
        return voitureService.findFicheTechnique(null);
    }

    @GetMapping("fiche_tech/{id}")
    public Retour voitureByIdFicheTech(@PathVariable String id) {
        return voitureService.findFicheTechnique(id);
    }

}
