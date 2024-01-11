package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.FicheTechnique;

public interface FicheTechniqueRepository extends JpaRepository<FicheTechnique, String> {
    
}
