package com.demo.voiture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.voiture.models.stat.RevenuMensuel;

public interface RevenuMensuelRepository extends JpaRepository<RevenuMensuel, Integer> {
    @Query(value = "Select * from stat_revenu_anne( :anne )",nativeQuery = true)
    List<RevenuMensuel> findByAnne(@Param("anne") Integer anne);
}
