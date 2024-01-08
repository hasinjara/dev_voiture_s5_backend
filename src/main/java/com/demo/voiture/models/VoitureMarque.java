package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_voiture_marque", schema = "public", catalog = "voiture")
public class VoitureMarque {

    @Id
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = true, length = -1)
    private String nomModele;
    @Basic
    @Column(name = "anne_sortie", nullable = true)
    private Integer anneSortie;
    @Basic
    @Column(name = "id_marque", nullable = true, length = -1)
    private String idMarque;
    @Basic
    @Column(name = "marque", nullable = true, length = -1)
    private String marque;

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

    public Integer getAnneSortie() {
        return anneSortie;
    }

    public void setAnneSortie(Integer anneSortie) {
        this.anneSortie = anneSortie;
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoitureMarque that = (VoitureMarque) o;
        return Objects.equals(idVoiture, that.idVoiture) && Objects.equals(nomModele, that.nomModele) && Objects.equals(anneSortie, that.anneSortie) && Objects.equals(idMarque, that.idMarque) && Objects.equals(marque, that.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, anneSortie, idMarque, marque);
    }
}
