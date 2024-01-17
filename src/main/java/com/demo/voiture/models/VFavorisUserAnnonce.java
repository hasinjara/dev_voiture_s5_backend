package com.demo.voiture.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "v_favoris_user_annonce", schema = "public", catalog = "voiture")
public class VFavorisUserAnnonce {
    @Basic
    @Column(name = "id_favoris_user_annonce", nullable = true, length = -1)
    private String idFavorisUserAnnonce;
    @Basic
    @Column(name = "id_annonce", nullable = true, length = -1)
    private String idAnnonce;
    @Basic
    @Column(name = "id_users", nullable = true, length = -1)
    private String idUsers;
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "id_fiche_technique", nullable = true, length = -1)
    private String idFicheTechnique;
    @Basic
    @Column(name = "id_categorie", nullable = true, length = -1)
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
    @Basic
    @Column(name = "categorie", nullable = true, length = -1)
    private String categorie;
    @Basic
    @Column(name = "id_energie", nullable = true, length = -1)
    private String idEnergie;
    @Basic
    @Column(name = "energie", nullable = true, length = -1)
    private String energie;
    @Basic
    @Column(name = "id_boite", nullable = true, length = -1)
    private String idBoite;
    @Basic
    @Column(name = "boite", nullable = true, length = -1)
    private String boite;
    @Basic
    @Column(name = "moteur", nullable = true, length = -1)
    private String moteur;
    @Basic
    @Column(name = "litre_moteur", nullable = true, precision = 0)
    private Double litreMoteur;
    @Basic
    @Column(name = "consommation", nullable = true, precision = 0)
    private Double consommation;
    @Basic
    @Column(name = "puissance", nullable = true, precision = 0)
    private Double puissance;
    @Basic
    @Column(name = "nb_vitesse", nullable = true, precision = 0)
    private Double nbVitesse;
    @Basic
    @Column(name = "nb_place", nullable = true, precision = 0)
    private Double nbPlace;
    @Basic
    @Column(name = "nb_porte", nullable = true, precision = 0)
    private Double nbPorte;
    @Basic
    @Column(name = "longueur", nullable = true, precision = 0)
    private Double longueur;
    @Basic
    @Column(name = "poids", nullable = true, precision = 0)
    private Double poids;
    @Basic
    @Column(name = "nom", nullable = true, length = -1)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = true, length = -1)
    private String prenom;
    @Basic
    @Column(name = "mail", nullable = true, length = -1)
    private String mail;

    public String getIdFavorisUserAnnonce() {
        return idFavorisUserAnnonce;
    }

    public void setIdFavorisUserAnnonce(String idFavorisUserAnnonce) {
        this.idFavorisUserAnnonce = idFavorisUserAnnonce;
    }

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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

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

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public Double getLitreMoteur() {
        return litreMoteur;
    }

    public void setLitreMoteur(Double litreMoteur) {
        this.litreMoteur = litreMoteur;
    }

    public Double getConsommation() {
        return consommation;
    }

    public void setConsommation(Double consommation) {
        this.consommation = consommation;
    }

    public Double getPuissance() {
        return puissance;
    }

    public void setPuissance(Double puissance) {
        this.puissance = puissance;
    }

    public Double getNbVitesse() {
        return nbVitesse;
    }

    public void setNbVitesse(Double nbVitesse) {
        this.nbVitesse = nbVitesse;
    }

    public Double getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Double nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Double getNbPorte() {
        return nbPorte;
    }

    public void setNbPorte(Double nbPorte) {
        this.nbPorte = nbPorte;
    }

    public Double getLongueur() {
        return longueur;
    }

    public void setLongueur(Double longueur) {
        this.longueur = longueur;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
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
        VFavorisUserAnnonce that = (VFavorisUserAnnonce) o;
        return Objects.equals(idFavorisUserAnnonce, that.idFavorisUserAnnonce) && Objects.equals(idAnnonce, that.idAnnonce) && Objects.equals(idUsers, that.idUsers) && Objects.equals(idVoiture, that.idVoiture) && Objects.equals(idFicheTechnique, that.idFicheTechnique) && Objects.equals(idCategorie, that.idCategorie) && Objects.equals(kilometrage, that.kilometrage) && Objects.equals(etatVoiture, that.etatVoiture) && Objects.equals(description, that.description) && Objects.equals(prixVente, that.prixVente) && Objects.equals(dateAnnonce, that.dateAnnonce) && Objects.equals(etat, that.etat) && Objects.equals(nomModele, that.nomModele) && Objects.equals(anneSortie, that.anneSortie) && Objects.equals(idMarque, that.idMarque) && Objects.equals(marque, that.marque) && Objects.equals(categorie, that.categorie) && Objects.equals(idEnergie, that.idEnergie) && Objects.equals(energie, that.energie) && Objects.equals(idBoite, that.idBoite) && Objects.equals(boite, that.boite) && Objects.equals(moteur, that.moteur) && Objects.equals(litreMoteur, that.litreMoteur) && Objects.equals(consommation, that.consommation) && Objects.equals(puissance, that.puissance) && Objects.equals(nbVitesse, that.nbVitesse) && Objects.equals(nbPlace, that.nbPlace) && Objects.equals(nbPorte, that.nbPorte) && Objects.equals(longueur, that.longueur) && Objects.equals(poids, that.poids) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavorisUserAnnonce, idAnnonce, idUsers, idVoiture, idFicheTechnique, idCategorie, kilometrage, etatVoiture, description, prixVente, dateAnnonce, etat, nomModele, anneSortie, idMarque, marque, categorie, idEnergie, energie, idBoite, boite, moteur, litreMoteur, consommation, puissance, nbVitesse, nbPlace, nbPorte, longueur, poids, nom, prenom, mail);
    }
}
