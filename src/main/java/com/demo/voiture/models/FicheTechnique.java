package com.demo.voiture.models;

import jakarta.persistence.*;

import java.util.Objects;

import com.demo.voiture.dto.FicheTechniqueDto;

@Entity
@Table(name = "fiche_technique", schema = "public", catalog = "voiture")
public class FicheTechnique {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fiche_technique", nullable = false, length = -1)
    private String idFicheTechnique;
    @Basic
    @Column(name = "id_voiture", nullable = false, length = -1)
    private String idVoiture;
    @Basic
    @Column(name = "id_energie", nullable = false, length = -1)
    private String idEnergie;
    @Basic
    @Column(name = "id_boite", nullable = false, length = -1)
    private String idBoite;
    @Basic
    @Column(name = "moteur", nullable = true, length = -1)
    private String moteur;
    @Basic
    @Column(name = "litre_moteur", nullable = true, precision = 0)
    private Double litreMoteur;
    @Basic
    @Column(name = "consommation", nullable = true, precision = 0)
    private Double consommation;
    @Basic
    @Column(name = "puissance", nullable = true, precision = 0)
    private Double puissance;
    @Basic
    @Column(name = "nb_vitesse", nullable = true, precision = 0)
    private Double nbVitesse;
    @Basic
    @Column(name = "nb_place", nullable = true, precision = 0)
    private Double nbPlace;
    @Basic
    @Column(name = "nb_porte", nullable = true, precision = 0)
    private Double nbPorte;
    @Basic
    @Column(name = "longueur", nullable = true, precision = 0)
    private Double longueur;
    @Basic
    @Column(name = "poids", nullable = true, precision = 0)
    private Double poids;

    public FicheTechnique() {
    }

    public FicheTechnique(FicheTechniqueDto ficheTechniqueDto) throws Exception {
        try {
            setIdVoiture(ficheTechniqueDto.getIdVoiture());
            setIdEnergie(ficheTechniqueDto.getIdEnergie());
            setIdBoite(ficheTechniqueDto.getIdBoite());
            setMoteur(ficheTechniqueDto.getMoteur());
            setLitreMoteur(ficheTechniqueDto.getLitreMoteur());
            setConsommation(ficheTechniqueDto.getConsommation());
            setPuissance(ficheTechniqueDto.getPuissance());
            setNbVitesse(ficheTechniqueDto.getNbVitesse());
            setNbPorte(ficheTechniqueDto.getNbPorte());
            setNbPlace(ficheTechniqueDto.getNbPlace());
            setLongueur(ficheTechniqueDto.getLongueur());
            setPoids(ficheTechniqueDto.getPoids());
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
    }

    public String getIdFicheTechnique() {
        return idFicheTechnique;
    }

    public void setIdFicheTechnique(String idFicheTechnique) {
        this.idFicheTechnique = idFicheTechnique;
    }

    public String getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(String idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(String idEnergie) {
        this.idEnergie = idEnergie;
    }

    public String getIdBoite() {
        return idBoite;
    }

    public void setIdBoite(String idBoite) {
        this.idBoite = idBoite;
    }

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public Double getLitreMoteur() {
        return litreMoteur;
    }

    public void setLitreMoteur(Double litreMoteur) throws Exception {
        if(litreMoteur <= 1 || litreMoteur > 10) {
            throw new Exception("Seulement entre 1l a 10l");
        }
        this.litreMoteur = litreMoteur;
    }

    public Double getConsommation() {
        return consommation;
    }

    public void setConsommation(Double consommation) throws Exception {
        if(consommation <= 0 || consommation > 100) {
            throw new Exception("Consommation entre 0.1 a 100");
        }
        this.consommation = consommation;
    }

    public Double getPuissance() {
        return puissance;
    }

    public void setPuissance(Double puissance) throws Exception {
        if(puissance <= 0 || puissance > 100) {
            throw new Exception("Puissance entre 1 a 100 CV");
        }
        this.puissance = puissance;
    }

    public Double getNbVitesse() {
        return nbVitesse;
    }

    public void setNbVitesse(Double nbVitesse) throws Exception {
        if(nbVitesse<=0 || nbVitesse > 25) {
            throw new Exception("On se limite de 1 a 25 vitesses");
        }
        this.nbVitesse = nbVitesse;
    }

    public Double getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Double nbPlace) throws Exception {
        if(nbPlace <= 0 || nbPlace > 50) {
            throw new Exception("Nombre de place compris entre 1 a 50");
        }
        this.nbPlace = nbPlace;
    }

    public Double getNbPorte()  {
        return nbPorte;
    }

    public void setNbPorte(Double nbPorte) throws Exception {
        if(nbPorte <= 0 || nbPorte > 10) {
            throw new Exception("On connait que 1 a 10 portes aux maximum");
        }
        this.nbPorte = nbPorte;
    }

    public Double getLongueur() {
        return longueur;
    }

    public void setLongueur(Double longueur) throws Exception {
        if(longueur <=0 || longueur > 25) {
            throw new Exception("On connait que a partir de 0 a 25 m de longueur");
        }
        this.longueur = longueur;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) throws Exception {
        if(poids <= 200 || poids > 25*1000 ) {
            throw new Exception("Le poids doit etre entre 200 a 25 000 kg");
        }
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheTechnique that = (FicheTechnique) o;
        return Objects.equals(idFicheTechnique, that.idFicheTechnique) && Objects.equals(idVoiture, that.idVoiture) && Objects.equals(idEnergie, that.idEnergie) && Objects.equals(idBoite, that.idBoite) && Objects.equals(moteur, that.moteur) && Objects.equals(litreMoteur, that.litreMoteur) && Objects.equals(consommation, that.consommation) && Objects.equals(puissance, that.puissance) && Objects.equals(nbVitesse, that.nbVitesse) && Objects.equals(nbPlace, that.nbPlace) && Objects.equals(nbPorte, that.nbPorte) && Objects.equals(longueur, that.longueur) && Objects.equals(poids, that.poids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFicheTechnique, idVoiture, idEnergie, idBoite, moteur, litreMoteur, consommation, puissance, nbVitesse, nbPlace, nbPorte, longueur, poids);
    }
}
