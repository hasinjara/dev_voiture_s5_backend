package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Boite;

public interface BoiteRepository extends JpaRepository <Boite, String> {
    
}
