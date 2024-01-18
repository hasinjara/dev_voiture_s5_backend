package com.demo.voiture.services;

import com.demo.voiture.models.Retour;
import com.demo.voiture.models.User;
import com.demo.voiture.models.VoitureMarque;
import com.demo.voiture.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByMail(username).orElseThrow( () -> new UsernameNotFoundException("User not found") );
            }
        };
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public Retour findByNom(String nom) {
        try {
            return new Retour( userRepository.findByNom(nom) );
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public User null_user() {
        return null;
    }

    public User findMail(String mail) {
        User user = userRepository.findByMail(mail)
                .orElse( null_user() );
        return user;
    }

    public User getByToken() throws Exception {
        try {
            String mail = SecurityContextHolder.getContext().getAuthentication().getName();
        return findMail(mail);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        
    }

    public Retour findById(String id) {
        try {
            return new Retour(userRepository.findById(id));
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

}
