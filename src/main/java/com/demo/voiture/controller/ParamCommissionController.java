package com.demo.voiture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.voiture.models.Retour;
import com.demo.voiture.services.ParamCommissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/param_commission")
@RequiredArgsConstructor
public class ParamCommissionController {
    private final ParamCommissionService paramCommissionService;

    @GetMapping("")
    public Retour paramCommission() {
        return paramCommissionService.find();
    }

    @PutMapping("/{marge}")
    public Retour update(@PathVariable Double marge) {
        return paramCommissionService.update(marge);
    }

}
