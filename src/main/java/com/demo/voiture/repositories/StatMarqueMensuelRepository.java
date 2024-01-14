package com.demo.voiture.repositories;

import com.demo.voiture.models.stat.StatMarqueMensuel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StatMarqueMensuelRepository extends JpaRepository<StatMarqueMensuel, String> {
    List<StatMarqueMensuel> findByMoisAndAnne(Integer mois, Integer anne);
}
