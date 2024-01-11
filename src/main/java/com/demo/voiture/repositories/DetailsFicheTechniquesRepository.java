package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.DetailsFicheTechniques;
import java.util.List;


public interface DetailsFicheTechniquesRepository extends JpaRepository<DetailsFicheTechniques, String> {
    List<DetailsFicheTechniques> findByIdVoiture(String idVoiture);
}
