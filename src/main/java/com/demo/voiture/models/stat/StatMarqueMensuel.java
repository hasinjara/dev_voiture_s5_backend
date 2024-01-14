package com.demo.voiture.models.stat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_stat_marque_mensuel", schema = "public", catalog = "voiture")
public class VStatMarqueMensuel {
    @Basic
    @Column(name = "id_marque", nullable = true, length = -1)
    private String idMarque;
    @Basic
    @Column(name = "marque", nullable = true, length = -1)
    private String marque;
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private BigInteger mois;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private BigInteger anne;
    @Basic
    @Column(name = "nb_commission", nullable = true, precision = 0)
    private BigInteger nbCommission;
    @Basic
    @Column(name = "commission_total", nullable = true, precision = 0)
    private Double commissionTotal;

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public BigInteger getMois() {
        return mois;
    }

    public void setMois(BigInteger mois) {
        this.mois = mois;
    }

    public BigInteger getAnne() {
        return anne;
    }

    public void setAnne(BigInteger anne) {
        this.anne = anne;
    }

    public BigInteger getNbCommission() {
        return nbCommission;
    }

    public void setNbCommission(BigInteger nbCommission) {
        this.nbCommission = nbCommission;
    }

    public Double getCommissionTotal() {
        return commissionTotal;
    }

    public void setCommissionTotal(Double commissionTotal) {
        this.commissionTotal = commissionTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VStatMarqueMensuel that = (VStatMarqueMensuel) o;
        return Objects.equals(idMarque, that.idMarque) && Objects.equals(marque, that.marque) && Objects.equals(mois, that.mois) && Objects.equals(anne, that.anne) && Objects.equals(nbCommission, that.nbCommission) && Objects.equals(commissionTotal, that.commissionTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarque, marque, mois, anne, nbCommission, commissionTotal);
    }
}
