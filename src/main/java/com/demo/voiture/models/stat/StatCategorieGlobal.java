package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_stat_categorie_global", schema = "public", catalog = "voiture")
public class StatCategorieGlobal {
    @Id
    @Basic
    @Column(name = "id_categorie", nullable = true, length = -1)
    private String idCategorie;
    @Basic
    @Column(name = "categorie", nullable = true, length = -1)
    private String categorie;
    @Basic
    @Column(name = "nb_annonce", nullable = true)
    private Long nbAnnonce;

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
        StatCategorieGlobal that = (StatCategorieGlobal) o;
        return Objects.equals(idCategorie, that.idCategorie) && Objects.equals(categorie, that.categorie) && Objects.equals(nbAnnonce, that.nbAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, categorie, nbAnnonce);
    }
}
