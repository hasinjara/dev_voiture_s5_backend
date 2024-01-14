package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_stat_categorie_mensuel", schema = "public", catalog = "voiture")
public class StatCategorieMensuel {

    @Id
    @Basic
    @Column(name = "id_categorie", nullable = true, length = -1)
    private String idCategorie;
    @Basic
    @Column(name = "categorie", nullable = true, length = -1)
    private String categorie;
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

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        StatCategorieMensuel that = (StatCategorieMensuel) o;
        return Objects.equals(idCategorie, that.idCategorie) && Objects.equals(categorie, that.categorie) && Objects.equals(mois, that.mois) && Objects.equals(anne, that.anne) && Objects.equals(nbCommission, that.nbCommission) && Objects.equals(commissionTotal, that.commissionTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, categorie, mois, anne, nbCommission, commissionTotal);
    }
}
