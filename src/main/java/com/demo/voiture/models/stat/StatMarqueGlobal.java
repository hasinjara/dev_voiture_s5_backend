package com.demo.voiture.models.stat;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "v_stat_marque_global", schema = "public", catalog = "voiture")
public class VStatMarqueGlobal {
    @Basic
    @Column(name = "id_marque", nullable = true, length = -1)
    private String idMarque;
    @Basic
    @Column(name = "marque", nullable = true, length = -1)
    private String marque;
    @Basic
    @Column(name = "nb_annonce", nullable = true)
    private Long nbAnnonce;

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
        VStatMarqueGlobal that = (VStatMarqueGlobal) o;
        return Objects.equals(idMarque, that.idMarque) && Objects.equals(marque, that.marque) && Objects.equals(nbAnnonce, that.nbAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarque, marque, nbAnnonce);
    }
}
