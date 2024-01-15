package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.Categorie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.CategorieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public Retour find(String id) {
        try {
            if (id == null) {
                List<Categorie> all = categorieRepository.findAll();
                return new Retour(all);
            } else {
                Categorie categorie = categorieRepository.findById(id).orElse(null);
                return new Retour(categorie);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour create(Categorie categorie) {
        try {
            return new Retour(categorieRepository.save(categorie));
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour update(String id, Categorie categorie) {
        try {
            Categorie update = categorieRepository.findById(id).orElse(null);
            if (update != null) {
                update.setCategorie(categorie.getCategorie());
                categorieRepository.save(update);
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
            categorieRepository.deleteById(id);
            return new Retour("Categorie supprime id " + id);
        } catch (Exception e) {
            return new Retour(e.getMessage(),"Cette categorie est utilise dans autres relations" ,null);
        }
    }
}
