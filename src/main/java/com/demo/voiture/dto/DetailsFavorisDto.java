package com.demo.voiture.dto;

import java.util.List;

import com.demo.voiture.models.AnnoncePhoto;
import com.demo.voiture.models.VFavorisUserAnnonce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetailsFavorisDto {
    
    private VFavorisUserAnnonce details;
    private List<AnnoncePhoto> photos;

}
