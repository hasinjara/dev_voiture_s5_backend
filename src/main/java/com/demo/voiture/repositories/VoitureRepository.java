package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, String> {
}
