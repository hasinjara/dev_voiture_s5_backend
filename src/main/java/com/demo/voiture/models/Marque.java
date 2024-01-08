package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Marque {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_marque", nullable = false, length = -1)
    private String idMarque;
    @Basic
    @Column(name = "marque", nullable = false, length = -1)
    private String marque;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque1 = (Marque) o;
        return Objects.equals(idMarque, marque1.idMarque) && Objects.equals(marque, marque1.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarque, marque);
    }
}
