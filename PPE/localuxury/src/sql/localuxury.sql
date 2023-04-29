drop database if exists localuxury;
create database localuxury;
use localuxury;


CREATE TABLE Vehicule (
  idvehicule INT PRIMARY KEY AUTO_INCREMENT,
  marque VARCHAR(255) NOT NULL,
  modele VARCHAR(255) NOT NULL,
  annee VARCHAR(255) NOT NULL,
  caracteristiques VARCHAR(255) NOT NULL,
  prix_journalier VARCHAR(255) NOT NULL,
  caution VARCHAR(255) NOT NULL,
  puissance VARCHAR(255) NOT NULL,
  image VARCHAR(255) NOT NULL,
  nb_places VARCHAR(255) NOT NULL,
  statut VARCHAR(255) NOT NULL
);

INSERT INTO Vehicule (marque, modele, annee, caracteristiques, prix_journalier, caution, puissance, image, nb_places, statut)
VALUES ("Lamborghini", "URUS", '2020', "SUV de luxe à quatre roues motrices", '2500', '30000.00', '650.00', 'path/to/C:/wamp64/www/Site/Vehicule/urus.png', '4', 'disponible'),
       ("Porsche", "Panamera", '2020', "Berline de luxe à quatre portes", '730', '9000', '550', 'path/to/C:/wamp64/www/Site/Vehicule/panamera.png', '4', 'disponible'),
       ("Porsche", "Cayenne S", '2021', "SUV de luxe à quatre roues motrices", '750', '10000', '541', 'path/to/C:/wamp64/www/Site/Vehicule/cayenne.png', '4', 'disponible'),
       ("Audi", "RS6", '2020', "Berline de luxe à quatre portes", '1200', '12000', '592', 'path/to/C:/wamp64/www/Site/Vehicule/rs6.png', '4', 'disponible'),
       ("Bentley", "Continental GT Speed", '2021', "Coupé de luxe à deux portes", '1800', '20000', '660', 'path/to/C:/wamp64/www/Site/Vehicule/continental.png', '4', 'disponible'),
       ("Bugatti", "Chiron", '2020', "Supercar de luxe à deux portes", '38500', '240000', '1500', 'path/to/C:/wamp64/www/Site/Vehicule/chiron.png', '2', 'disponible'),
       ("McLaren", "P1", '2020', "Supercar hybride à deux portes", '2700', '9000', '916', 'path/to/C:/wamp64/www/Site/Vehicule/p1.png', '2', 'disponible'),
       ("Land Rover", "Range Rover Sport", '2020', "SUV de luxe à quatre roues motrices", '700', '7000', '400', 'path/to/C:/wamp64/www/Site/Vehicule/rangerover.png', '5', 'disponible'),
       ("Porsche", "718 Boxster", '2020', "Cabriolet de sport à deux portes", '800', '9000', '300', 'path/to/C:/wamp64/www/Site/Vehicule/718boxster.png', '2', 'disponible'),
       ("Audi", "R8", '2020', "Supercar de luxe à deux portes", '1800', '12000', '420', 'path/to/C:/wamp64/www/Site/Vehicule/r8.png', '2', 'disponible');


CREATE TABLE Client (
  idclient INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(50) NOT NULL,
  prenom VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL,
  mdp varchar(50), 
  role VARCHAR(255) NOT NULL,
  adresse VARCHAR(255) NOT NULL,
  numero_telephone VARCHAR(255) NOT NULL

);

INSERT INTO Client (nom, prenom, email, mdp, role, adresse, numero_telephone)
VALUES ('bentaleb', 'karim', 'karim.bentaleb@example.com', '000', 'user', '1 rue de la Paix', '01 02 03 04 05'),
       ('martin', 'marie', 'marie.martin@example.com', '000', 'user',  '2 avenue des Champs-Elysées', '06 07 08 09 10'),
       ('durand', 'pierre', 'pierre.durand@example.com', '000', 'user',  '3 boulevard de la Villette', '11 12 13 14 15'),
       ('rzekec', 'daniel', 'daniel.rzekec@gmail.com', '000', 'admin',  '4 rue de la Roquette', '06 17 18 19 20'),
       ('selhami', 'wasil', 'wasil.selhami@gmail.com', '000', 'admin',  '4 rue de la Roquette', '06 17 18 19 20'),
       ('william', 'leite', 'william.leite@gmail.com', '000', 'admin',  '4 rue de la Roquette', '06 17 18 19 20'),
       ('noiret', 'david', 'david.noiret@example.com', '000', 'user',  '5 avenue de Clichy', '21 22 23 24 25');




CREATE TABLE Location (
  idlocation INT PRIMARY KEY AUTO_INCREMENT,
  vehicule_id INT NOT NULL,
  client_id INT NOT NULL,
  date_debut VARCHAR(255) NOT NULL,
  date_fin VARCHAR(255) NOT NULL,
  prix_total VARCHAR(255) NOT NULL,
  reduction VARCHAR(255) NOT NULL,
  mode_paiement VARCHAR(255) NOT NULL,
  caution VARCHAR(255) NOT NULL,
  FOREIGN KEY (vehicule_id) REFERENCES Vehicule(idvehicule),
  FOREIGN KEY (client_id) REFERENCES Client(idclient)
);

INSERT INTO Location (vehicule_id, client_id, date_debut, date_fin, prix_total, reduction, mode_paiement, caution)
VALUES (1, 1, '2022-01-01', '2022-01-07', 1200, 0, 'ESPECES', 1000),
       (2, 2, '2022-02-01', '2022-02-07', 1500, 0, 'CARTE_DE_CREDIT', 1000),
       (3, 3, '2022-03-01', '2022-03-07', 1000, 0, 'ESPECES', 1000),
       (4, 4, '2022-04-01', '2022-04-07', 2000, 0, 'CARTE_DE_CREDIT', 1000),
       (5, 5, '2022-05-01', '2022-05-07', 2500, 0, 'CHEQUE', 1000);

UPDATE Location
SET prix_total = (SELECT prix_journalier FROM Vehicule WHERE idvehicule = vehicule_id) * DATEDIFF(date_fin, date_debut);

UPDATE Location l
INNER JOIN Vehicule v ON v.idvehicule = l.vehicule_id
SET l.caution = v.caution;

SELECT Location.idlocation, Location.date_debut, Location.date_fin, (DATEDIFF(Location.date_fin, Location.date_debut) + 1) * Vehicule.prix_journalier AS prix_total
FROM Location
INNER JOIN Vehicule ON Location.vehicule_id = Vehicule.idvehicule;


CREATE TABLE Historique (
  idhistorique INT PRIMARY KEY AUTO_INCREMENT,
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

ALTER TABLE Location
  MODIFY COLUMN date_debut DATETIME NOT NULL,
  MODIFY COLUMN date_fin DATETIME NOT NULL;

ALTER TABLE Location
  MODIFY COLUMN prix_total DECIMAL(10,2) NOT NULL,
  MODIFY COLUMN reduction DECIMAL(10,2);
  
  ALTER TABLE Vehicule
MODIFY statut ENUM('disponible', 'indisponible') NOT NULL,
MODIFY puissance ENUM('5 chevaux', '8 chevaux', '10 chevaux') NOT NULL;


