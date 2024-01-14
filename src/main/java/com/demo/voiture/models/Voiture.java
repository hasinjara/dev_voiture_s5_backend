package com.demo.voiture.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import com.demo.voiture.dto.VoitureDto;

@Entity
public class Voiture {
    

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_voiture", nullable = false, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "nom_modele", nullable = false, length = -1)
    private String nomModele;
    @Basic
    @Column(name = "anne_sortie", nullable = false)
    private int anneSortie;
    @Basic
    @Column(name = "id_marque", nullable = false, length = -1)
    private String idMarque;


    public Voiture() {
    }

    public Voiture(VoitureDto voitureDto) throws Exception {
        try {
            setNomModele(voitureDto.getNomModele());
            setIdMarque(voitureDto.getIdMarque());
            setAnneSortie(voitureDto.getAnneSortie());
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    

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

    public int getAnneSortie() {
        return anneSortie;
    }

    

    public void setAnneSortie(int anneSortie) throws Exception {
        // Obtenez la date actuelle
        LocalDate currentDate = LocalDate.now();

        // Obtenez l'année de la date actuelle
        int currentYear = currentDate.getYear();
        if(anneSortie < 1885) {
            throw new Exception("Annee de sortie entre 1885 jusq'a aujourd'hui "+ currentYear);
        }
        if(anneSortie > currentYear) {
            throw new Exception("Annee de sortie entre 1885 jusq'a aujourd'hui "+ currentYear);
        }
        else {
            this.anneSortie = anneSortie;
        }
        
    }

    public String getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(String idMarque) {
        this.idMarque = idMarque;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return anneSortie == voiture.anneSortie && Objects.equals(idVoiture, voiture.idVoiture) && Objects.equals(nomModele, voiture.nomModele) && Objects.equals(idMarque, voiture.idMarque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoiture, nomModele, anneSortie, idMarque);
    }
}
