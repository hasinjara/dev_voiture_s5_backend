package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.voiture.models.AnnoncePhoto;
import java.util.List;


@Repository
public interface AnnnoncePhotoRepository extends JpaRepository<AnnoncePhoto, String> {
    List<AnnoncePhoto> findByIdAnnonce(String idAnnonce);
}
