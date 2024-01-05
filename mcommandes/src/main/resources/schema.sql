CREATE TABLE commande
(
    id           INT PRIMARY KEY,
    description  VARCHAR(255) NOT NULL,
    quantite     INT NOT NULL,
    commande_date DATE NOT NULL,
    montant      NUMERIC NOT NULL
);