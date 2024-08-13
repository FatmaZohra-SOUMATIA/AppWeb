-- Create the Client table
CREATE TABLE Client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL
);

-- Insert sample data into the Client table
INSERT INTO Client (nom, email) VALUES
                                    ('Alice Dupont', 'alice.dupont@example.com'),
                                    ('Bob Martin', 'bob.martin@example.com'),
                                    ('Carla Roberts', 'carla.roberts@example.com');
