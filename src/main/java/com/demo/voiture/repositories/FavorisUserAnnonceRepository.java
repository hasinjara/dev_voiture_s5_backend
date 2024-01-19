package com.demo.voiture.repositories;

import com.demo.voiture.models.FavorisUserAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface FavorisUserAnnonceRepository extends JpaRepository<FavorisUserAnnonce, String> {
    List<FavorisUserAnnonce> findByIdUsers(String idUsers);
    
    boolean existsByIdUsersAndIdAnnonce(String idUsers, String idAnnonce);

    void deleteByIdAnnonceAndIdUsers(String idAnnonce, String idUsers);
    
    void deleteByIdAnnonce(String idAnnonce);
}
