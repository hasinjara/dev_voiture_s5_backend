package com.demo.voiture.repositories;

import com.demo.voiture.models.DetailsAnnonce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailsAnnonceRepository extends JpaRepository<DetailsAnnonce, String> {

    @Query(value = "Select * from v_annonce_valide",nativeQuery = true)
    List<DetailsAnnonce> findValide();

    @Query(value = "Select * from v_annonce_refuse",nativeQuery = true)
    List<DetailsAnnonce> findRefuse();

    @Query(value = "Select * from v_annonce_vendu",nativeQuery = true)
    List<DetailsAnnonce> findVendu();

}
