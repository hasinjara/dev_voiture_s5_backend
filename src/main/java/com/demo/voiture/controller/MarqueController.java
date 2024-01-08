package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.voiture.models.Marque;
import com.demo.voiture.models.Retour;
import com.demo.voiture.services.MarqueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/marque")
@RequiredArgsConstructor
public class MarqueController {
    private final MarqueService marqueService;

    @GetMapping("")
    public Retour listMarques() {
        return marqueService.find(null);
    }

    @GetMapping("/{id}")
    public Retour marqueById(@PathVariable String id) {
        return marqueService.find(id);
    }

    @PostMapping()
    public Retour create(@RequestBody Marque marque) {
        return marqueService.create(marque);
    }

    @PutMapping("/{id}")
    public Retour update(@PathVariable String id, @RequestBody Marque marqueDto) {
        return marqueService.update(id, marqueDto);
    }

    @DeleteMapping("/{id}")
    public Retour delete(@PathVariable String id) {
        return marqueService.delete(id);
    }
}
