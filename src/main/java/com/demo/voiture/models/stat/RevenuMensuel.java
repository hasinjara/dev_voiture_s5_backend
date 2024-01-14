package com.demo.voiture.models.stat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_revenu_mensuel", schema = "public", catalog = "voiture")
public class VRevenuMensuel {
    @Basic
    @Column(name = "nb_commission", nullable = true)
    private Long nbCommission;
    @Basic
    @Column(name = "total_commission", nullable = true, precision = 0)
    private Double totalCommission;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private BigInteger anne;
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private BigInteger mois;

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

    public BigInteger getAnne() {
        return anne;
    }

    public void setAnne(BigInteger anne) {
        this.anne = anne;
    }

    public BigInteger getMois() {
        return mois;
    }

    public void setMois(BigInteger mois) {
        this.mois = mois;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VRevenuMensuel that = (VRevenuMensuel) o;
        return Objects.equals(nbCommission, that.nbCommission) && Objects.equals(totalCommission, that.totalCommission) && Objects.equals(anne, that.anne) && Objects.equals(mois, that.mois);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbCommission, totalCommission, anne, mois);
    }
}
