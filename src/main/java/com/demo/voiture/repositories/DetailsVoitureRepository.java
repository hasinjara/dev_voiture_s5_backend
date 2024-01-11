package com.demo.voiture.repositories;

import com.demo.voiture.models.DetailsVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsVoitureRepository extends JpaRepository<DetailsVoiture, String> {
}
