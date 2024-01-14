package com.demo.voiture.repositories;

import com.demo.voiture.models.stat.StatVoitureGlobal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatVoitureGlobalRepository extends JpaRepository<StatVoitureGlobal, String> {
}
