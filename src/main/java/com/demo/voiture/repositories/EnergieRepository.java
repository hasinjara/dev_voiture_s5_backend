package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Energie;

public interface EnergieRepository extends JpaRepository<Energie, String> {
}
