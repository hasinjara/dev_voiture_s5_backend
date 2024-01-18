package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.demo.voiture.models.Boite;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.BoiteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoiteService {
    private final BoiteRepository boiteRepository;

    public Retour find(String id) {
        try {
            if(id == null) {
                List<Boite> all = boiteRepository.findAll();
                return  new Retour(all);
            }
            else {
                Boite boite = boiteRepository.findById(id).orElse(null);
                return new Retour(boite);
            }

        }
        catch (Exception e) {
            return  new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour create(Boite boite) {
        try {
            return new Retour( boiteRepository.save(boite) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour update(String id , Boite boite) {
        try {
            Boite update = boiteRepository.findById(id).get();
            update.setBoite(boite.getBoite());
            return new Retour( "aucun","Update resussi",boiteRepository.save(update));
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour delete(String id) {
        try {
            boiteRepository.deleteById(id);
            return new Retour("Boite supprime id "+id) ;
        }
        catch (Exception e) {
            return new Retour(e.getMessage(), "Cette boite est utilise dans autre relation",null);
        }
    }


}
