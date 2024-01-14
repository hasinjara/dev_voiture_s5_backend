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
public class VoitureDto {
    

    private String nomModele;
    
    private int anneSortie;
    
    private String idMarque;

    private List<String> categories_possible;

}
