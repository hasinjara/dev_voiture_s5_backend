package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_voiture_categorie", schema = "public", catalog = "voiture")
public class DetailsVoitureCategorie {

    
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
    @Column(name = "id_categorie", nullable = true, length = -1)
    private String idCategorie;
    @Id
    @Basic
    @Column(name = "categorie", nullable = true, length = -1)
    private String categorie;

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
        DetailsVoitureCategorie that = (DetailsVoitureCategorie) o;
        return Objects.equals(idVoiture, that.idVoiture) && Objects.equals(nomModele, that.nomModele) && Objects.equals(anneSortie, that.anneSortie) && Objects.equals(idMarque, that.idMarque) && Objects.equals(idCategorie, that.idCategorie) && Objects.equals(categorie, that.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, anneSortie, idMarque, idCategorie, categorie);
    }
}
