package com.demo.voiture.repositories;

import com.demo.voiture.models.ParamCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ParamCommissionRepository extends JpaRepository<ParamCommission, Double> {
    @Query(value = "SELECT marge_commission from param_commission", nativeQuery = true)
    ParamCommission findParamCommission();

    @Transactional
    @Modifying
    @Query(value = "UPDATE param_commission set marge_commission = :marge",nativeQuery = true)
    void changeParamCommission(@Param("marge") Double marge);
}
