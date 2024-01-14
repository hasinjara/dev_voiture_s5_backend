package com.demo.voiture.models.stat;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "v_stat_vendeur_mensuel", schema = "public", catalog = "voiture")
public class StatVendeurMensuel {
    @Id
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
    @Basic
    @Column(name = "mois", nullable = true, precision = 0)
    private BigInteger mois;
    @Basic
    @Column(name = "anne", nullable = true, precision = 0)
    private BigInteger anne;
    @Basic
    @Column(name = "nb_commission", nullable = true, precision = 0)
    private BigInteger nbCommission;
    @Basic
    @Column(name = "commission_total", nullable = true, precision = 0)
    private Double commissionTotal;

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

    public BigInteger getMois() {
        return mois;
    }

    public void setMois(BigInteger mois) {
        this.mois = mois;
    }

    public BigInteger getAnne() {
        return anne;
    }

    public void setAnne(BigInteger anne) {
        this.anne = anne;
    }

    public BigInteger getNbCommission() {
        return nbCommission;
    }

    public void setNbCommission(BigInteger nbCommission) {
        this.nbCommission = nbCommission;
    }

    public Double getCommissionTotal() {
        return commissionTotal;
    }

    public void setCommissionTotal(Double commissionTotal) {
        this.commissionTotal = commissionTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatVendeurMensuel that = (StatVendeurMensuel) o;
        return Objects.equals(idUsers, that.idUsers) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(mail, that.mail) && Objects.equals(mois, that.mois) && Objects.equals(anne, that.anne) && Objects.equals(nbCommission, that.nbCommission) && Objects.equals(commissionTotal, that.commissionTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsers, nom, prenom, mail, mois, anne, nbCommission, commissionTotal);
    }
}
