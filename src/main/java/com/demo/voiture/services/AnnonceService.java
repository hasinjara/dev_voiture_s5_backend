package com.demo.voiture.services;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.DetailsAnnonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.AnnonceRepository;
import com.demo.voiture.repositories.DetailsAnnonceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnonceService {

    private final DetailsAnnonceRepository detailsAnnonceRepository;
    private final AnnonceRepository annonceRepository;

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

    public Retour creer(AnnonceDto annonceDto) {
        try {
            Annonce annonce = new Annonce(annonceDto);
            annonce.defaultColumn();
            return new Retour( annonceRepository.save(annonce) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour modifier(String id ,AnnonceDto annonceDto) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            Annonce annonce = new Annonce(annonceDto);
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
