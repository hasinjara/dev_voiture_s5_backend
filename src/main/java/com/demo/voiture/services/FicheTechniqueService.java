package com.demo.voiture.services;

import org.springframework.stereotype.Service;

import com.demo.voiture.dto.FicheTechniqueDto;
import com.demo.voiture.models.FicheTechnique;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.FicheTechniqueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FicheTechniqueService {
    
    private final FicheTechniqueRepository ficheTechniqueRepository;

     public Retour create(FicheTechniqueDto ficheTechniqueDto) {
        try {
            FicheTechnique ficheTechnique = new FicheTechnique(ficheTechniqueDto);
            return new Retour( ficheTechniqueRepository.save(ficheTechnique) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour update(String id, FicheTechniqueDto ficheTechniqueDto) {
        try {
            FicheTechnique update = ficheTechniqueRepository.findById(id).orElse(null);
            if (update != null) {
                update.setIdVoiture(ficheTechniqueDto.getIdVoiture());
                update.setIdEnergie(ficheTechniqueDto.getIdEnergie());
                update.setIdBoite(ficheTechniqueDto.getIdBoite());
                update.setMoteur(ficheTechniqueDto.getMoteur());
                update.setLitreMoteur(ficheTechniqueDto.getLitreMoteur());
                update.setConsommation(ficheTechniqueDto.getConsommation());
                update.setPuissance(ficheTechniqueDto.getPuissance());
                update.setNbVitesse(ficheTechniqueDto.getNbVitesse());
                update.setNbPorte(ficheTechniqueDto.getNbPorte());
                update.setNbPlace(ficheTechniqueDto.getNbPlace());
                update.setLongueur(ficheTechniqueDto.getLongueur());
                update.setPoids(ficheTechniqueDto.getPoids());
                ficheTechniqueRepository.save(update);
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
            ficheTechniqueRepository.deleteById(id);
            return new Retour("Fiche Technique supprime id " + id);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }


}
