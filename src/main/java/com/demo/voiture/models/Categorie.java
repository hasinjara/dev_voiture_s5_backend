package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categorie", nullable = false, length = -1)
    private String idCategorie;
    @Basic
    @Column(name = "categorie", nullable = false, length = -1)
    private String categorie;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie1 = (Categorie) o;
        return Objects.equals(idCategorie, categorie1.idCategorie) && Objects.equals(categorie, categorie1.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, categorie);
    }
}
