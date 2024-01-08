CREATE TABLE commande
(
    id           IDENTITY,
    commande_description  VARCHAR(255) NOT NULL,
    quantite     INT NOT NULL,
    commande_date DATE NOT NULL,
    montant      NUMERIC NOT NULL,
    id_product   INT NOT NULL
);