-- mdp admin user1 user2
insert into users (nom, prenom, mail, mdp, role) values
('admin','admin','admin@gmail.com','$2a$10$Slmxr5FM5k6eWRlOMGxXtu0CYLq0a80pCfJd6FtXbmsg7wWo/ZuDC','ROLE_ADMIN'),
('user1', 'user1' , 'user1@gmail.com'  , '$2a$10$7IYPF.5OV5yuKR8.wTtUw.M3nWFLcPvco8CEU6xxZFTMmtKxnUN3e', 'ROLE_USER'),
('user2', 'user2' , 'user2@gmail.com'  , '$2a$10$5n1/Fx9GBa4oAETCft5PBOYg4h467Mh5dDHw6mF1d530bzQzdGrH6', 'ROLE_USER');

insert into categorie (categorie) values 
('Sport'),
('4x4'),
('Pick-up'),
('SUV'),
('Crossover'),
('Berline'),
('Break'),
('Cabriolet'),
('Coupé'),
('Monospace'),
('Bus et minibus'),
('Fourgon'),
('Camion');

insert into marque (marque) values
('Peugeot'),
('Renault'),
('Audi'),
('VolksWagen'),
('Bmw'),
('Mercedes'),
('Chevrolet'),
('Citroen'),
('Dacia'),
('Honda'),
('Hyundai'),
('Jeep'),
('Land Rover'),
('Mazda'),
('Nissan'),
('Toyota'),
('Mitsubishi'),
('Ford'),
('Dodge');

insert into energie (energie) values
('Diesel'),
('Essence'),
('Electrique');

insert into boite (boite) values
('Manuelle'),
('Automatique'),
('Séquentielle');

--  param commision
insert into param_commission(marge_commission) values
(10);

-- Voitures
insert into voiture (nom_modele, anne_sortie, id_marque) values
('205', 1983, 'MA1'),
('206', 1998, 'MA1'),
('306', 1993, 'MA1'),
('308', 2007, 'MA1'),
('R5', 1972, 'MA2'),
('Duster', 2009, 'MA2'),
('A5', 2007, 'MA3'),
('A3', 1996, 'MA3'),
('RS5', 2010, 'MA3'),
('MK1', 1974, 'MA4'),
('MK2', 1983, 'MA4'),
('MK3', 1991, 'MA4'),
('E36', 1990, 'MA5'),
('E46', 1998, 'MA5'),
('E30', 1982, 'MA5'),
('Sprinter', 1995, 'MA6'),
('ClasseA', 1997, 'MA6');

-- categories possible pour 205 exemple sport et coupé
insert into voiture_categorie (id_voiture, id_categorie) values
('V1', 'CATEG1'),
('V1', 'CATEG9');

-- exemple de 205 essence boite manuelle GTI 1.6l 7.5/100km 8CV 5 vitesses 5 places 5 portes 3.70m longueur et 1200 kg
-- exemple de 205 diesel boite manuelle GTD 1.8l 7.5/100km 10CV 5 vitesses 5 places 5 portes 3.70m longueur et 1200 kg
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V1',  'EN2',  'B1',  'GTI',  1.6,  7.5,   8,  5,  5,  5,  3.70, 1200),
('V1',  'EN1',  'B1',  'GTD',  1.8,  7.5,  10,  5,  5,  5,  3.70, 1200);

