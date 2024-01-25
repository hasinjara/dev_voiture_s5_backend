create sequence seq_users increment by 1 minvalue 1;
create table users (
   id_users varchar default 'U'||nextval('seq_users'),
   nom varchar,
   prenom varchar,
   mail varchar,
   mdp varchar,
   role varchar not null,
   date_inscription date default now()::date,
   primary key (id_users)
);


create sequence seq_categorie increment by 1 minvalue 1;
CREATE TABLE categorie(
   id_categorie varchar default 'CATEG'||nextval('seq_categorie'),
   categorie varchar not null,
   PRIMARY KEY(id_categorie)
);

create sequence seq_marque increment by 1 minvalue 1;
CREATE TABLE marque(
   id_marque varchar default 'MA'||nextval('seq_marque'),
   marque varchar not null,
   PRIMARY KEY(id_marque)
);

create sequence seq_energie increment by 1 minvalue 1;
CREATE TABLE energie(
   id_energie varchar default 'EN'||nextval('seq_energie'),
   energie varchar not null,
   PRIMARY KEY(id_energie)
);


create sequence seq_boite increment by 1 minvalue 1;
CREATE TABLE boite(
   id_boite varchar default 'B'||nextval('seq_boite'),
   boite varchar not null,
   PRIMARY KEY(id_boite)
);

create sequence seq_voiture increment by 1 minvalue 1;
CREATE TABLE voiture(
   id_voiture varchar default 'V'||nextval('seq_voiture'),
   nom_modele varchar not null,
   anne_sortie INTEGER NOT NULL,
   id_marque varchar not null,
   foreign key(id_marque) references marque(id_marque) ON DELETE CASCADE,
   PRIMARY KEY (id_voiture)
);

create sequence seq_voiture_categorie increment by 1 minvalue 1;
CREATE TABLE voiture_categorie(
   id_voiture_categorie varchar default 'VC'||nextval('seq_voiture_categorie'),
   id_voiture varchar not null,
   id_categorie varchar not null,
   foreign key (id_voiture) references voiture(id_voiture),
   foreign key (id_categorie) references categorie(id_categorie),
   PRIMARY KEY (id_voiture_categorie)
);

create sequence seq_fiche_technique increment by 1 minvalue 1;
CREATE TABLE fiche_technique(
   id_fiche_technique varchar default 'FT'||nextval('seq_fiche_technique'),
   id_voiture varchar not null,
   id_energie varchar not null,
   id_boite varchar not null,
   moteur varchar,
   litre_moteur double precision,
   consommation double precision,
   puissance double precision,
   nb_vitesse double precision,
   nb_place double precision,
   nb_porte double precision,
   longueur double precision,
   poids double precision,
   foreign key (id_voiture) references voiture(id_voiture),
   foreign key (id_energie) references energie(id_energie),
   foreign key (id_boite) references boite(id_boite),
   PRIMARY KEY (id_fiche_technique)
);


-- etat 0 cree, 10, refuse, 20 valide, 30 vendu
create sequence seq_annonce increment by 1 minvalue 1;
CREATE TABLE annonce(
   id_annonce varchar default 'AN'||nextval('seq_annonce'),
   id_users varchar not null,
   id_voiture varchar not null,
   id_fiche_technique varchar not null,
   id_categorie varchar not null,
   kilometrage double precision,
   etat_voiture double precision,
   description text,
   prix_vente double precision,
   date_annonce date default now()::date,
   etat integer default 0,
   foreign key (id_users) references users(id_users),
   foreign key (id_voiture) references voiture(id_voiture),
   foreign key (id_fiche_technique) references fiche_technique(id_fiche_technique), 
   foreign key (id_categorie) references categorie(id_categorie),
   PRIMARY KEY (id_annonce)
);

create sequence seq_annonce_photo increment by 1 minvalue 1;
create table annonce_photo (
   id_annonce_photo varchar default 'URL'||nextval('seq_annonce_photo'),
   id_annonce varchar not null,
   url_photo text not null,
   foreign key (id_annonce) references annonce(id_annonce),
   primary key (id_annonce_photo)
);


CREATE TABLE param_commission(
   marge_commission double precision
);

create sequence seq_commission increment by 1 minvalue 1;
CREATE TABLE commission(
   id_commission varchar default 'CM'||nextval('seq_commission'),
   id_annonce varchar not null,
   marge double precision,
   prix_vente double precision,
   commission double precision,
   date_commission date default now()::date,
   foreign key (id_annonce) references annonce(id_annonce),
   PRIMARY KEY(id_commission)
);

create sequence seq_favoris_user_annonce increment by 1 minvalue 1;
CREATE TABLE favoris_user_annonce(
   id_favoris_user_annonce varchar default 'FUA'||nextval('seq_favoris_user_annonce'),
   id_annonce varchar not null,
   id_users varchar not null,
   foreign key (id_annonce) references annonce(id_annonce),
   foreign key (id_users) references users(id_users),
   PRIMARY KEY(id_favoris_user_annonce)
);


