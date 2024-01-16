package com.demo.voiture.models;

import jakarta.persistence.*;

@Entity
@Table(name = "annonce_photo", schema = "public", catalog = "voiture")
public class AnnoncePhoto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_annonce_photo", nullable = false, length = -1)
    private String idAnnoncePhoto;
    @Basic
    @Column(name = "id_annonce", nullable = false, length = -1)
    private String idAnnonce;
    @Basic
    @Column(name = "url_photo", nullable = false, length = -1)
    private String urlPhoto;
    
    
    public AnnoncePhoto(String idAnnonce, String urlPhoto) {
        this.idAnnonce = idAnnonce;
        this.urlPhoto = urlPhoto;
    }

    public AnnoncePhoto() {
    }
    
    public String getIdAnnoncePhoto() {
        return idAnnoncePhoto;
    }
    public void setIdAnnoncePhoto(String idAnnoncePhoto) {
        this.idAnnoncePhoto = idAnnoncePhoto;
    }
    public String getIdAnnonce() {
        return idAnnonce;
    }
    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }
    public String getUrlPhoto() {
        return urlPhoto;
    }
    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    

}
