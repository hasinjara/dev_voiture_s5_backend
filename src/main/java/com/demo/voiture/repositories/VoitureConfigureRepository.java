package com.demo.voiture.repositories;

import com.demo.voiture.models.VoitureConfigure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureConfigureRepository extends JpaRepository <VoitureConfigure, String> {
    boolean existsByIdVoiture(String idVoiture);
}
