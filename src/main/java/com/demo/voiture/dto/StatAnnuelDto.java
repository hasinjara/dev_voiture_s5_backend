package com.demo.voiture.dto;

import java.util.List;

import com.demo.voiture.models.stat.AnnonceMois;
import com.demo.voiture.models.stat.RevenuMensuel;
import com.demo.voiture.models.stat.VUsers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatAnnuelDto {
    List<VUsers> users; 
    List<RevenuMensuel> revenuMensuels;
    List<AnnonceMois> annonceMois;
}
