package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.voiture.models.stat.VCommission;

@Repository
public interface VCommissionRepository extends JpaRepository<VCommission, String> {

}
