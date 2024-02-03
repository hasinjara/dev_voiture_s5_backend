package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_voiture_categorie")
public class VVoitureCategorie {
    
    @Column(name = "id_voiture", nullable = false, length = -1)
    private String idVoiture;

    @Column(name = "nom_modele", nullable = false, length = -1)
    private String nomModele;

    @Column(name = "anne_sortie", nullable = false)
    private int anneSortie;

    @Column(name = "id_marque", nullable = false, length = -1)
    private String idMarque;

    @Column(name = "id_categorie", nullable = false, length = -1)
    private String idCategorie;

    @Column(name = "categorie", nullable = false, length = -1)
    private String categorie;

    @Id
    @Column(name = "id_voiture_categorie", nullable = false, length = -1)
    private String idVoitureCategorie;

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

    public String getIdVoitureCategorie() {
        return idVoitureCategorie;
    }

    public void setIdVoitureCategorie(String idVoitureCategorie) {
        this.idVoitureCategorie = idVoitureCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VVoitureCategorie that = (VVoitureCategorie) o;
        return anneSortie == that.anneSortie &&
                Objects.equals(idVoiture, that.idVoiture) &&
                Objects.equals(nomModele, that.nomModele) &&
                Objects.equals(idMarque, that.idMarque) &&
                Objects.equals(idCategorie, that.idCategorie) &&
                Objects.equals(categorie, that.categorie) &&
                Objects.equals(idVoitureCategorie, that.idVoitureCategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, anneSortie, idMarque, idCategorie, categorie, idVoitureCategorie);
    }
}
