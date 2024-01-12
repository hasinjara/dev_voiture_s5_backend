package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.models.FavorisUserAnnonce;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.FavorisUserAnnonceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavorisUserAnnonceService {
    private final FavorisUserAnnonceRepository favorisUserAnnonceRepository;

    public Retour find(String idUsers) {
        try {
            if (idUsers == null) {
                List<FavorisUserAnnonce> all = favorisUserAnnonceRepository.findAll();
                return new Retour(all);
            } else {
                List<FavorisUserAnnonce> all = favorisUserAnnonceRepository.findByIdUsers(idUsers);
                return new Retour(all);
            }
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    void verifyExistence(FavorisUserAnnonce favorisUserAnnonce) throws Exception {
        try {
            boolean exist = favorisUserAnnonceRepository.existsByIdUsersAndIdAnnonce(favorisUserAnnonce.getIdUsers(), favorisUserAnnonce.getIdAnnonce());
            if(exist == true) {
                throw new Exception("Favoris existe deja");
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Retour create(FavorisUserAnnonce favorisUserAnnonce) {
        try {
            verifyExistence(favorisUserAnnonce);
            return new Retour( favorisUserAnnonceRepository.save(favorisUserAnnonce) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour delete(String id) {
        try {
            favorisUserAnnonceRepository.deleteById(id);
            return new Retour("Favoris User supprime id "+id) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }

    public Retour delete(FavorisUserAnnonce favorisUserAnnonce) {
        try {
            favorisUserAnnonceRepository.deleteByIdAnnonceAndIdUsers(favorisUserAnnonce.getIdAnnonce(), favorisUserAnnonce.getIdUsers());
            return new Retour("Favoris User supprime idUsers "+favorisUserAnnonce.getIdUsers() + " idAnnonce " + favorisUserAnnonce.getIdAnnonce()) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), null);
        }
    }



}
