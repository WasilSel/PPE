drop database if exists localuxury;
create database localuxury;
use localuxury;

CREATE TABLE Vehicule (
  id INT PRIMARY KEY AUTO_INCREMENT,
  marque VARCHAR(255) NOT NULL,
  modèle VARCHAR(255) NOT NULL,
  année INT NOT NULL,
  caractéristiques TEXT
);


INSERT INTO Vehicule (marque, modèle, année, caractéristiques)
VALUES ("Lamborghini", "URUS", 2020, "SUV de luxe à quatre roues motrices"),
       ("Porsche", "Panamera", 2020, "Berline de luxe à quatre portes"),
       ("Porsche", "Cayenne S", 2021, "SUV de luxe à quatre roues motrices"),
       ("Audi", "RS6", 2020, "Berline de luxe à quatre portes"),
       ("Bentley", "Continental GT Speed", 2021, "Coupé de luxe à deux portes"),
       ("Bugatti", "Chiron", 2020, "Supercar de luxe à deux portes"),
       ("McLaren", "P1", 2020, "Supercar hybride à deux portes"),
       ("Land Rover", "Range Rover Sport", 2020, "SUV de luxe à quatre roues motrices"),
       ("Porsche", "718 Boxster", 2020, "Cabriolet de sport à deux portes"),
       ("Audi", "R8", 2020, "Supercar de luxe à deux portes");


ALTER TABLE Vehicule ADD prix_journalier DECIMAL(10, 2) NOT NULL;
ALTER TABLE Vehicule ADD caution DECIMAL(10, 2) NOT NULL;
ALTER TABLE Vehicule ADD puissance DECIMAL(10, 2) NOT NULL;
ALTER TABLE Vehicule ADD image VARCHAR(255);



UPDATE Vehicule
SET prix_journalier = 2500
WHERE marque = 'Lamborghini' AND modèle = 'URUS';

UPDATE Vehicule
SET prix_journalier = 730
WHERE marque = 'Porsche' AND modèle = 'Panamera';

UPDATE Vehicule
SET prix_journalier = 750
WHERE marque = 'Porsche' AND modèle = 'Cayenne S';

UPDATE Vehicule
SET prix_journalier = 1200
WHERE marque = 'Audi' AND modèle = 'RS6';

UPDATE Vehicule
SET prix_journalier = 1800
WHERE marque = 'Bentley' AND modèle = 'Continental GT Speed';

UPDATE Vehicule
SET prix_journalier = 38500
WHERE marque = 'Bugatti' AND modèle = 'Chiron';

UPDATE Vehicule
SET prix_journalier = 27000
WHERE marque = 'McLaren' AND modèle = 'P1';

UPDATE Vehicule
SET prix_journalier = 700
WHERE marque = 'Land Rover' AND modèle = 'Range Rover Sport';

UPDATE Vehicule
SET prix_journalier = 800
WHERE marque = 'Porsche' AND modèle = '718 Boxster';

UPDATE Vehicule
SET prix_journalier = 1800
WHERE marque = 'Audi' AND modèle = 'R8';

ALTER TABLE Vehicule ADD caution INT;

UPDATE Vehicule
SET caution = 12000
WHERE marque = 'Audi' AND modèle = 'R8';

UPDATE Vehicule
SET caution = 30000
WHERE marque = 'Lamborghini' AND modèle = 'URUS';

UPDATE Vehicule
SET caution = 9000
WHERE marque = 'Porsche' AND modèle = 'Panamera';

UPDATE Vehicule
SET caution = 10000
WHERE marque = 'Porsche' AND modèle = 'Cayenne S';

UPDATE Vehicule
SET caution = 12000
WHERE marque = 'Audi' AND modèle = 'RS6';

UPDATE Vehicule
SET caution = 20000
WHERE marque = 'Bentley' AND modèle = 'Continental GT Speed';

UPDATE Vehicule
SET caution = 240000
WHERE marque = 'Bugatti' AND modèle = 'Chiron';

UPDATE Vehicule
SET caution = 7000
WHERE marque = 'Land Rover' AND modèle = 'Range Rover Sport';

