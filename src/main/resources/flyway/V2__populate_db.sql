INSERT INTO clients (name) VALUES
    ('John Doe'),
    ('Alice Smith'),
    ('Bob Johnson'),
    ('Eva Brown'),
    ('Mike Wilson'),
    ('Olivia Davis'),
    ('Daniel White'),
    ('Sophia Taylor'),
    ('William Miller'),
    ('Emma Anderson');

INSERT INTO planets (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn'),
    ('NEP', 'Neptune');

INSERT INTO tickets (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'MARS', 'VEN'),
    (2, 'VEN', 'JUP'),
    (3, 'JUP', 'SAT'),
    (4, 'SAT', 'NEP'),
    (5, 'MARS', 'NEP'),
    (6, 'JUP', 'VEN'),
    (7, 'SAT', 'MARS'),
    (8, 'NEP', 'JUP'),
    (9, 'VEN', 'SAT'),
    (10, 'MARS', 'JUP');
