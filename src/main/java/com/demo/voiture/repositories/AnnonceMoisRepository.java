package com.demo.voiture.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.voiture.models.stat.AnnonceMois;


public interface AnnonceMoisRepository extends JpaRepository<AnnonceMois, Integer> {
    @Query(value = "Select * from stat_annonce_anne( :anne )",nativeQuery = true)
    List<AnnonceMois> findByAnne(@Param("anne") Integer anne);
}
