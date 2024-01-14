package com.demo.voiture.dto;

import com.demo.voiture.models.stat.StatCategorieGlobal;
import com.demo.voiture.models.stat.StatMarqueGlobal;
import com.demo.voiture.models.stat.StatVoitureGlobal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatGlobal {
    List<StatVoitureGlobal> statVoitureGlobals;
    List<StatMarqueGlobal> statMarqueGlobals;
    List<StatCategorieGlobal> statCategorieGlobals;
}
