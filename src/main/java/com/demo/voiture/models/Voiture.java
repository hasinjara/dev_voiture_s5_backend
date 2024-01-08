package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Voiture {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_voiture", nullable = false, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = false, length = -1)
    private String nomModele;
    @Basic
    @Column(name = "anne_sortie", nullable = false)
    private int anneSortie;
    @Basic
    @Column(name = "id_marque", nullable = false, length = -1)
    private String idMarque;

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

    public int getAnneSortie() {
        return anneSortie;
    }

    public void setAnneSortie(int anneSortie) {
        this.anneSortie = anneSortie;
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return anneSortie == voiture.anneSortie && Objects.equals(idVoiture, voiture.idVoiture) && Objects.equals(nomModele, voiture.nomModele) && Objects.equals(idMarque, voiture.idMarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, anneSortie, idMarque);
    }
}
