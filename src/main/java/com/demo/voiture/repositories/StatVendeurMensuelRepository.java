package com.demo.voiture.repositories;

import com.demo.voiture.models.stat.StatVendeurMensuel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface StatVendeurMensuelRepository extends JpaRepository<StatVendeurMensuel, String> {
    List<StatVendeurMensuel> findByMoisAndAnne(Integer mois, Integer anne);
}
