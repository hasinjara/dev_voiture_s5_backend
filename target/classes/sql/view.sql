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

create or replace view v_annonce_refuse as
    select * from v_details_annonce where etat = 10;

create or replace view v_annonce_valide as
    select * from v_details_annonce where etat = 20;

create or replace view v_annonce_vendu as
    select * from v_details_annonce where etat = 30;

create or replace view v_voiture_configure as
    select 
        voiture.id_voiture, nom_modele
        from 
        voiture 
            left join fiche_technique on fiche_technique.id_voiture = voiture.id_voiture
            where fiche_technique.* is not null
        group by voiture.id_voiture, voiture.nom_modele
        order by voiture.id_voiture;

-- insert into commission (id_annonce, marge, prix_vente, commission) 
-- values ('AN2', 10, 5000,500); 

create or replace view v_commission as
    select
    commission.*,
    v_annonce_vendu.id_voiture, v_annonce_vendu.nom_modele,
    v_annonce_vendu.id_marque, v_annonce_vendu.marque,
    v_annonce_vendu.id_categorie, v_annonce_vendu.categorie,
    v_annonce_vendu.id_users, v_annonce_vendu.nom, v_annonce_vendu.prenom,
    v_annonce_vendu.mail
    from 
        commission
        join v_annonce_vendu on commission.id_annonce = v_annonce_vendu.id_annonce;


--- voiture
create or replace view v_stat_voiture_journalier as
    select 
    v_commission.id_voiture, v_commission.nom_modele,
    EXTRACT(Year FROM date_commission) as anne,
    EXTRACT(month FROM date_commission) as mois,
    EXTRACT(day FROM date_commission) as jour,
    count(*) as nb_commission,
    sum(commission) as commission_total
    from v_commission
        group by 
            id_voiture, nom_modele, jour, anne, mois;

create or replace view v_stat_voiture_mensuel as
    select 
    v_stat_voiture_journalier.id_voiture, v_stat_voiture_journalier.nom_modele,
    mois, anne,
    sum(nb_commission) as nb_commission,
    sum(commission_total) as commission_total
    from v_stat_voiture_journalier
        group by 
            id_voiture, nom_modele, anne, mois;

-- marque
create or replace view v_stat_marque_journalier as
    select 
    v_commission.id_marque, v_commission.marque,
    EXTRACT(Year FROM date_commission) as anne,
    EXTRACT(month FROM date_commission) as mois,
    EXTRACT(day FROM date_commission) as jour,
    count(*) as nb_commission,
    sum(commission) as commission_total
    from v_commission
        group by 
            id_marque, marque, jour, anne, mois;

create or replace view v_stat_marque_mensuel as
    select 
    v_stat_marque_journalier.id_marque, v_stat_marque_journalier.marque,
    mois, anne,
    sum(nb_commission) as nb_commission,
    sum(commission_total) as commission_total
    from v_stat_marque_journalier
        group by 
            id_marque, marque, anne, mois
            order by mois, anne;

-- categorie
create or replace view v_stat_categorie_journalier as
    select 
    v_commission.id_categorie, v_commission.categorie,
    EXTRACT(Year FROM date_commission) as anne,
    EXTRACT(month FROM date_commission) as mois,
    EXTRACT(day FROM date_commission) as jour,
    count(*) as nb_commission,
    sum(commission) as commission_total
    from v_commission
        group by 
            id_categorie, categorie, jour, anne, mois;

create or replace view v_stat_categorie_mensuel as
    select 
    v_stat_categorie_journalier.id_categorie, v_stat_categorie_journalier.categorie,
    mois, anne,
    sum(nb_commission) as nb_commission,
    sum(commission_total) as commission_total
    from v_stat_categorie_journalier
        group by 
            id_categorie, categorie, anne, mois
            order by mois, anne;

 -- users - vendeur
 create or replace view v_stat_vendeur_journalier as
    select 
    v_commission.id_users, v_commission.nom,
    v_commission.prenom, v_commission.mail,
    EXTRACT(Year FROM date_commission) as anne,
    EXTRACT(month FROM date_commission) as mois,
    EXTRACT(day FROM date_commission) as jour,
    count(*) as nb_commission,
    sum(commission) as commission_total
    from v_commission
        group by 
            id_users, nom, prenom, mail, jour, anne, mois;

create or replace view v_stat_vendeur_mensuel as
    select 
    v_stat_vendeur_journalier.id_users, v_stat_vendeur_journalier.nom,
    prenom, mail,
    mois, anne,
    sum(nb_commission) as nb_commission,
    sum(commission_total) as commission_total
    from v_stat_vendeur_journalier
        group by 
            id_users, nom, prenom, mail, anne, mois
            order by mois, anne;           

-- nb user inscrits / mois
create or replace view v_users as
    select
    count(*) as nb_users,
        EXTRACT(Year FROM date_inscription) as anne,
        EXTRACT(month FROM date_inscription) as mois
    from users
    where role = 'ROLE_USER' 
        group by date_inscription, mois, anne
        order by mois, anne;

-- nb annonce valide
create or replace view v_annonce_mois as 
    select 
    count(*) as nb_annonce,
    EXTRACT(Year FROM date_annonce) as anne,
    EXTRACT(month FROM date_annonce) as mois
    from annonce
        group by date_annonce, mois, anne
        order by mois, anne;

-- revenu mensuel
create or replace view v_revenu_mensuel as 
    select 
    count(*) as nb_commission,
    sum(commission) as total_commission,
    EXTRACT(Year FROM date_commission) as anne,
    EXTRACT(month FROM date_commission) as mois
    from commission
        group by date_commission, mois, anne
        order by mois, anne;    

-- statistique global
-- total annonce / marque
create or replace view v_stat_marque_global as
    select 
    id_marque, marque,
    count(*) as nb_annonce
    from
        v_details_annonce 
        where etat >= 20
        group by id_marque, marque;


-- total annonce / modele
create or replace view v_stat_voiture_global as
    select 
    id_voiture, nom_modele,
    count(*) as nb_annonce
    from
        v_details_annonce 
        where etat >= 20
        group by id_voiture, nom_modele;


-- total annonce / categorie
create or replace view v_stat_categorie_global as
    select 
    id_categorie, categorie,
    count(*) as nb_annonce
    from
        v_details_annonce 
        where etat >= 20
        group by id_categorie, categorie;


