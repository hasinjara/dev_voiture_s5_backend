package com.demo.voiture.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceDto {


    private String idVoiture;
    
    private String idFicheTechnique;
    
    private String idCategorie;
    
    private Double kilometrage;
    
    private Double etatVoiture;
   
    private String description;
    
    private Double prixVente;

    private List<String> url_photo;

    public AnnonceDto(String idVoiture, String idFicheTechnique, String idCategorie, Double kilometrage,
            Double etatVoiture, String description, Double prixVente) {
        this.idVoiture = idVoiture;
        this.idFicheTechnique = idFicheTechnique;
        this.idCategorie = idCategorie;
        this.kilometrage = kilometrage;
        this.etatVoiture = etatVoiture;
        this.description = description;
        this.prixVente = prixVente;
    }
    
}
