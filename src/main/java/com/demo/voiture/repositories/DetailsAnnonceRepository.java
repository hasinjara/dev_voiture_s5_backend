package com.demo.voiture.repositories;

import com.demo.voiture.models.DetailsAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsAnnonceRepository extends JpaRepository<DetailsAnnonce, String> {
}
