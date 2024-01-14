package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.Commission;

public interface CommissionRepository  extends JpaRepository <Commission, String>{
    
}