-- Catégories pour 206 (exemple avec "Coupé", "Compacte" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V2', 'CATEG9'),
('V2', 'CATEG6'),
('V2', 'CATEG1');

-- Fiches techniques pour 206 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V2', 'EN2', 'B1', 'GTI', 1.6, 7.0, 10, 5, 5, 3, 3.80, 1100),
('V2', 'EN1', 'B1', 'GTD', 1.9, 6.5, 8, 5, 5, 3, 3.80, 1100);

-- Catégories pour 306 (exemple avec "Berline", "Compacte" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V3', 'CATEG6'),
('V3', 'CATEG4'),
('V3', 'CATEG1');

-- Fiches techniques pour 306 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V3', 'EN2', 'B1', 'XR', 1.6, 7.2, 7, 5, 5, 5, 4.20, 1100),
('V3', 'EN1', 'B2', 'HDI', 2.0, 6.0, 9, 5, 5, 5, 4.20, 1200);

-- Catégories pour 308 (exemple avec "Berline" et "Compacte")
insert into voiture_categorie (id_voiture, id_categorie) values
('V4', 'CATEG6'),
('V4', 'CATEG4');

-- Fiches techniques pour 308 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V4', 'EN2', 'B1', 'VTi', 1.6, 6.5, 11, 6, 5, 5, 4.25, 1200),
('V4', 'EN1', 'B2', 'HDI', 1.6, 5.0, 10, 6, 5, 5, 4.25, 1250);

-- Catégories pour R5 (exemple avec "Compacte" et "Coupé")
insert into voiture_categorie (id_voiture, id_categorie) values
('V5', 'CATEG6'),
('V5', 'CATEG9');

-- Fiches techniques pour R5 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V5', 'EN2', 'B1', 'GT Turbo', 1.4, 8.0, 12, 5, 3, 3, 3.50, 900),
('V5', 'EN1', 'B2', 'M Diesel', 1.6, 5.5, 11, 4, 5, 3, 3.50, 1000);

-- Catégories pour Duster (exemple avec "SUV" et "4x4")
insert into voiture_categorie (id_voiture, id_categorie) values
('V6', 'CATEG4'),
('V6', 'CATEG2');

-- Fiches techniques pour Duster (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V6', 'EN2', 'B1', 'dCi', 1.5, 6.0, 9, 6, 5, 5, 4.30, 1200),
('V6', 'EN1', 'B2', 'TCe', 1.2, 7.0, 10, 6, 5, 5, 4.30, 1300);


-- Catégories pour A5 (exemple avec "Coupé" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V7', 'CATEG9'),
('V7', 'CATEG1');

-- Fiches techniques pour A5 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V7', 'EN2', 'B1', 'TDI', 3.0, 6.5, 12, 7, 4, 2, 4.70, 1600),
('V7', 'EN1', 'B2', 'TFSI', 2.0, 8.0, 12, 7, 4, 2, 4.70, 1500);

-- Catégories pour A3 (exemple avec "Compacte" et "Berline")
insert into voiture_categorie (id_voiture, id_categorie) values
('V8', 'CATEG6'),
('V8', 'CATEG7');

-- Fiches techniques pour A3 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V8', 'EN2', 'B1', 'TDI', 1.6, 5.0, 4, 6, 5, 5, 4.20, 1200),
('V8', 'EN1', 'B2', 'TFSI', 2.0, 7.5, 5, 6, 5, 5, 4.30, 1300);

-- Catégories pour RS5 (exemple avec "Coupé" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V9', 'CATEG9'),
('V9', 'CATEG1');

-- Fiches techniques pour RS5 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V9', 'EN2', 'B1', 'TFSI', 4.2, 11.0, 14, 7, 4, 2, 4.70, 1700),
('V9', 'EN1', 'B2', 'TDI', 3.0, 8.5, 13, 7, 4, 2, 4.70, 1600);

-- Catégories pour MK1 (exemple avec "Compacte" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V10', 'CATEG6'),
('V10', 'CATEG1');

-- Fiches techniques pour MK1 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V10', 'EN2', 'B1', 'GTI', 2.0, 7.0, 12, 5, 5, 3, 4.00, 1200),
('V10', 'EN1', 'B1', 'TDI', 2.5, 6.0, 10, 6, 5, 3, 4.00, 1300);

-- Catégories pour MK2 (exemple avec "Compacte" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V11', 'CATEG6'),
('V11', 'CATEG1');

-- Fiches techniques pour MK2 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V11', 'EN2', 'B1', 'GTI', 2.0, 7.5, 12, 5, 5, 3, 4.10, 1250),
('V11', 'EN1', 'B1', 'TDI', 2.5, 6.5, 10, 6, 5, 3, 4.10, 1300);

-- Catégories pour MK3 (exemple avec "Compacte" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V12', 'CATEG6'),
('V12', 'CATEG1');

-- Fiches techniques pour MK3 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V12', 'EN2', 'B1', 'GTI', 2.0, 7.0, 12, 6, 5, 3, 4.20, 1200),
('V12', 'EN1', 'B1', 'TDI', 2.5, 6.0, 10, 6, 5, 3, 4.20, 1300);

-- Catégories pour E36 (exemple avec "Coupé" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V13', 'CATEG9'),
('V13', 'CATEG1');

-- Fiches techniques pour E36 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V13', 'EN2', 'B1', 'M3', 3.0, 8.5, 18, 5, 4, 2, 4.20, 1200),
('V13', 'EN1', 'B2', '325i', 2.5, 7.0, 14, 5, 4, 2, 4.20, 1300);

-- Catégories pour E46 (exemple avec "Coupé" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V14', 'CATEG9'),
('V14', 'CATEG1');

-- Fiches techniques pour E46 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V14', 'EN2', 'B1', 'M3', 3.2, 9.0, 34, 6, 4, 2, 4.45, 1570),
('V14', 'EN1', 'B2', '330i', 3.0, 8.5, 23, 6, 4, 2, 4.45, 1500);

-- Catégories pour E30 (exemple avec "Compacte" et "Sport")
insert into voiture_categorie (id_voiture, id_categorie) values
('V15', 'CATEG6'),
('V15', 'CATEG1');

-- Fiches techniques pour E30 (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V15', 'EN2', 'B1', 'M3', 2.3, 9.0, 18, 5, 4, 2, 4.35, 1200),
('V15', 'EN1', 'B2', '325i', 2.5, 8.0, 15, 5, 4, 2, 4.35, 1250);

-- Catégories pour Sprinter (exemple avec "Fourgon" et "Minibus")
insert into voiture_categorie (id_voiture, id_categorie) values
('V16', 'CATEG12'),
('V16', 'CATEG11');

-- Fiches techniques pour Sprinter (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V16', 'EN1', 'B1', '306 CDI', 2.1, 8.0, 10, 6, 9, 4, 5.30, 2000),
('V16', 'EN1', 'B2', '312 D', 2.9, 7.5, 12, 5, 6, 3, 5.50, 2200);

-- Catégories pour Classe A (exemple avec "Compacte" et "Citadine")
insert into voiture_categorie (id_voiture, id_categorie) values
('V17', 'CATEG6'),
('V17', 'CATEG3');

-- Fiches techniques pour Classe A (exemples)
insert into fiche_technique (id_voiture, id_energie, id_boite, moteur, litre_moteur, consommation, puissance, nb_vitesse, nb_place, nb_porte, longueur, poids) values
('V17', 'EN2', 'B1', 'A 180d', 1.5, 4.0, 5, 7, 5, 5, 4.30, 1400),
('V17', 'EN1', 'B2', 'A 200', 2.0, 6.5, 8, 7, 5, 5, 4.30, 1500);


-- annonce
insert into annonce(id_users, id_voiture, id_fiche_technique, id_categorie, kilometrage, etat_voiture, prix_vente) values
('U2', 'V11', 'FT21', 'CATEG1', 17800,   8, 400000000 ),
('U3',  'V1',  'FT1', 'CATEG9', 22000, 8.5, 500000000 );






