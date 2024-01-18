package com.demo.voiture.dto;

import java.sql.Date;
import java.util.List;

import com.demo.voiture.models.AnnoncePhoto;
import com.demo.voiture.models.DetailsAnnonce;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetailsAnnonceDto {
    
    private DetailsAnnonce details;
    private List<AnnoncePhoto> photos;
}
