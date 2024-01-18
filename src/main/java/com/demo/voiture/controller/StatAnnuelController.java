package com.demo.voiture.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.StatAnnuelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stat_annuel")
@RequiredArgsConstructor
public class StatAnnuelController {
    
    private final StatAnnuelService statAnnuelService;

    @GetMapping("/{anne}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Retour stat(@PathVariable int anne) {
        return statAnnuelService.all_stat( anne);
    }

}
