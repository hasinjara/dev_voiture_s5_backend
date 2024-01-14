package com.demo.voiture.models.stat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "v_stat_voiture_global", schema = "public", catalog = "voiture")
public class VStatVoitureGlobal {
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = true, length = -1)
    private String nomModele;
    @Basic
    @Column(name = "nb_annonce", nullable = true)
    private Long nbAnnonce;

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

    public Long getNbAnnonce() {
        return nbAnnonce;
    }

    public void setNbAnnonce(Long nbAnnonce) {
        this.nbAnnonce = nbAnnonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VStatVoitureGlobal that = (VStatVoitureGlobal) o;
        return Objects.equals(idVoiture, that.idVoiture) && Objects.equals(nomModele, that.nomModele) && Objects.equals(nbAnnonce, that.nbAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, nbAnnonce);
    }
}
