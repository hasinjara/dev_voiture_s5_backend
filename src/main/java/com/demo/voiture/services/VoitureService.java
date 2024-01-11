package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.Categorie;
import com.demo.voiture.models.DetailsFicheTechniques;
import com.demo.voiture.models.DetailsVoitureCategorie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.Voiture;
import com.demo.voiture.models.VoitureCategorie;
import com.demo.voiture.models.VoitureMarque;
import com.demo.voiture.repositories.DetailsFicheTechniquesRepository;
import com.demo.voiture.repositories.DetailsVoitureCategorieRepository;
import com.demo.voiture.repositories.DetailsVoitureRepository;
import com.demo.voiture.repositories.VoitureCategorieRepository;
import com.demo.voiture.repositories.VoitureMarqueRepository;
import com.demo.voiture.repositories.VoitureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoitureService {
    private final VoitureRepository voitureRepository;
    private final DetailsFicheTechniquesRepository detailsFicheTechniquesRepository;
    private final DetailsVoitureCategorieRepository detailsVoitureCategorieRepository;
    private final DetailsVoitureRepository detailsVoitureRepository;
    private final VoitureCategorieRepository voitureCategorieRepository;
    private final VoitureMarqueRepository voitureMarqueRepository;


    public Retour findCategorie(String id) {
        try {
            if (id == null) {
                List<DetailsVoitureCategorie> all = detailsVoitureCategorieRepository.findAll();
                return new Retour(all);
            } else {
                List<DetailsVoitureCategorie>  voitureCategorie = detailsVoitureCategorieRepository.findByIdVoiture(id);
                return new Retour(voitureCategorie);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour findFicheTechnique(String id) {
        try {
            if (id == null) {
                List<DetailsFicheTechniques > all = detailsFicheTechniquesRepository.findAll();
                return new Retour(all);
            } else {
                List<DetailsFicheTechniques >  DetailsFicheTechniques  = detailsFicheTechniquesRepository.findByIdVoiture(id);
                return new Retour(DetailsFicheTechniques );
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }


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
            voitureRepository.deleteById(id);
            return new Retour("Voiture supprime id " + id);
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }
}
