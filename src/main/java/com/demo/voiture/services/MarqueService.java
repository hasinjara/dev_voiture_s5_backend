package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.Marque;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.VoitureMarque;
import com.demo.voiture.repositories.MarqueRepository;
import com.demo.voiture.repositories.VoitureMarqueRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MarqueService {
    private final MarqueRepository marqueRepository;
    private final VoitureMarqueRepository voitureMarqueRepository;

    public Retour find(String id) {
        try {
            if (id == null) {
                List<Marque> all = marqueRepository.findAll();
                return new Retour(all);
            } else {
                Marque marque = marqueRepository.findById(id).orElse(null);
                return new Retour(marque);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour findVoitureByIdMarque(String id) {
        try {
            if (id == null) {
                List<VoitureMarque> all = voitureMarqueRepository.findAll();
                return new Retour(all);
            } else {
                List<VoitureMarque> all = voitureMarqueRepository.findByIdMarque(id);
                return new Retour(all);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour create(Marque marque) {
        try {
            return new Retour(marqueRepository.save(marque));
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour update(String id, Marque marque) {
        try {
            Marque update = marqueRepository.findById(id).orElse(null);
            if (update != null) {
                update.setMarque(marque.getMarque());
                marqueRepository.save(update);
            }
            else {
                return new Retour("Id "+ id + " not found");
            }
            return new Retour(null);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour delete(String id) {
        try {
            marqueRepository.deleteById(id);
            return new Retour("Marque supprime id " + id);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }
}
