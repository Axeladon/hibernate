INSERT INTO Client (name) VALUES ('Alice Johnson');
INSERT INTO Client (name) VALUES ('Brandon Martinez');
INSERT INTO Client (name) VALUES ('Samantha Lee');
INSERT INTO Client (name) VALUES ('Kevin Wilson');
INSERT INTO Client (name) VALUES ('Jessica Taylor');
INSERT INTO Client (name) VALUES ('Christopher Nguyen');
INSERT INTO Client (name) VALUES ('Sarah Brown');
INSERT INTO Client (name) VALUES ('Daniel Garcia');
INSERT INTO Client (name) VALUES ('Emily Rodriguez');
INSERT INTO Client (name) VALUES ('Matthew Thompson');

INSERT INTO Planet (id, name) VALUES ('A1', 'Mercury');
INSERT INTO Planet (id, name) VALUES ('B2', 'Venus');
INSERT INTO Planet (id, name) VALUES ('C3', 'Earth');
INSERT INTO Planet (id, name) VALUES ('D4', 'Mars');
INSERT INTO Planet (id, name) VALUES ('E5', 'Jupiter');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (1, 'A1', 'B2');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (2, 'B2', 'C3');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (3, 'C3', 'D4');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (4, 'D4', 'E5');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (5, 'E5', 'A1');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (1, 'A1', 'C3');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (2, 'B2', 'D4');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (3, 'C3', 'E5');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (4, 'D4', 'A1');
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES (5, 'E5', 'B2');