package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_revenu_mensuel", schema = "public", catalog = "voiture")
public class RevenuMensuel {
    @Basic
    @Column(name = "nb_commission", nullable = true)
    private Long nbCommission;
    @Basic
    @Column(name = "total_commission", nullable = true, precision = 0)
    private Double totalCommission;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private Integer anne;

    @Id
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private Integer mois;

    public Long getNbCommission() {
        return nbCommission;
    }

    public void setNbCommission(Long nbCommission) {
        this.nbCommission = nbCommission;
    }

    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenuMensuel that = (RevenuMensuel) o;
        return Objects.equals(nbCommission, that.nbCommission) && Objects.equals(totalCommission, that.totalCommission) && Objects.equals(anne, that.anne) && Objects.equals(mois, that.mois);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbCommission, totalCommission, anne, mois);
    }

    public Integer getAnne() {
        return anne;
    }

    public void setAnne(Integer anne) {
        this.anne = anne;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }
}
