package com.demo.voiture.dto;


import java.util.List;

import com.demo.voiture.models.Categorie;
import com.demo.voiture.models.FicheTechnique;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoitureDto {
    
    private String idVoiture;
    
    private String nomModele;
    
    private int anneSortie;
    
    private String idMarque;

    private String marque;

    private List<Categorie> categories_possible;

    private List<FicheTechnique> ficheTechniques_possible;

}
