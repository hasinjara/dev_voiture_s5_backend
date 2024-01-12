package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "param_commission", schema = "public", catalog = "voiture")
public class ParamCommission {
    @Id
    @Basic
    @Column(name = "marge_commission", nullable = true, precision = 0)
    private Double margeCommission;

    public ParamCommission(Double margeCommission) throws Exception {
        try {
            setMargeCommission(margeCommission);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public ParamCommission() {
    }


    public Double getMargeCommission() {
        return margeCommission;
    }

    public void setMargeCommission(Double margeCommission) throws Exception {
        if(margeCommission <= 0 || margeCommission > 100) {
            throw new Exception("Marge doit etre compris entre 0 a 100%");
        }
        this.margeCommission = margeCommission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParamCommission that = (ParamCommission) o;
        return Objects.equals(margeCommission, that.margeCommission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(margeCommission);
    }
}
