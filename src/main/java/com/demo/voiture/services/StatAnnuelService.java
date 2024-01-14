package com.demo.voiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.voiture.dto.StatAnnuelDto;
import com.demo.voiture.dto.StatGlobalDto;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.stat.AnnonceMois;
import com.demo.voiture.models.stat.RevenuMensuel;
import com.demo.voiture.models.stat.Utilitaire;
import com.demo.voiture.models.stat.VUsers;
import com.demo.voiture.repositories.AnnonceMoisRepository;
import com.demo.voiture.repositories.RevenuMensuelRepository;
import com.demo.voiture.repositories.VUsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatAnnuelService {
    private final VUsersRepository vUsersRepository;
    private final RevenuMensuelRepository revenuMensuelRepository;
    private final AnnonceMoisRepository annonceMoisRepository;

    public Retour all_stat(int anne) {
        try {
            List<VUsers> users = vUsersRepository.findByAnne(anne);
            List<RevenuMensuel> revenus = revenuMensuelRepository.findByAnne(anne);
            List<AnnonceMois> annonces = annonceMoisRepository.findByAnne(anne);
            StatAnnuelDto val = StatAnnuelDto.builder()
                                .annonceMois(annonces)
                                .revenuMensuels(revenus)
                                .users(users)
                                .build();
            return new Retour(val);
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

}
