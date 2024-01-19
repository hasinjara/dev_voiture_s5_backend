package com.demo.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.voiture.models.VFavorisUserAnnonce;
import java.util.List;


public interface VFavorisUserAnnonceRepository extends JpaRepository<VFavorisUserAnnonce, String> {
    List<VFavorisUserAnnonce> findByIdUsers(String idUsers);

    List<VFavorisUserAnnonce> findByIdUsersActuel(String idUsersActuel);
    
}
