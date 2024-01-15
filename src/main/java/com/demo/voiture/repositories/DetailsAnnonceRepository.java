package com.demo.voiture.repositories;

import com.demo.voiture.models.DetailsAnnonce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetailsAnnonceRepository extends JpaRepository<DetailsAnnonce, String> {

    @Query(value = "Select * from v_annonce_valide",nativeQuery = true)
    List<DetailsAnnonce> findValide();

    @Query(value = "Select * from v_annonce_refuse",nativeQuery = true)
    List<DetailsAnnonce> findRefuse();

    @Query(value = "Select * from v_annonce_vendu",nativeQuery = true)
    List<DetailsAnnonce> findVendu();

    @Query(value = "SELECT * FROM v_annonce_valide " +
        "WHERE " +
        "CAST(kilometrage AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(etat_voiture AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(description AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(prix_vente AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(date_annonce AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(nom_modele AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(anne_sortie AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(marque AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(categorie AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(energie AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(boite AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(moteur AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(litre_moteur AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(consommation AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(nb_vitesse AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(nb_place AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(nb_porte AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(longueur AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(poids AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(nom AS TEXT) ILIKE CONCAT('%', :m, '%') " +
        "OR CAST(prenom AS TEXT) ILIKE CONCAT('%', :m, '%')",
        nativeQuery = true)
        List<DetailsAnnonce> findMotCle(@Param("m") String m);

}
