package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_details_voiture", schema = "public", catalog = "voiture")
public class VDetailsVoiture {
    @Basic
    @Column(name = "nom_modele", nullable = true, length = -1)
    private String nomModele;
    @Basic
    @Column(name = "anne_sortie", nullable = true)
    private Integer anneSortie;
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
    @Column(name = "id_fiche_technique", nullable = true, length = -1)
    private String idFicheTechnique;

    @Id
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "id_energie", nullable = true, length = -1)
    private String idEnergie;
    @Basic
    @Column(name = "id_boite", nullable = true, length = -1)
    private String idBoite;
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
    @Column(name = "energie", nullable = true, length = -1)
    private String energie;
    @Basic
    @Column(name = "boite", nullable = true, length = -1)
    private String boite;

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

    public String getIdFicheTechnique() {
        return idFicheTechnique;
    }

    public void setIdFicheTechnique(String idFicheTechnique) {
        this.idFicheTechnique = idFicheTechnique;
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(String idEnergie) {
        this.idEnergie = idEnergie;
    }

    public String getIdBoite() {
        return idBoite;
    }

    public void setIdBoite(String idBoite) {
        this.idBoite = idBoite;
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

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
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
        VDetailsVoiture that = (VDetailsVoiture) o;
        return Objects.equals(nomModele, that.nomModele) && Objects.equals(anneSortie, that.anneSortie) && Objects.equals(marque, that.marque) && Objects.equals(idCategorie, that.idCategorie) && Objects.equals(categorie, that.categorie) && Objects.equals(idFicheTechnique, that.idFicheTechnique) && Objects.equals(idVoiture, that.idVoiture) && Objects.equals(idEnergie, that.idEnergie) && Objects.equals(idBoite, that.idBoite) && Objects.equals(moteur, that.moteur) && Objects.equals(litreMoteur, that.litreMoteur) && Objects.equals(consommation, that.consommation) && Objects.equals(puissance, that.puissance) && Objects.equals(nbVitesse, that.nbVitesse) && Objects.equals(nbPlace, that.nbPlace) && Objects.equals(nbPorte, that.nbPorte) && Objects.equals(longueur, that.longueur) && Objects.equals(poids, that.poids) && Objects.equals(energie, that.energie) && Objects.equals(boite, that.boite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomModele, anneSortie, marque, idCategorie, categorie, idFicheTechnique, idVoiture, idEnergie, idBoite, moteur, litreMoteur, consommation, puissance, nbVitesse, nbPlace, nbPorte, longueur, poids, energie, boite);
    }
}
