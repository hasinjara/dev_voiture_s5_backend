package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "v_commission", schema = "public", catalog = "voiture")
public class VCommission {

    @Id
    @Basic
    @Column(name = "id_commission", nullable = true, length = -1)
    private String idCommission;
    @Basic
    @Column(name = "id_annonce", nullable = true, length = -1)
    private String idAnnonce;
    @Basic
    @Column(name = "marge", nullable = true, precision = 0)
    private Double marge;
    @Basic
    @Column(name = "prix_vente", nullable = true, precision = 0)
    private Double prixVente;
    @Basic
    @Column(name = "commission", nullable = true, precision = 0)
    private Double commission;
    @Basic
    @Column(name = "date_commission", nullable = true)
    private Date dateCommission;
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = true, length = -1)
    private String nomModele;
    @Basic
    @Column(name = "id_marque", nullable = true, length = -1)
    private String idMarque;
    @Basic
    @Column(name = "marque", nullable = true, length = -1)
    private String marque;
    @Basic
    @Column(name = "id_categorie", nullable = true, length = -1)
    private String idCategorie;
    @Basic
    @Column(name = "categorie", nullable = true, length = -1)
    private String categorie;
    @Basic
    @Column(name = "id_users", nullable = true, length = -1)
    private String idUsers;
    @Basic
    @Column(name = "nom", nullable = true, length = -1)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = -1)
    private String prenom;
    @Basic
    @Column(name = "mail", nullable = true, length = -1)
    private String mail;

    public String getIdCommission() {
        return idCommission;
    }

    public void setIdCommission(String idCommission) {
        this.idCommission = idCommission;
    }

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Double getMarge() {
        return marge;
    }

    public void setMarge(Double marge) {
        this.marge = marge;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Date getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Date dateCommission) {
        this.dateCommission = dateCommission;
    }

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

    public String getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(String idUsers) {
        this.idUsers = idUsers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VCommission that = (VCommission) o;
        return Objects.equals(idCommission, that.idCommission) && Objects.equals(idAnnonce, that.idAnnonce) && Objects.equals(marge, that.marge) && Objects.equals(prixVente, that.prixVente) && Objects.equals(commission, that.commission) && Objects.equals(dateCommission, that.dateCommission) && Objects.equals(idVoiture, that.idVoiture) && Objects.equals(nomModele, that.nomModele) && Objects.equals(idMarque, that.idMarque) && Objects.equals(marque, that.marque) && Objects.equals(idCategorie, that.idCategorie) && Objects.equals(categorie, that.categorie) && Objects.equals(idUsers, that.idUsers) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommission, idAnnonce, marge, prixVente, commission, dateCommission, idVoiture, nomModele, idMarque, marque, idCategorie, categorie, idUsers, nom, prenom, mail);
    }
}
