package com.demo.voiture.repositories;

import com.demo.voiture.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByMail(String mail);

    Optional<User> findByIdUsers(String idUsers);

    User findByNom(String nom);
}
