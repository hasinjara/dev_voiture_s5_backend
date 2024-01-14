package com.demo.voiture.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "v_voiture_configure", schema = "public", catalog = "voiture")
public class VVoitureConfigure {
    @Basic
    @Column(name = "id_voiture", nullable = true, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = true, length = -1)
    private String nomModele;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VVoitureConfigure that = (VVoitureConfigure) o;
        return Objects.equals(idVoiture, that.idVoiture) && Objects.equals(nomModele, that.nomModele);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele);
    }
}
