package com.demo.voiture.services;

import com.demo.voiture.dto.AnnonceDto;
import com.demo.voiture.dto.DetailsAnnonceDto;
import com.demo.voiture.dto.SearchAnnonceDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.AnnoncePhoto;
import com.demo.voiture.models.Commission;
import com.demo.voiture.models.DetailsAnnonce;
import com.demo.voiture.models.DetailsFicheTechniques;
import com.demo.voiture.models.DetailsVoitureCategorie;
import com.demo.voiture.models.ParamCommission;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.User;
import com.demo.voiture.repositories.AnnnoncePhotoRepository;
import com.demo.voiture.repositories.AnnonceRepository;
import com.demo.voiture.repositories.CommissionRepository;
import com.demo.voiture.repositories.DetailsAnnonceRepository;
import com.demo.voiture.repositories.DetailsFicheTechniquesRepository;
import com.demo.voiture.repositories.DetailsVoitureCategorieRepository;
import com.demo.voiture.repositories.ParamCommissionRepository;
import com.demo.voiture.repositories.UserRepository;
import com.demo.voiture.repositories.VoitureConfigureRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final UserService userService;
    private final AnnnoncePhotoRepository annnoncePhotoRepository;


    @PersistenceContext
    private EntityManager entityManager;

    public Retour getDetailsAnnonce(String id) {
        try {
            if(id == null) {
                List<DetailsAnnonce> all = detailsAnnonceRepository.findAll();
                List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
                List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
                DetailsAnnonceDto add = new DetailsAnnonceDto();
                for (DetailsAnnonce annonce : all) {
                    photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                    add = new DetailsAnnonceDto(annonce, photos);
                    full_details.add(
                        add
                    );
                }
                return  new Retour(full_details);
            }
            else {
                DetailsAnnonce detail = detailsAnnonceRepository.findById(id).orElse(null);
                List<AnnoncePhoto> photos = annnoncePhotoRepository.findByIdAnnonce(id);
                DetailsAnnonceDto full_details = new DetailsAnnonceDto(detail, photos);
                return new Retour(full_details);
            }

        }
        catch (Exception e) {
            return  new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour getMin() {
        try {
            
            List<DetailsAnnonce> all = detailsAnnonceRepository.findMin();
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return  new Retour(full_details);
        }
        catch (Exception e) {
            return  new Retour(e.getMessage(), "Failed", null);
        }
    }


    public Retour getDetailsAnnonceIdusers() {
        try {
            User u = userService.getByToken();
            List<DetailsAnnonce> all = detailsAnnonceRepository.findByIdUsers(u.getIdUsers());
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return  new Retour(full_details);
        }
        catch (Exception e) {
            return  new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour getVenduUsers() {
        try {
            User u = userService.getByToken();
            List<DetailsAnnonce> all = detailsAnnonceRepository.findVendu(u.getIdUsers());
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return  new Retour(full_details);
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

    void verifyIdUserAnnonce(Annonce a) throws Exception {
        try {
            User u = userService.getByToken();
            if(a.getIdUsers().compareTo(u.getIdUsers()) != 0) {
                throw new Exception("Cette annonce n'appartient pas a cette user");
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    List<AnnoncePhoto> insertUrlPhoto(List<String> urls, String idAnnonce) throws Exception {
        try {
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            AnnoncePhoto photo = new AnnoncePhoto();

            for (String url : urls) {
                photo = new AnnoncePhoto(idAnnonce, url);
                photos.add( annnoncePhotoRepository.save(photo) );
            }
            return photos;
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }
     

    @Transactional
    public Retour creer(AnnonceDto annonceDto) {
        try {
            Annonce annonce = new Annonce(annonceDto);
            annonce.defaultColumn();
            verifyVoitureConfig(annonceDto);
            verifyCategAndFicheTech(annonceDto);
            User u = userService.getByToken();
            annonce.setIdUsers(u.getIdUsers());
            Object[] annonceDetails = new Object[2];
            annonceDetails[0] = annonceRepository.save(annonce);
            annonceDetails[1] = insertUrlPhoto(annonceDto.getUrl_photo(), annonce.getIdAnnonce());
            return new Retour( annonceDetails );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour modifier(String id ,AnnonceDto annonceDto) {
        try {
            Annonce a = annonceRepository.findById(id).get();
            verifyIdUserAnnonce(a);
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
            
            return new Retour("aucun", "Update reussi", annonceRepository.save(a) );
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
            verifyIdUserAnnonce(a);
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
                    throw new Exception("Champ Kilimetrage Obligatoire sur max et min si selectione");
                }
            }
            if(searchAnnonceDto.getEtatVoiture() !=  null) {
                if(searchAnnonceDto.getEtatVoiture().getMax() == null || searchAnnonceDto.getEtatVoiture().getMin()== null) {
                    throw new Exception("Champ Etat Voiture Obligatoire sur max et min si selectione");
                }
            }
            if(searchAnnonceDto.getPrixVente() !=  null) {
                if(searchAnnonceDto.getPrixVente().getMax() == null || searchAnnonceDto.getPrixVente().getMin()== null) {
                    throw new Exception("Champ Prix vente Voiture Obligatoire sur max et selectione");
                }
            }
            if(searchAnnonceDto.getConsommation() != null ) {
                if(searchAnnonceDto.getConsommation().getMax() == null || searchAnnonceDto.getConsommation().getMin() == null) {
                    throw new Exception("Champ Prix vente Voiture Obligatoire sur max et selectione");
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
            String sql = "SELECT * from v_annonce_valide";
            String between_km = "";
            String between_prix = "";
            String between_etat = "";
            String between_conso = "";
            String id_boite = "";
            String id_energie = "";
            String id_categorie = "";
            String id_voiture = "";
            String id_marque = "";
            String where = " where 0=0 ";
           
            

            if(searchAnnonceDto.getKilometrage() != null) {
                
                between_km = " and kilometrage between "
                                +searchAnnonceDto.getKilometrage().getMin() + " and "+
                                searchAnnonceDto.getKilometrage().getMax() + " ";
            }
            if(searchAnnonceDto.getPrixVente() != null) {
                
                between_prix = " and prix_vente between "
                                + searchAnnonceDto.getPrixVente().getMin() + " and "+   
                                searchAnnonceDto.getPrixVente().getMax()+ " ";
            }
            if(searchAnnonceDto.getEtatVoiture() != null) {
                
                between_etat = " and etat_voiture between "
                                + searchAnnonceDto.getEtatVoiture().getMin() + " and "+
                                searchAnnonceDto.getEtatVoiture().getMax()+ " " ;
            }
            if(searchAnnonceDto.getConsommation() != null) {
                between_conso = " and consommation between "
                                + searchAnnonceDto.getConsommation().getMin() + " and "+
                                searchAnnonceDto.getConsommation().getMax() + " ";
            }
            if(searchAnnonceDto.getIdBoite()!= null) {
                id_boite =" and id_boite  ='"+searchAnnonceDto.getIdBoite()+"' ";
            }
            if(searchAnnonceDto.getIdVoiture()!= null) {
                id_voiture = " and id_voiture ='"+searchAnnonceDto.getIdVoiture()+"' ";
            }
            if(searchAnnonceDto.getIdCategorie() != null) {
                id_categorie = " and id_categorie ='"+searchAnnonceDto.getIdCategorie()+"' ";
            }
            if(searchAnnonceDto.getIdMarque() != null) {
                id_marque = " and id_marque ='"+searchAnnonceDto.getIdMarque()+"' ";
            }
            if(searchAnnonceDto.getIdEnergie() != null) {
                id_energie = " and id_energie ='"+searchAnnonceDto.getIdEnergie()+"' ";
            }

            sql = sql + where + between_etat + between_km + between_prix + between_conso + id_boite + id_energie + id_categorie +id_marque + id_voiture;

            Query query = entityManager.createNativeQuery(sql, DetailsAnnonce.class);
            
            List<DetailsAnnonce> all = query.getResultList();
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }

            return new Retour(full_details);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listMotCle() {
        try {
            String sql = "SELECT * from v_annonce_valide";
            Query query = entityManager.createNativeQuery(sql, DetailsAnnonce.class);
            List<DetailsAnnonce> all = query.getResultList();
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return new Retour(full_details);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listMotCle(String motCle) {
        try {
            List<DetailsAnnonce> all = detailsAnnonceRepository.findMotCle(motCle);
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return new Retour(full_details);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listValide() {
        try {
            List<DetailsAnnonce> all = detailsAnnonceRepository.findValide();
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return new Retour(full_details);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }


    public Retour listRefuse() {
        try {
            List<DetailsAnnonce> all = detailsAnnonceRepository.findRefuse();
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return new Retour(full_details);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour listVendu() {
        try {

            List<DetailsAnnonce> all = detailsAnnonceRepository.findVendu();
            
            List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
            List<DetailsAnnonceDto> full_details = new ArrayList<DetailsAnnonceDto>();
            DetailsAnnonceDto add = new DetailsAnnonceDto();
            for (DetailsAnnonce annonce : all) {
                photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                add = new DetailsAnnonceDto(annonce, photos);
                full_details.add(
                    add
                );
            }
            return new Retour(full_details);
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
