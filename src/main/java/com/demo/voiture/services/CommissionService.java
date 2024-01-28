package com.demo.voiture.services;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.VCommissionRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CommissionService {
    

    private final VCommissionRepository vCommissionRepository;

    public Retour findAll() {
        try {
            return new Retour(vCommissionRepository.findAll());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

}
