package com.demo.voiture.repositories;

import com.demo.voiture.models.FavorisUserAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorisUserAnnonceRepository extends JpaRepository<FavorisUserAnnonce, String> {
}
