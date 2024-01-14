package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "voiture_categorie", schema = "public", catalog = "voiture")
public class VoitureCategorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_voiture_categorie", nullable = false, length = -1)
    private String idVoitureCategorie;
    @Basic
    @Column(name = "id_voiture", nullable = false, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "id_categorie", nullable = false, length = -1)
    private String idCategorie;

    

    public VoitureCategorie(String idVoiture, String idCategorie) {
        this.idVoiture = idVoiture;
        this.idCategorie = idCategorie;
    }



    public VoitureCategorie() {
    }

    

    public String getIdVoitureCategorie() {
        return idVoitureCategorie;
    }

    public void setIdVoitureCategorie(String idVoitureCategorie) {
        this.idVoitureCategorie = idVoitureCategorie;
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoitureCategorie that = (VoitureCategorie) o;
        return Objects.equals(idVoitureCategorie, that.idVoitureCategorie) && Objects.equals(idVoiture, that.idVoiture) && Objects.equals(idCategorie, that.idCategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoitureCategorie, idVoiture, idCategorie);
    }
}
