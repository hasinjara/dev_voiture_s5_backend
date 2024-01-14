package com.demo.voiture.models.stat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_users", schema = "public", catalog = "voiture")
public class VUsers {
    @Basic
    @Column(name = "nb_users", nullable = true)
    private Long nbUsers;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private BigInteger anne;
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private BigInteger mois;

    public Long getNbUsers() {
        return nbUsers;
    }

    public void setNbUsers(Long nbUsers) {
        this.nbUsers = nbUsers;
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
        VUsers vUsers = (VUsers) o;
        return Objects.equals(nbUsers, vUsers.nbUsers) && Objects.equals(anne, vUsers.anne) && Objects.equals(mois, vUsers.mois);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbUsers, anne, mois);
    }
}
