package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.voiture.models.VVoitureCategorie;

@Repository
public interface VVoitureCategorieRepository extends JpaRepository<VVoitureCategorie, String> {

}
