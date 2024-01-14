package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.voiture.models.stat.VUsers;
import java.util.List;


public interface VUsersRepository extends JpaRepository<VUsers, Integer> {
    
    @Query(value = "Select * from stat_user_anne( :anne )",nativeQuery = true)
    List<VUsers> findByAnne(@Param("anne") Integer anne);
}
