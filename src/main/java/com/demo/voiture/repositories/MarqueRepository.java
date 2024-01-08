package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Marque;

public interface MarqueRepository extends JpaRepository<Marque, String> {
}
