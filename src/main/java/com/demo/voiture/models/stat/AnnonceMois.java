package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_annonce_mois", schema = "public", catalog = "voiture")
public class AnnonceMois {
    @Basic
    @Column(name = "nb_annonce", nullable = true)
    private Long nbAnnonce;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private Integer anne;

    @Id
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private Integer mois;

    public Long getNbAnnonce() {
        return nbAnnonce;
    }

    public void setNbAnnonce(Long nbAnnonce) {
        this.nbAnnonce = nbAnnonce;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnonceMois that = (AnnonceMois) o;
        return Objects.equals(nbAnnonce, that.nbAnnonce) && Objects.equals(anne, that.anne) && Objects.equals(mois, that.mois);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbAnnonce, anne, mois);
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
