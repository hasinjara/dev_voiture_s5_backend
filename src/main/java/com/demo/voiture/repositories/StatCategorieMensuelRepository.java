package com.demo.voiture.repositories;

import com.demo.voiture.models.stat.StatCategorieMensuel;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StatCategorieMensuelRepository  extends JpaRepository<StatCategorieMensuel, String> {
    List<StatCategorieMensuel> findByMoisAndAnne(Integer mois,Integer anne);
}
