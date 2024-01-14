package com.demo.voiture.models.stat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_annonce_mois", schema = "public", catalog = "voiture")
public class VAnnonceMois {
    @Basic
    @Column(name = "nb_annonce", nullable = true)
    private Long nbAnnonce;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private BigInteger anne;
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private BigInteger mois;

    public Long getNbAnnonce() {
        return nbAnnonce;
    }

    public void setNbAnnonce(Long nbAnnonce) {
        this.nbAnnonce = nbAnnonce;
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
        VAnnonceMois that = (VAnnonceMois) o;
        return Objects.equals(nbAnnonce, that.nbAnnonce) && Objects.equals(anne, that.anne) && Objects.equals(mois, that.mois);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbAnnonce, anne, mois);
    }
}
