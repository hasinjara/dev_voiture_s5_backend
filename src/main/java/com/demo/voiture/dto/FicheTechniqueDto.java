package com.demo.voiture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FicheTechniqueDto {
    private String idVoiture;
    
    private String idEnergie;
    
    private String idBoite;
   
    private String moteur;
   
    private Double litreMoteur;
    
    private Double consommation;
    
    private Double puissance;
   
    private Double nbVitesse;
  
    private Double nbPlace;
 
    private Double nbPorte;

    private Double longueur;

    private Double poids;
}
