package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Voiture;
import java.util.List;


public interface VoitureRepository extends JpaRepository<Voiture, String> {

    List<Voiture> findByIdMarque(String idMarque);

}
