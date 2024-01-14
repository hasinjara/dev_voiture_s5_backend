package com.demo.voiture.controller;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.StatMensuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat_mensuel")
@RequiredArgsConstructor
public class StatMensuelController {

    private final StatMensuelService statMensuelService;

    @GetMapping("/{mois}/{anne}")
    public Retour stat(@PathVariable int mois, @PathVariable int anne) {
        return statMensuelService.all_stat(mois, anne);
    }

}
