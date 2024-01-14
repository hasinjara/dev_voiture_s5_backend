package com.demo.voiture.repositories;

import com.demo.voiture.models.stat.StatMarqueGlobal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatMarqueGlobalRepository extends JpaRepository<StatMarqueGlobal, String> {
}
