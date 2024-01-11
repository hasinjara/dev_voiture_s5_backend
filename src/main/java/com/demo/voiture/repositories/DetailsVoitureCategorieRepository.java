package com.demo.voiture.repositories;

import com.demo.voiture.models.DetailsVoitureCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DetailsVoitureCategorieRepository extends JpaRepository<DetailsVoitureCategorie, String> {
    @Query(value =  "SELECT * from v_voiture_categorie where id_voiture =:id", nativeQuery = true)
    List<DetailsVoitureCategorie> findByIdVoiture(@Param("id") String id);
}
