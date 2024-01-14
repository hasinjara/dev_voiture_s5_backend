package com.demo.voiture.repositories;

import com.demo.voiture.models.stat.StatVoitureMensuel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StatVoitureMensuelRepository extends JpaRepository<StatVoitureMensuel, String> {
    List<StatVoitureMensuel> findByMoisAndAnne(Integer mois,Integer anne);
}
