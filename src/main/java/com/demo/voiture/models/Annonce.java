package com.demo.voiture.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Annonce {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_annonce", nullable = false, length = -1)
    private String idAnnonce;
    @Basic
    @Column(name = "id_users", nullable = false, length = -1)
    private String idUsers;
    @Basic
    @Column(name = "id_voiture", nullable = false, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "id_fiche_technique", nullable = false, length = -1)
    private String idFicheTechnique;
    @Basic
    @Column(name = "id_categorie", nullable = false, length = -1)
    private String idCategorie;
    @Basic
    @Column(name = "kilometrage", nullable = true, precision = 0)
    private Double kilometrage;
    @Basic
    @Column(name = "etat_voiture", nullable = true, precision = 0)
    private Double etatVoiture;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "prix_vente", nullable = true, precision = 0)
    private Double prixVente;
    @Basic
    @Column(name = "date_annonce", nullable = true)
    private Date dateAnnonce;
    @Basic
    @Column(name = "etat", nullable = true)
    private Integer etat;

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getIdFicheTechnique() {
        return idFicheTechnique;
    }

    public void setIdFicheTechnique(String idFicheTechnique) {
        this.idFicheTechnique = idFicheTechnique;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Double getEtatVoiture() {
        return etatVoiture;
    }

    public void setEtatVoiture(Double etatVoiture) {
        this.etatVoiture = etatVoiture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Date getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Date dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annonce annonce = (Annonce) o;
        return Objects.equals(idAnnonce, annonce.idAnnonce) && Objects.equals(idUsers, annonce.idUsers) && Objects.equals(idVoiture, annonce.idVoiture) && Objects.equals(idFicheTechnique, annonce.idFicheTechnique) && Objects.equals(idCategorie, annonce.idCategorie) && Objects.equals(kilometrage, annonce.kilometrage) && Objects.equals(etatVoiture, annonce.etatVoiture) && Objects.equals(description, annonce.description) && Objects.equals(prixVente, annonce.prixVente) && Objects.equals(dateAnnonce, annonce.dateAnnonce) && Objects.equals(etat, annonce.etat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnnonce, idUsers, idVoiture, idFicheTechnique, idCategorie, kilometrage, etatVoiture, description, prixVente, dateAnnonce, etat);
    }
}
