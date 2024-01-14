package com.demo.voiture.services;


import com.demo.voiture.dto.StatGlobalDto;
import com.demo.voiture.dto.StatMensuelDto;
import com.demo.voiture.models.Retour;
import com.demo.voiture.models.stat.StatCategorieGlobal;
import com.demo.voiture.models.stat.StatCategorieMensuel;
import com.demo.voiture.models.stat.StatMarqueGlobal;
import com.demo.voiture.models.stat.StatMarqueMensuel;
import com.demo.voiture.models.stat.StatVendeurMensuel;
import com.demo.voiture.models.stat.StatVoitureGlobal;
import com.demo.voiture.models.stat.StatVoitureMensuel;
import com.demo.voiture.models.stat.Utilitaire;
import com.demo.voiture.repositories.StatCategorieMensuelRepository;
import com.demo.voiture.repositories.StatMarqueMensuelRepository;
import com.demo.voiture.repositories.StatVendeurMensuelRepository;
import com.demo.voiture.repositories.StatVoitureMensuelRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatMensuelService {

    private final StatCategorieMensuelRepository statCategorieMensuelRepository;
    private final StatVendeurMensuelRepository statVendeurMensuelRepository;
    private final StatVoitureMensuelRepository statVoitureMensuelRepository;
    private final StatMarqueMensuelRepository statMarqueMensuelRepository;

    public Retour all_stat(int mois, int anne) {
        try {
            Utilitaire.verifyMoisAnne(mois, anne);
            List<StatCategorieMensuel> categs = statCategorieMensuelRepository.findByMoisAndAnne(mois, anne);
            List<StatVoitureMensuel> voitures = statVoitureMensuelRepository.findByMoisAndAnne(mois, anne);
            List<StatVendeurMensuel> vendeurs = statVendeurMensuelRepository.findByMoisAndAnne(mois, anne);
            List<StatMarqueMensuel> marques = statMarqueMensuelRepository.findByMoisAndAnne(mois, anne);
            StatMensuelDto val = StatMensuelDto.builder()
                                .statCategorieMensuels(categs)
                                .statMarqueMensuels(marques)
                                .statVendeurMensuels(vendeurs)
                                .statVoitureMensuels(voitures)
                                .build();
            return new Retour(val);
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }
}
