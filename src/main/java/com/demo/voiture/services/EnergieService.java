package com.demo.voiture.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.Energie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.EnergieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnergieService {
    private final EnergieRepository energieRepository;

    public Retour find(String id) {
        try {
            if (id == null) {
                List<Energie> all = energieRepository.findAll();
                return new Retour(all);
            } else {
                Energie energie = energieRepository.findById(id).orElse(null);
                return new Retour(energie);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour create(Energie energie) {
        try {
            return new Retour(energieRepository.save(energie));
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour update(String id, Energie energie) {
        try {
            Energie update = energieRepository.findById(id).orElse(null);
            if (update != null) {
                update.setEnergie(energie.getEnergie());
                energieRepository.save(update);
            }
            else {
                return new Retour("Id "+ id + " not found",null);
            }
            return new Retour(null);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour delete(String id) {
        try {
            energieRepository.deleteById(id);
            return new Retour("Energie supprime id " + id);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }
}
