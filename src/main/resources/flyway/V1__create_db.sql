CREATE DATABASE space_travel;
USE space_travel;

CREATE TABLE clients (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200)
);

CREATE TABLE planets (
    `id` VARCHAR(10) PRIMARY KEY CHECK (REGEXP_LIKE(id, '^[A-Z0-9]+$')),
    `name` VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500)
);

CREATE TABLE tickets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    client_id BIGINT REFERENCES clients(id),
    from_planet_id VARCHAR(10) NOT NULL REFERENCES planets(id),
    to_planet_id VARCHAR(10) NOT NULL REFERENCES planets(id),
    CONSTRAINT fk_tickets_planets FOREIGN KEY (from_planet_id) REFERENCES planets (id),
    CONSTRAINT fk_tickets_clients FOREIGN KEY (client_id) REFERENCES clients (id),
    CONSTRAINT fk_tickets_planets1 FOREIGN KEY (to_planet_id) REFERENCES planets (id)
);
