--Supression des tables================================================================
-- Suppression de la table LigneCommande (dépend de Commande et Produit)
DROP TABLE IF EXISTS LigneCommande;

-- Suppression de la table ProduitTraduction (dépend de Produit)
DROP TABLE IF EXISTS ProduitTraduction;

-- Suppression de la table Commande (dépend de Client)
DROP TABLE IF EXISTS Commande;

-- Suppression de la table Message (dépend de Client)
DROP TABLE IF EXISTS Message;

-- Suppression de la table Produit (indépendante après suppression de ProduitTraduction et LigneCommande)
DROP TABLE IF EXISTS Produit;

-- Suppression de la table Client (indépendante après suppression de Commande et Message)
DROP TABLE IF EXISTS Client;


--Creation des tables==============================================================================================
-- Création de la table Client
CREATE TABLE Client (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL UNIQUE
);

-- Création de la table Commande
CREATE TABLE Commande (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          date DATE NOT NULL,
                          IdClient INT,
                          FOREIGN KEY (IdClient) REFERENCES Client(id)
);

-- Création de la table Produit
CREATE TABLE Produit (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         prix DOUBLE NOT NULL,
                         quantiteDisponible INT NOT NULL
);

-- Création de la table ProduitTraduction
CREATE TABLE ProduitTraduction (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   produit_id INT NOT NULL,
                                   langue VARCHAR(2) NOT NULL, -- Code de langue, par exemple 'fr' pour français, 'en' pour anglais
                                   nom VARCHAR(255) NOT NULL,
                                   description TEXT,
                                   UNIQUE (produit_id, langue), -- Assure qu'il n'y a qu'une traduction par langue pour un produit
                                   FOREIGN KEY (produit_id) REFERENCES Produit(id) ON DELETE CASCADE
);


-- Création de la table LigneCommande
CREATE TABLE LigneCommande (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               IdCommande INT,
                               IdProduit INT NOT NULL,
                               quantite INT NOT NULL,
                               prix DOUBLE NOT NULL,
                               FOREIGN KEY (IdCommande) REFERENCES Commande(id),
                               FOREIGN KEY (IdProduit) REFERENCES Produit(id)
);

-- Création de la table Message
CREATE TABLE Message (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         IdClient INT NOT NULL,
                         contenu TEXT NOT NULL,
                         date DATE NOT NULL,
                         FOREIGN KEY (IdClient) REFERENCES Client(id)
);

--Donnees================================================================================
-- Insertion des données génériques dans la table Produit
INSERT INTO Produit (prix, quantiteDisponible) VALUES
                                                   (0.50, 100),  -- Pomme
                                                   (2.00, 50),   -- Bluey (Myrtille)
                                                   (1.50, 70),   -- Fraise
                                                   (0.80, 150),  -- Tomate
                                                   (5.00, 20),   -- Citrouille
                                                   (1.00, 200);  -- Laitue

-- Insertion des traductions en français dans la table ProduitTraduction
INSERT INTO ProduitTraduction (produit_id, langue, nom, description) VALUES
                                                                         (1, 'fr', 'Pomme', 'Délicieuse pomme rouge'),
                                                                         (2, 'fr', 'Myrtille', 'Myrtille fraîche et juteuse'),
                                                                         (3, 'fr', 'Fraise', 'Fraise douce et mûre'),
                                                                         (4, 'fr', 'Tomate', 'Tomate biologique'),
                                                                         (5, 'fr', 'Citrouille', 'Citrouille fraîche pour Halloween'),
                                                                         (6, 'fr', 'Laitue', 'Laitue verte croquante');

-- Insertion des traductions en anglais dans la table ProduitTraduction
INSERT INTO ProduitTraduction (produit_id, langue, nom, description) VALUES
                                                                         (1, 'en', 'Apple', 'Delicious red apple'),
                                                                         (2, 'en', 'Blueberry', 'Fresh and juicy blueberry'),
                                                                         (3, 'en', 'Strawberry', 'Sweet and ripe strawberry'),
                                                                         (4, 'en', 'Tomato', 'Organic tomato'),
                                                                         (5, 'en', 'Pumpkin', 'Fresh pumpkin for Halloween'),
                                                                         (6, 'en', 'Lettuce', 'Crispy green lettuce');


INSERT INTO Client (nom, email) VALUES
                                    ('Alice Dupont', 'alice@example.com'),
                                    ('Bob Martin', 'bob@example.com');

INSERT INTO Commande (date, IdClient) VALUES
                                          ('2024-08-15', 1),
                                          ('2024-08-16', 2);

INSERT INTO LigneCommande (IdCommande, IdProduit, quantite, prix) VALUES
                                                                      (1, 1, 10, 0.50),  -- 10 pommes
                                                                      (1, 4, 5, 0.80),   -- 5 tomates
                                                                      (2, 3, 8, 1.50);   -- 8 fraises

INSERT INTO Message (IdClient, contenu, date) VALUES
                                                  (1, 'Merci pour la commande !', '2024-08-15'),
                                                  (2, 'Les produits sont excellents !', '2024-08-16');
