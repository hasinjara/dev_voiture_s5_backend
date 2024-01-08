package com.demo.voiture.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceDto {

    private String idUsers;
    
    private String idVoiture;
    
    private String idFicheTechnique;
    
    private String idCategorie;
    
    private Double kilometrage;
    
    private Double etatVoiture;
   
    private String description;
    
    private Double prixVente;
    
}
