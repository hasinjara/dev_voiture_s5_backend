package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "favoris_user_annonce", schema = "public", catalog = "voiture")
public class FavorisUserAnnonce {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_favoris_user_annonce", nullable = false, length = -1)
    private String idFavorisUserAnnonce;
    @Basic
    @Column(name = "id_annonce", nullable = false, length = -1)
    private String idAnnonce;
    @Basic
    @Column(name = "id_users", nullable = false, length = -1)
    private String idUsers;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavorisUserAnnonce that = (FavorisUserAnnonce) o;
        return Objects.equals(idFavorisUserAnnonce, that.idFavorisUserAnnonce) && Objects.equals(idAnnonce, that.idAnnonce) && Objects.equals(idUsers, that.idUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFavorisUserAnnonce, idAnnonce, idUsers);
    }
}
