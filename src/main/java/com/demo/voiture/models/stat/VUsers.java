package com.demo.voiture.models.stat;

import jakarta.persistence.*;

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
    private Integer anne;
    
    @Id
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private Integer mois;

    public Long getNbUsers() {
        return nbUsers;
    }

    public void setNbUsers(Long nbUsers) {
        this.nbUsers = nbUsers;
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
