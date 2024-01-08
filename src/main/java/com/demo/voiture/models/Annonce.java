package com.demo.voiture.models;

import jakarta.persistence.*;
// import org.hibernate.annotations.ColumnDefault;

import com.demo.voiture.dto.AnnonceDto;

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

    public Annonce() {
        this.dateAnnonce = new Date(System.currentTimeMillis()); // ou utilisez java.sql.Date.valueOf(LocalDate.now()) pour SQL Date
        this.etat = 0;
    }

    public void defaultColumn() {
        this.dateAnnonce = new Date(System.currentTimeMillis()); // ou utilisez java.sql.Date.valueOf(LocalDate.now()) pour SQL Date
        this.etat = 0;
    }
    
   
    public Annonce(String idUsers, String idVoiture, String idFicheTechnique, String idCategorie,
                   Double kilometrage, Double etatVoiture, String description, Double prixVente) throws Exception { 
        try {
            this.setIdUsers(idUsers);
            this.setIdVoiture(idVoiture);
            this.setIdFicheTechnique(idFicheTechnique);
            this.setIdCategorie(idCategorie);
            this.setKilometrage(kilometrage);
            this.setEtatVoiture(etatVoiture);
            this.setDescription(description);
            this.setPrixVente(prixVente);
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        
    }

    public Annonce(AnnonceDto annonceDto) throws Exception {
        try {
            this.setIdUsers(annonceDto.getIdUsers());
            this.setIdVoiture(annonceDto.getIdVoiture());
            this.setIdFicheTechnique(annonceDto.getIdFicheTechnique());
            this.setIdCategorie(annonceDto.getIdCategorie());
            this.setKilometrage(annonceDto.getKilometrage());
            this.setEtatVoiture(annonceDto.getEtatVoiture());
            this.setDescription(annonceDto.getDescription());
            this.setPrixVente(annonceDto.getPrixVente());
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
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

    public void setKilometrage(Double kilometrage) throws Exception {
        if(kilometrage < 0) {
            throw new Exception("Invalide Kilometrage");
        }
        this.kilometrage = kilometrage;
    }

    public Double getEtatVoiture() {
        return etatVoiture;
    }

    public void setEtatVoiture(Double etatVoiture) throws Exception {
        if(etatVoiture < 0 || etatVoiture > 10) {
            throw new Exception("Etat entre 0 a 10");
        }
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

    public void setPrixVente(Double prixVente)  throws Exception {
        if(prixVente<0) {
            throw new Exception("Invalide prix de vente");
        }
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
