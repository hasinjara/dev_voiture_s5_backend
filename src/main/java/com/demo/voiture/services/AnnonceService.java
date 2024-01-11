package com.demo.voiture.services;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.DetailsAnnonce;
import com.demo.voiture.models.DetailsFicheTechniques;
import com.demo.voiture.models.DetailsVoitureCategorie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.AnnonceRepository;
import com.demo.voiture.repositories.DetailsAnnonceRepository;
import com.demo.voiture.repositories.DetailsFicheTechniquesRepository;
import com.demo.voiture.repositories.DetailsVoitureCategorieRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnonceService {

    private final DetailsAnnonceRepository detailsAnnonceRepository;
    private final AnnonceRepository annonceRepository;
    private final DetailsFicheTechniquesRepository detailsFicheTechniquesRepository;
    private final DetailsVoitureCategorieRepository detailsVoitureCategorieRepository;

    public Retour getDetailsAnnonce(String id) {
        try {
            if(id == null) {
                List<DetailsAnnonce> all = detailsAnnonceRepository.findAll();
                return  new Retour(all);
            }
            else {
                DetailsAnnonce detail = detailsAnnonceRepository.findById(id).orElse(null);
                return new Retour(detail);
            }

        }
        catch (Exception e) {
            return  new Retour(e.getMessage(), "Failed", null);
        }
    }

    void verifyCategAndFicheTech(AnnonceDto annonceDto) throws Exception {
        try {
            List<DetailsVoitureCategorie>  voitureCategorie = detailsVoitureCategorieRepository.findByIdVoiture(annonceDto.getIdVoiture());
            boolean categ_exist = false;
            for (DetailsVoitureCategorie detailsVoitureCategorie : voitureCategorie) {
                if(detailsVoitureCategorie.getIdCategorie().compareTo(annonceDto.getIdCategorie()) == 0) {
                    categ_exist = true;
                    break;
                }
            }
            if(categ_exist == false) {
                throw new Exception("Cette categorie n'existe pas sur cette voiture");
            }

            List<DetailsFicheTechniques >  DetailsFicheTechniques  = detailsFicheTechniquesRepository.findByIdVoiture(annonceDto.getIdVoiture());
            boolean fiche_exist = false;
            for (DetailsFicheTechniques detailsFt : DetailsFicheTechniques) {
                if(detailsFt.getIdFicheTechnique().compareTo(annonceDto.getIdFicheTechnique()) == 0 ){
                    fiche_exist = true;
                }
            }
            if(fiche_exist == false) {
                throw new Exception("Cette fiche technique n'existe pas sur cette voiture");
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Retour creer(AnnonceDto annonceDto) {
        try {
            Annonce annonce = new Annonce(annonceDto);
            annonce.defaultColumn();
            verifyCategAndFicheTech(annonceDto);
            return new Retour( annonceRepository.save(annonce) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour modifier(String id ,AnnonceDto annonceDto) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            Annonce annonce = new Annonce(annonceDto);
            verifyCategAndFicheTech(annonceDto);
            a.setDescription(annonce.getDescription());
            //a.setEtat(annonce.getEtat());
            a.setEtatVoiture(annonce.getEtatVoiture());
            a.setIdCategorie(annonce.getIdCategorie());
            a.setKilometrage(annonce.getKilometrage());
            a.setPrixVente(annonce.getPrixVente());
            a.setDescription(a.getDescription());
            a.setIdFicheTechnique(annonce.getIdFicheTechnique());
            annonceRepository.save(a);
            return new Retour( null );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour supprimer(String id) {
        try {
           annonceRepository.deleteById(id);
           return new Retour("Annonce supprime id "+id) ;
        }
        catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

}
