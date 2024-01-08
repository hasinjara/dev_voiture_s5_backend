package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Boite {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_boite", nullable = false, length = -1)
    private String idBoite;
    @Basic
    @Column(name = "boite", nullable = false, length = -1)
    private String boite;

    public String getIdBoite() {
        return idBoite;
    }

    public void setIdBoite(String idBoite) {
        this.idBoite = idBoite;
    }

    public String getBoite() {
        return boite;
    }

    public void setBoite(String boite) {
        this.boite = boite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boite boite1 = (Boite) o;
        return Objects.equals(idBoite, boite1.idBoite) && Objects.equals(boite, boite1.boite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBoite, boite);
    }
}
