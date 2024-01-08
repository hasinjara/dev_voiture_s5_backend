package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Energie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_energie", nullable = false, length = -1)
    private String idEnergie;
    @Basic
    @Column(name = "energie", nullable = false, length = -1)
    private String energie;

    public String getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(String idEnergie) {
        this.idEnergie = idEnergie;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Energie energie1 = (Energie) o;
        return Objects.equals(idEnergie, energie1.idEnergie) && Objects.equals(energie, energie1.energie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnergie, energie);
    }
}
