package com.demo.voiture.repositories;

import com.demo.voiture.models.VoitureMarque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface VoitureMarqueRepository extends JpaRepository<VoitureMarque, String> {
    List<VoitureMarque> findByIdMarque(String marque);
}
