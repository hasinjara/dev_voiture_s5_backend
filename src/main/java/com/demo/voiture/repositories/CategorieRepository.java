package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, String> {
}