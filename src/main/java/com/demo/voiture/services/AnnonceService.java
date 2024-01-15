package com.demo.voiture.services;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.dto.SearchAnnonceDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.Commission;
import com.demo.voiture.models.DetailsAnnonce;
import com.demo.voiture.models.DetailsFicheTechniques;
import com.demo.voiture.models.DetailsVoitureCategorie;
import com.demo.voiture.models.ParamCommission;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.AnnonceRepository;
import com.demo.voiture.repositories.CommissionRepository;
import com.demo.voiture.repositories.DetailsAnnonceRepository;
import com.demo.voiture.repositories.DetailsFicheTechniquesRepository;
import com.demo.voiture.repositories.DetailsVoitureCategorieRepository;
import com.demo.voiture.repositories.ParamCommissionRepository;
import com.demo.voiture.repositories.VoitureConfigureRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
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
    private final VoitureConfigureRepository voitureConfigureRepository;
    private final ParamCommissionRepository paramCommissionRepository;
    private final CommissionRepository commissionRepository;


    @PersistenceContext
    private EntityManager entityManager;

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

    void verifyVoitureConfig(AnnonceDto annonceDto) throws Exception {
        try {
            boolean exist = voitureConfigureRepository.existsByIdVoiture(annonceDto.getIdVoiture());
            if(exist == false) {
                throw new Exception("Cette voiture n'est pas encore configure");
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
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
            verifyVoitureConfig(annonceDto);
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

    public Retour valider(String id) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            a.setEtat(20);
            annonceRepository.save(a);
            return new Retour("aucun","Annonce valide ID"+id,null);
         } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour refuser(String id) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            a.setEtat(10);
            annonceRepository.save(a);
            return new Retour("aucun","Annonce refuse ID"+id,null);
         } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    void verifyEtatAnnonce(Annonce a) throws Exception {
        try {
            if(a.getEtat() != 20) {
                throw new Exception("Cette annonce ne peut pas etre vendu");
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    @Transactional
    public Retour vendre(String id) {
        try {
            // controle annonce - change etat
            Annonce a = annonceRepository.findById(id).get();
            verifyEtatAnnonce(a);
            a.setEtat(30);
            annonceRepository.save(a);

            //avoir la marge de commission
            ParamCommission paramCommission = paramCommissionRepository.findParamCommission();

            // inserer la commision
            double marge = paramCommission.getMargeCommission();
            double prix_vente = a.getPrixVente();
            double total_commission = prix_vente*(marge/100); 
            Commission commission = new Commission(a.getIdAnnonce(), marge, prix_vente, total_commission);
            commissionRepository.save(commission);

            return new Retour("aucun","Annonce vendu ID"+id,null);
         } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    void verifySearchAnnonce(SearchAnnonceDto searchAnnonceDto) throws Exception {
        try {
            boolean exception = false;
            if(searchAnnonceDto.getKilometrage() != null) {
                if(searchAnnonceDto.getKilometrage().getMax() == null || searchAnnonceDto.getKilometrage().getMin()== null) {
                    throw new Exception("Champ Kilimetrage Obligatoire sur max et min");
                }
            }
            if(searchAnnonceDto.getEtatVoiture() !=  null) {
                if(searchAnnonceDto.getEtatVoiture().getMax() == null && searchAnnonceDto.getEtatVoiture().getMin()== null) {
                    throw new Exception("Champ Etat Voiture Obligatoire sur max et min");
                }
            }
            if(searchAnnonceDto.getPrixVente() !=  null) {
                if(searchAnnonceDto.getPrixVente().getMax() == null && searchAnnonceDto.getPrixVente().getMin()== null) {
                    throw new Exception("Champ Prix vente Voiture Obligatoire sur max et min");
                }
            }


        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Retour listMotCle(SearchAnnonceDto searchAnnonceDto) {
        try {
            verifySearchAnnonce(searchAnnonceDto);
            String sql = "SELECT * from v_annonce_vendu";
            String between_km = "";
            String where = " where ";
            boolean change = false;
            if(searchAnnonceDto.getKilometrage() != null) {
                change = true;
                between_km = " kilometrage between "
                                +searchAnnonceDto.getKilometrage().getMin() + " and "+
                                searchAnnonceDto.getKilometrage().getMax();
            }
            Query query = entityManager.createNativeQuery(sql, DetailsAnnonce.class);
            return new Retour(query.getResultList());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listMotCle() {
        try {
            String sql = "SELECT * from v_annonce_vendu";
            Query query = entityManager.createNativeQuery(sql, DetailsAnnonce.class);
            return new Retour(query.getResultList());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listMotCle(String motCle) {
        try {
            return new Retour(detailsAnnonceRepository.findMotCle(motCle));
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listValide() {
        try {
            return new Retour(detailsAnnonceRepository.findValide());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }


    public Retour listRefuse() {
        try {
            return new Retour(detailsAnnonceRepository.findRefuse());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listVendu() {
        try {
            return new Retour(detailsAnnonceRepository.findVendu());
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour supprimer(String id) {
        try {
           //annonceRepository.deleteById(id);
           Retour r = refuser(id);
           return new Retour("Annonce supprime id "+id) ;
        }
        catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

}
