package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_stat_voiture_mensuel", schema = "public", catalog = "voiture")
public class StatVoitureMensuel {

    @Id
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = true, length = -1)
    private String nomModele;
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

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
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
        StatVoitureMensuel that = (StatVoitureMensuel) o;
        return Objects.equals(idVoiture, that.idVoiture) && Objects.equals(nomModele, that.nomModele) && Objects.equals(mois, that.mois) && Objects.equals(anne, that.anne) && Objects.equals(nbCommission, that.nbCommission) && Objects.equals(commissionTotal, that.commissionTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, mois, anne, nbCommission, commissionTotal);
    }
}
