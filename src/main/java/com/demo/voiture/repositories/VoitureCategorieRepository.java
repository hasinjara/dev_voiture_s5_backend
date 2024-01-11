package com.demo.voiture.repositories;

import com.demo.voiture.models.VoitureCategorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureCategorieRepository extends JpaRepository<VoitureCategorie, String> {
    List <VoitureCategorie> findByIdVoiture(String idVoiture); 
}