UPDATE Vehicule
SET caution = 9000
WHERE marque = 'Porsche' AND modèle = '718 Boxster';

UPDATE Vehicule
SET caution = 9000
WHERE marque = 'McLaren' AND modèle = 'P1';

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/urus.png' WHERE id = 1;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/panamera.png' WHERE id = 2;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/cayenne.png' WHERE id = 3;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/rs6.png' WHERE id = 4;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/continental.png' WHERE id = 5;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/chiron.png' WHERE id = 6;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/p1.png' WHERE id = 7;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/rangerover.png' WHERE id = 8;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/718boxster.png' WHERE id = 9;

UPDATE Vehicule SET image = 'path/to/C:/wamp64/www/Site/Vehicule/r8.png' WHERE id = 10;




CREATE TABLE Client (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(255) NOT NULL,
  adresse VARCHAR(255) NOT NULL,
  numero_telephone VARCHAR(255) NOT NULL
);

ALTER TABLE Client ADD ville VARCHAR(255) NOT NULL;
ALTER TABLE Client ADD code_postal VARCHAR(255) NOT NULL;

INSERT INTO Client (nom, adresse, ville, code_postal, numero_telephone)
VALUES ('Karim Bentaleb', '1 rue de la Paix', 'Paris', '75000', '01 02 03 04 05'),
       ('Marie Martin', '2 avenue des Champs-Elysées', 'Paris', '75000', '06 07 08 09 10'),
       ('Pierre Durand', '3 boulevard de la Villette', 'Paris', '75010', '11 12 13 14 15'),
       ('Julie Blanc', '4 rue de la Roquette', 'Paris', '75011', '16 17 18 19 20'),
       ('David Noiret', '5 avenue de Clichy', 'Paris', '75017', '21 22 23 24 25');

CREATE TABLE Location (
  id INT PRIMARY KEY AUTO_INCREMENT,
  vehicule_id INT NOT NULL,
  client_id INT NOT NULL,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  prix_total DECIMAL(10, 2) NOT NULL,
  reduction DECIMAL(10, 2) DEFAULT 0,
  mode_paiement ENUM('ESPECES', 'CARTE_DE_CREDIT', 'CHEQUE') NOT NULL,
  caution DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (vehicule_id) REFERENCES Vehicule(id),
  FOREIGN KEY (client_id) REFERENCES Client(id)
);

INSERT INTO Location (vehicule_id, client_id, date_debut, date_fin, prix_total, reduction, mode_paiement, caution)
VALUES (1, 1, '2022-01-01', '2022-01-07', 1200, 0, 'ESPECES', 1000),
       (2, 2, '2022-02-01', '2022-02-07', 1500, 0, 'CARTE_DE_CREDIT', 1000),
       (3, 3, '2022-03-01', '2022-03-07', 1000, 0, 'ESPECES', 1000),
       (4, 4, '2022-04-01', '2022-04-07', 2000, 0, 'CARTE_DE_CREDIT', 1000),
       (5, 5, '2022-05-01', '2022-05-07', 2500, 0, 'CHEQUE', 1000);


UPDATE Location
SET prix_total = (SELECT prix_journalier FROM Vehicule WHERE id = vehicule_id) * DATEDIFF(date_fin, date_debut);

UPDATE Location l
INNER JOIN Vehicule v ON v.id = l.vehicule_id
SET l.caution = v.caution;

SELECT location.id, location.date_debut, location.date_fin, (DATEDIFF(location.date_fin, location.date_debut) + 1) * Vehicule.prix_journalier AS prix_total
FROM location
INNER JOIN Vehicule ON location.id_vehicule = Vehicule.id;


UPDATE Vehicule
SET puissance = 650
WHERE marque = 'Lamborghini' AND modèle = 'URUS';

UPDATE Vehicule
SET puissance = 650
WHERE marque = 'Lamborghini' AND modèle = 'URUS';

UPDATE Vehicule
SET puissance = 550
WHERE marque = 'Porsche' AND modèle = 'Panamera';

UPDATE Vehicule
SET puissance = 541
WHERE marque = 'Porsche' AND modèle = 'Cayenne S';

