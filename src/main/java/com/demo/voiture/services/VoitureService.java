package com.demo.voiture.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.dto.VoitureDto;
import com.demo.voiture.models.DetailsFicheTechniques;
import com.demo.voiture.models.DetailsVoitureCategorie;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.Voiture;
import com.demo.voiture.models.VoitureCategorie;
import com.demo.voiture.models.VoitureMarque;
import com.demo.voiture.repositories.DetailsFicheTechniquesRepository;
import com.demo.voiture.repositories.DetailsVoitureCategorieRepository;
import com.demo.voiture.repositories.DetailsVoitureRepository;
import com.demo.voiture.repositories.FicheTechniqueRepository;
import com.demo.voiture.repositories.VoitureCategorieRepository;
import com.demo.voiture.repositories.VoitureMarqueRepository;
import com.demo.voiture.repositories.VoitureRepository;

import jakarta.transaction.Transactional;
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
    private final FicheTechniqueRepository ficheTechniqueRepository;


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


    public Retour findMarque(String id) {
        try {
            if (id == null) {
                List<VoitureMarque> all =  voitureMarqueRepository.findAll();
                return new Retour(all);
            } else {
                List<VoitureMarque >  marques  = voitureMarqueRepository.findByIdMarque(id);
                return new Retour(marques );
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

    void verifyCateg(VoitureDto voitureDto) throws Exception {
        try {
            String actual = "";
            String before = "";
            if(voitureDto.getCategories_possible().size() == 0 || voitureDto.getCategories_possible() == null) {
                throw new Exception("Une voiture doit avoir une categorie possible au minimu");
            }
            for (int i = 0; i < voitureDto.getCategories_possible().size(); i++) {
                if( i != 0) {
                    actual = voitureDto.getCategories_possible().get(i);
                    before = voitureDto.getCategories_possible().get(i - 1);
                    if( actual.compareTo(before) == 0 ) {
                        throw new Exception("Categorie redondant");
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    @Transactional
    public Retour create(VoitureDto voitureDto) {
        try {
            Voiture voiture = new Voiture(voitureDto);
            verifyCateg(voitureDto);
            Voiture save = voitureRepository.save(voiture);
            
            List<VoitureCategorie> voitures_Categories = new ArrayList<VoitureCategorie>();
            VoitureCategorie voitureCategorie = new VoitureCategorie();
        
            for (String idCategorie : voitureDto.getCategories_possible()) {
                voitureCategorie = new VoitureCategorie(save.getIdVoiture(), idCategorie);
                voitures_Categories.add (  voitureCategorieRepository.save( voitureCategorie  ) );
            }   
            Object[] retours = new Object[2];
            retours[0] = save;
            retours[1] = voitures_Categories;
            return new Retour(retours);
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
                return new Retour(voitureRepository.save(update));
            }
            else {
                return new Retour("Id "+ id + " not found",null);
            }
            
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    @Transactional
    public Retour delete(String id) {
        try {
            ficheTechniqueRepository.deleteByIdVoiture(id);
            voitureCategorieRepository.deleteByIdVoiture(id);
            voitureRepository.deleteById(id);
            return new Retour("aucun","Voiture supprime id " + id,null);
        } catch (Exception e) {
            return new Retour(e.getMessage(),"Cette voiture est utilise dans autre relation" ,null);
        }
    }
}
