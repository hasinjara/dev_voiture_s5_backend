package com.demo.voiture.dto;

import com.demo.voiture.models.stat.StatCategorieMensuel;
import com.demo.voiture.models.stat.StatMarqueMensuel;
import com.demo.voiture.models.stat.StatVendeurMensuel;
import com.demo.voiture.models.stat.StatVoitureMensuel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatMensuelDto {
    List<StatMarqueMensuel> statMarqueMensuels;
    List<StatCategorieMensuel> statCategorieMensuels;
    List<StatVoitureMensuel> statVoitureMensuels;
    List<StatVendeurMensuel> statVendeurMensuels;
}
