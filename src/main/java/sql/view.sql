create or replace view v_voiture_marque as
    select 
    voiture.*,
    marque.marque
        from voiture 
        join marque on voiture.id_marque = marque.id_marque;


create or replace view v_voiture_categorie as
    select 
        voiture.*,
        voiture_categorie.id_categorie,
        categorie.categorie
        from
            voiture
            join voiture_categorie on voiture.id_voiture = voiture_categorie.id_voiture
            join categorie on categorie.id_categorie = voiture_categorie.id_categorie;

create or replace view v_details_fiche_techniques as
    select
        fiche_technique.*,
        energie.energie,
        boite.boite
        from
            fiche_technique 
            join energie on fiche_technique.id_energie = energie.id_energie
            join boite on fiche_technique.id_boite = boite.id_boite;

create or replace view v_details_voiture as
    select 
        voiture.nom_modele,
        voiture.anne_sortie,
        v_voiture_marque.marque,
        v_voiture_categorie.id_categorie,
        v_voiture_categorie.categorie,
        v_details_fiche_techniques.*
        from 
        voiture
            join v_voiture_marque on voiture.id_voiture = v_voiture_marque.id_voiture
            join v_voiture_categorie on voiture.id_voiture = v_voiture_categorie.id_voiture
            join v_details_fiche_techniques on voiture.id_voiture = v_details_fiche_techniques.id_voiture;


create or replace view v_details_annonce as
    select 
    annonce.*,
    v_voiture_marque.nom_modele, 
    v_voiture_marque.anne_sortie,
    v_voiture_marque.id_marque, v_voiture_marque.marque,
    categorie.categorie,
    v_details_fiche_techniques.id_energie, v_details_fiche_techniques.energie,
    v_details_fiche_techniques.id_boite, v_details_fiche_techniques.boite,
    v_details_fiche_techniques.moteur,  v_details_fiche_techniques.litre_moteur,
    v_details_fiche_techniques.consommation, v_details_fiche_techniques.puissance,
    v_details_fiche_techniques.nb_vitesse, v_details_fiche_techniques.nb_place,
    v_details_fiche_techniques.nb_porte, v_details_fiche_techniques.longueur,
    v_details_fiche_techniques.poids,
    users.nom, users.prenom, users.mail
    from
        annonce
        join v_voiture_marque on annonce.id_voiture = v_voiture_marque.id_voiture
        join categorie on annonce.id_categorie = categorie.id_categorie
        join v_details_fiche_techniques on annonce.id_fiche_technique = v_details_fiche_techniques.id_fiche_technique
        join users on annonce.id_users = users.id_users;