UPDATE Vehicule
SET puissance = 592
WHERE marque = 'Audi' AND modèle = 'RS6';

UPDATE Vehicule
SET puissance = 660
WHERE marque = 'Bentley' AND modèle = 'Continental GT Speed';

UPDATE Vehicule
SET puissance = 1500
WHERE marque = 'Bugatti' AND modèle = 'Chiron';

UPDATE Vehicule
SET puissance = 916
WHERE marque = 'McLaren' AND modèle = 'P1';

UPDATE Vehicule
SET puissance = 400
WHERE marque = 'Land Rover' AND modèle = 'Range Rover Sport';

UPDATE Vehicule
SET puissance = 300
WHERE marque = 'Porsche' AND modèle = '718 Boxster';

UPDATE Vehicule
SET puissance = 420
WHERE marque = 'Audi' AND modèle = 'R8';

ALTER TABLE Vehicule
ADD nb_places INT;

UPDATE Vehicule
SET nb_places = 4
WHERE marque = 'Lamborghini' AND modèle = 'URUS';

UPDATE Vehicule
SET nb_places = 4
WHERE marque = 'Porsche' AND modèle = 'Panamera';

UPDATE Vehicule
SET nb_places = 4
WHERE marque = 'Porsche' AND modèle = 'Cayenne S';

UPDATE Vehicule
SET nb_places = 4
WHERE marque = 'Audi' AND modèle = 'RS6';

UPDATE Vehicule
SET nb_places = 4
WHERE marque = 'Bentley' AND modèle = 'Continental GT Speed';

UPDATE Vehicule
SET nb_places = 2
WHERE marque = 'Bugatti' AND modèle = 'Chiron';

UPDATE Vehicule
SET nb_places = 2
WHERE marque = 'McLaren' AND modèle = 'P1';

UPDATE Vehicule
SET nb_places = 5
WHERE marque = 'Land Rover' AND modèle = 'Range Rover Sport';

UPDATE Vehicule
SET nb_places = 2
WHERE marque = 'Porsche' AND modèle = '718 Boxster';

UPDATE Vehicule
SET nb_places = 2
WHERE marque = 'Audi' AND modèle = 'R8';

ALTER TABLE Vehicule
ADD statut ENUM('DISPONIBLE', 'INDISPONIBLE') NOT NULL DEFAULT 'DISPONIBLE';

CREATE TABLE Historique (
  id INT PRIMARY KEY AUTO_INCREMENT,
  vehicule_id INT NOT NULL,
  client_id INT NOT NULL,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  prix_total DECIMAL(10, 2) NOT NULL,
  reduction DECIMAL(10, 2) NOT NULL,
  mode_paiement ENUM('ESPECES', 'CARTE_DE_CREDIT', 'CHEQUE') NOT NULL,
  caution DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (vehicule_id) REFERENCES Vehicule(id),
  FOREIGN KEY (client_id) REFERENCES Client(id)
);

INSERT INTO Historique (vehicule_id, client_id, date_debut, date_fin, prix_total, reduction, mode_paiement, caution)
SELECT l.vehicule_id, l.client_id, l.date_debut, l.date_fin, l.prix_total, l.reduction, l.mode_paiement, l.caution
FROM Location l;

ALTER TABLE Client
  MODIFY COLUMN nom VARCHAR(50) NOT NULL;

ALTER TABLE Location
  MODIFY COLUMN date_debut DATETIME NOT NULL,
  MODIFY COLUMN date_fin DATETIME NOT NULL;

ALTER TABLE Location
  MODIFY COLUMN prix_total DECIMAL(10,2) NOT NULL,
  MODIFY COLUMN reduction DECIMAL(10,2);

create table user (
	iduser int(3) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(50), 
	mdp varchar(50), 
	role enum("admin", "user"),
	primary key(iduser)
);

insert into user values 
(null, "daniel", "Rzekec", "daniel.rzekec@mediaschool.me", "123", "admin"),
(null, "wasil", "Selhami", "wasil.selhami@mediaschool.me", "456", "user"), 
(null, "william", "leite", "william.faria-leite@mediaschool.me", "890", "user"); 



 