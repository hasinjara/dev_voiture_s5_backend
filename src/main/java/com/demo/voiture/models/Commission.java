package com.demo.voiture.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Commission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_commission", nullable = false, length = -1)
    private String idCommission;
    @Basic
    @Column(name = "id_annonce", nullable = false, length = -1)
    private String idAnnonce;
    @Basic
    @Column(name = "marge", nullable = true, precision = 0)
    private Double marge;
    @Basic
    @Column(name = "prix_vente", nullable = true, precision = 0)
    private Double prixVente;
    @Basic
    @Column(name = "commission", nullable = true, precision = 0)
    private Double commission;
    @Basic
    @Column(name = "date_commission", nullable = true)
    private Date dateCommission;


    

    public Commission(String idAnnonce, Double marge, Double prixVente, Double commission) throws Exception {
        try {
            setIdAnnonce(idAnnonce);
            setCommission(commission);
            setMarge(marge);
            setPrixVente(prixVente);
            setDateCommission( new Date( System.currentTimeMillis() ) );
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Commission(String idAnnonce, Double commission) throws Exception {
        try {
            setIdAnnonce(idAnnonce);
            setCommission(commission);
            setDateCommission( new Date( System.currentTimeMillis() ) );
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public Commission() {
    }

    

    

    public String getIdCommission() {
        return idCommission;
    }

    public void setIdCommission(String idCommission) {
        this.idCommission = idCommission;
    }

    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) throws Exception {
        if(commission < 0) {
            throw new Exception("Invalide commission");
        }
        this.commission = commission;
    }

    public Date getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Date dateCommission) {
        this.dateCommission = dateCommission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commission that = (Commission) o;
        return Objects.equals(idCommission, that.idCommission) && Objects.equals(idAnnonce, that.idAnnonce) && Objects.equals(commission, that.commission) && Objects.equals(dateCommission, that.dateCommission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommission, idAnnonce, commission, dateCommission);
    }

    public Double getMarge() {
        return marge;
    }

    public void setMarge(Double marge) {
        this.marge = marge;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }
}
