package com.demo.voiture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchAnnonceDto {
    KilometrageDto kilometrage;
    PrixVenteDto prixVente;
    EtatVoitureDto etatVoiture;
    String idCategorie;
    String idVoiture;
    String idMarque;
    String idBoite;
    String idEnergie;
}
