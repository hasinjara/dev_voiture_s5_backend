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

    public Double getMargeCommission() {
        return margeCommission;
    }

    public void setMargeCommission(Double margeCommission) {
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
