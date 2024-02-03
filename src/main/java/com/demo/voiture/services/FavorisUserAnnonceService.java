package com.demo.voiture.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.dto.DetailsAnnonceDto;
import com.demo.voiture.dto.DetailsFavorisDto;
import com.demo.voiture.models.Annonce;
import com.demo.voiture.models.AnnoncePhoto;
import com.demo.voiture.models.DetailsAnnonce;
import com.demo.voiture.models.FavorisUserAnnonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.User;
import com.demo.voiture.models.VFavorisUserAnnonce;
import com.demo.voiture.repositories.AnnnoncePhotoRepository;
import com.demo.voiture.repositories.AnnonceRepository;
import com.demo.voiture.repositories.FavorisUserAnnonceRepository;
import com.demo.voiture.repositories.VFavorisUserAnnonceRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavorisUserAnnonceService {
    private final FavorisUserAnnonceRepository favorisUserAnnonceRepository;
    private final AnnonceRepository annonceRepository;
    private final VFavorisUserAnnonceRepository vFavorisUserAnnonceRepository;
    private final UserService userService;
    private final AnnnoncePhotoRepository annnoncePhotoRepository;

    public Retour find(String idUsers) {
        try {
            if (idUsers == null) {
                List<VFavorisUserAnnonce> all = vFavorisUserAnnonceRepository.findAll();
                List<AnnoncePhoto> photos = new ArrayList<AnnoncePhoto>();
                List<DetailsFavorisDto> full_details = new ArrayList<DetailsFavorisDto>();
                DetailsFavorisDto add = new DetailsFavorisDto();
                for (VFavorisUserAnnonce annonce : all) {
                    photos = annnoncePhotoRepository.findByIdAnnonce( annonce.getIdAnnonce() );
                    add = new DetailsFavorisDto(annonce, photos);
                    full_details.add(
                        add
                    );
                }

                //List<VFavorisUserAnnonce> all = vFavorisUserAnnonceRepository.findAll();
                return new Retour(full_details);
            } else {
                List<VFavorisUserAnnonce> all = vFavorisUserAnnonceRepository.findByIdUsersActuel(idUsers);
                return new Retour(all);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    void verifyExistence(FavorisUserAnnonce favorisUserAnnonce) throws Exception {
        try {
            Annonce a = annonceRepository.findById(favorisUserAnnonce.getIdAnnonce()).get();
            if(a.getEtat() < 20) {
                throw new Exception("Annonce pas encore valide");
            }
            boolean exist = favorisUserAnnonceRepository.existsByIdUsersAndIdAnnonce(favorisUserAnnonce.getIdUsers(), favorisUserAnnonce.getIdAnnonce());
            if(exist == true) {
                throw new Exception("Favoris existe deja");
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Retour testFavoris(String idAnnonce) {
        try {
            User u = userService.getByToken();
            boolean val = favorisUserAnnonceRepository.existsByIdUsersAndIdAnnonce(u.getIdUsers(), idAnnonce);
            return new Retour(val);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour create(FavorisUserAnnonce favorisUserAnnonce) {
        try {
            User u = userService.getByToken();
            favorisUserAnnonce.setIdUsers(u.getIdUsers());
            verifyExistence(favorisUserAnnonce);
            return new Retour( favorisUserAnnonceRepository.save(favorisUserAnnonce) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    void verifyDelete(String id) throws Exception {
        try {
            User u = userService.getByToken();
            FavorisUserAnnonce fau = favorisUserAnnonceRepository.findById(id).orElse(null);
            if(fau == null) {
                throw new Exception("ID Not found");
            }
            if(u.getIdUsers().compareTo(fau.getIdUsers())!= 0) {
                throw new Exception("Cette favoris n'appartient pas a cette user");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Transactional
    public Retour delete(String id) {
        try {
            verifyDelete(id);
            favorisUserAnnonceRepository.deleteById(id);
            return new Retour("Favoris User supprime id "+id) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    @Transactional
    public Retour delete(FavorisUserAnnonce favorisUserAnnonce) {
        try {
            User u = userService.getByToken();
            favorisUserAnnonceRepository.deleteByIdAnnonceAndIdUsers(favorisUserAnnonce.getIdAnnonce(), u.getIdUsers());
            return new Retour("Favoris User supprime idUsers "+favorisUserAnnonce.getIdUsers() + " idAnnonce " + favorisUserAnnonce.getIdAnnonce()) ;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new Retour(e.getMessage(), null);
        }
    }



}
