package com.demo.voiture.services;

import org.springframework.stereotype.Service;


import com.demo.voiture.models.ParamCommission;
import com.demo.voiture.models.Retour;
import com.demo.voiture.repositories.ParamCommissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamCommissionService {
    private final ParamCommissionRepository paramCommissionRepository;
    
    public Retour find() {
        try {
            ParamCommission paramCommission = paramCommissionRepository.findParamCommission();
            return new Retour(paramCommission);
        } catch (Exception e) {
            return new Retour(e.getMessage(), "Failed", null);
        }
    }

    public Retour update(Double commission) {
        try {
            ParamCommission paramCommission = new ParamCommission(commission);
            paramCommissionRepository.changeParamCommission(commission);
            return new Retour("aucun","Update marge commission "+ commission + " %",null);
        } catch (Exception e) {
            // TODO: handle exception
            return new Retour(e.getMessage(), "Failed", null);
        }
    }
}
