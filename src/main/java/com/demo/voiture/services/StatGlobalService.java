package com.demo.voiture.services;

import com.demo.voiture.dto.StatGlobalDto;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.stat.StatCategorieGlobal;
import com.demo.voiture.models.stat.StatMarqueGlobal;
import com.demo.voiture.models.stat.StatVoitureGlobal;
import com.demo.voiture.repositories.StatCategorieGlobalRepository;
import com.demo.voiture.repositories.StatMarqueGlobalRepository;
import com.demo.voiture.repositories.StatVoitureGlobalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatGlobalService {
    private final StatCategorieGlobalRepository statCategorieGlobalRepository;
    private final StatMarqueGlobalRepository statMarqueGlobalRepository;
    private final StatVoitureGlobalRepository statVoitureGlobalRepository;

    public Retour all_stat() {
        try {
            List<StatCategorieGlobal> categs = statCategorieGlobalRepository.findAll();
            List<StatMarqueGlobal> marques = statMarqueGlobalRepository.findAll();
            List<StatVoitureGlobal> voitures = statVoitureGlobalRepository.findAll();
            StatGlobalDto val = StatGlobalDto.builder()
                                .statMarqueGlobals(marques)
                                .statVoitureGlobals(voitures)
                                .statCategorieGlobals(categs)
                                .build();
            return new Retour(val);
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }


}
