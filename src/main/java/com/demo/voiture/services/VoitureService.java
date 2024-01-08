package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.Retour;
import com.demo.voiture.models.Voiture;
import com.demo.voiture.repositories.VoitureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoitureService {
    private final VoitureRepository voitureRepository;

    public Retour find(String id) {
        try {
            if (id == null) {
                List<Voiture> all = voitureRepository.findAll();
                return new Retour(all);
            } else {
                Voiture voiture = voitureRepository.findById(id).orElse(null);
                return new Retour(voiture);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour create(Voiture voiture) {
        try {
            return new Retour(voitureRepository.save(voiture));
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour update(String id, Voiture voiture) {
        try {
            Voiture update = voitureRepository.findById(id).orElse(null);
            if (update != null) {
                update.setNomModele(voiture.getNomModele());
                update.setAnneSortie(voiture.getAnneSortie());
                update.setIdMarque(voiture.getIdMarque());
                voitureRepository.save(update);
            }
            return new Retour(null);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour delete(String id) {
        try {
            voitureRepository.deleteById(id);
            return new Retour("Voiture supprime id " + id);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }
}
