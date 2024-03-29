package com.demo.voiture.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.demo.voiture.dto.FicheTechniqueDto;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.FicheTechniqueService;
import com.demo.voiture.services.VoitureService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/voiture_fichetechnique")
@RequiredArgsConstructor
public class FicheTechniqueController {
    private final VoitureService voitureService;
    private final FicheTechniqueService ficheTechniqueService;

    @GetMapping("")
    public Retour listFicheTechVoitures() {
        return ficheTechniqueService.find(null);
    }

    @GetMapping("/{id}")
    public Retour voitureFicheTechById(@PathVariable String id) {
        return ficheTechniqueService.find(id);
    }


    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour create(@RequestBody FicheTechniqueDto ficheTechniqueDto) {
        return ficheTechniqueService.create(ficheTechniqueDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour update(@PathVariable String id, @RequestBody FicheTechniqueDto ficheTechniqueDto) {
        return ficheTechniqueService.update(id, ficheTechniqueDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour delete(@PathVariable String id) {
        return ficheTechniqueService.delete(id);
    }
    
}
