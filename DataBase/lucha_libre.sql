-- ============================================================
-- Sistema de Gestión de Lucha Libre
-- Base de datos: lucha_libre
-- Motor: MySQL 8.0+
--
-- Instalación:
-- 1. Abre este archivo en MySQL Workbench.
-- 2. Ejecuta el script completo en una instancia de prueba.
--
-- Nota:
-- Este script está pensado para una base de datos nueva.
-- INSERT IGNORE evita errores por IDs ya existentes, pero no actualiza
-- registros previos. Revisa los datos antes de usarlo en producción.
-- ============================================================

CREATE DATABASE IF NOT EXISTS lucha_libre
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE lucha_libre;

-- ------------------------------------------------------------
-- Tabla: empresas
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS empresas (
  id_empresa INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  pais VARCHAR(45) DEFAULT NULL,
  presidente VARCHAR(45) DEFAULT NULL,
  eventos VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (id_empresa)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

-- ------------------------------------------------------------
-- Tabla: luchadores
-- ------------------------------------------------------------
CREATE TABLE IF NOT EXISTS luchadores (
  id_luchador INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  paisOrigen VARCHAR(45) DEFAULT NULL,
  peso DECIMAL(5,2) DEFAULT NULL,
  altura_cm DECIMAL(5,2) DEFAULT NULL,
  tipoDeLuchador VARCHAR(45) DEFAULT NULL,
  id_empresa INT DEFAULT NULL,
  PRIMARY KEY (id_luchador),
  KEY idx_luchadores_id_empresa (id_empresa),
  CONSTRAINT fk_luchadores_empresa
    FOREIGN KEY (id_empresa)
    REFERENCES empresas (id_empresa)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

-- ------------------------------------------------------------
-- Datos de ejemplo: empresas
-- ------------------------------------------------------------
INSERT IGNORE INTO empresas
  (id_empresa, nombre, pais, presidente, eventos)
VALUES
  (1, 'WWE', 'US', 'Adam Pearce', 'Raw'),
  (2, 'WWE', 'US', 'Nick Aldis', 'SmackDown'),
  (3, 'AAA', 'México', 'Rey Misterio', 'Carabana Estelar'),
  (4, 'WWE', 'US', 'Shown Michaels', 'NXT'),
  (5, 'CMLL', 'México', 'Salvador Lutteroth Lomelí', 'CMLL'),
  (6, 'AEW', 'US', 'Maicol Gordan', 'Summer Slam');

-- ------------------------------------------------------------
-- Datos de ejemplo: luchadores
-- ------------------------------------------------------------
INSERT IGNORE INTO luchadores
  (id_luchador, nombre, paisOrigen, peso, altura_cm, tipoDeLuchador, id_empresa)
VALUES
  (1, 'Hijo del Vikingo', 'México', 70.00, 167.00, 'Aereo', 3),
  (2, 'Physco', 'México', 99.00, 185.00, 'Técnico', 3),
  (3, 'Mr Iguana', 'México', 176.00, 176.00, 'Comico', 3),
  (4, 'La Parka', 'México', 90.00, 190.00, 'Aereo', 3),
  (5, 'Rey Misterio', 'Estados Unidos', 79.00, 168.00, 'Aereo', 2),
  (6, 'Randy orton', 'Estados Unidos', 113.00, 196.00, 'Tecnico', 2),
  (7, 'Cody Rhodes', 'Estados Unidos', 100.00, 188.00, 'Tecnico', 2),
  (8, 'Bianca Belair', 'Estados Unidos', 75.00, 170.00, 'Atletico', 2),
  (9, 'Dominik misterio', 'Estados Unidos', 98.00, 188.00, 'Rudo', 1),
  (10, 'Seth Rollins', 'Estados Unidos', 102.00, 185.00, 'Tecnico', 1),
  (11, 'Bron Breaker', 'Estados Unidos', 104.00, 183.00, 'Fuerza', 1),
  (14, 'Místico', 'México', 170.00, 170.00, 'Técnico', 5),
  (15, 'Roman Reigns', 'Estados Unidos', 120.00, 191.00, 'Tecnico', 1),
  (16, 'CM Punk', 'Estados Unidos', 99.00, 185.00, 'Tecnico', 1),
  (17, 'Drew McIntyre', 'Escocia', 125.00, 196.00, 'Rudo', 1),
  (18, 'Jey Uso', 'Estados Unidos', 110.00, 188.00, 'Tecnico', 1),
  (19, 'Gunther', 'Austria', 130.00, 193.00, 'Rudo', 1),
  (20, 'Sami Zayn', 'Canada', 96.00, 185.00, 'Tecnico', 1),
  (21, 'Finn Balor', 'Irlanda', 86.00, 180.00, 'Rudo', 1),
  (22, 'Sheamus', 'Irlanda', 121.00, 191.00, 'Tecnico', 1),
  (23, 'Cody Rhodes', 'Estados Unidos', 100.00, 188.00, 'Tecnico', 2),
  (24, 'Randy Orton', 'Estados Unidos', 113.00, 196.00, 'Tecnico', 2),
  (25, 'LA Knight', 'Estados Unidos', 105.00, 185.00, 'Tecnico', 2),
  (26, 'Kevin Owens', 'Canada', 120.00, 183.00, 'Tecnico', 2),
  (27, 'AJ Styles', 'Estados Unidos', 99.00, 180.00, 'Tecnico', 2),
  (28, 'Shinsuke Nakamura', 'Japon', 104.00, 188.00, 'Rudo', 2),
  (29, 'Solo Sikoa', 'Estados Unidos', 113.00, 185.00, 'Rudo', 2),
  (30, 'Andrade', 'Mexico', 95.00, 175.00, 'Tecnico', 2),
  (31, 'Hijo del Vikingo', 'Mexico', 70.00, 167.00, 'Aereo', 3),
  (32, 'Psycho Clown', 'Mexico', 99.00, 185.00, 'Tecnico', 3),
  (34, 'La Parka', 'Mexico', 90.00, 190.00, 'Aereo', 3),
  (35, 'Dr Wagner Jr', 'Mexico', 110.00, 178.00, 'Rudo', 3),
  (36, 'Pagano', 'Mexico', 95.00, 180.00, 'Rudo', 3),
  (37, 'El Zorro', 'Mexico', 90.00, 178.00, 'Tecnico', 3),
  (38, 'Chessman', 'Mexico', 105.00, 185.00, 'Rudo', 3),
  (39, 'Oba Femi', 'Nigeria', 140.00, 198.00, 'Rudo', 4),
  (40, 'Trick Williams', 'Estados Unidos', 107.00, 188.00, 'Tecnico', 4),
  (41, 'Ethan Page', 'Canada', 98.00, 183.00, 'Rudo', 4),
  (42, 'Tony D Angelo', 'Estados Unidos', 110.00, 185.00, 'Rudo', 4),
  (43, 'Wes Lee', 'Estados Unidos', 79.00, 173.00, 'Aereo', 4),
  (44, 'Nathan Frazer', 'Inglaterra', 75.00, 178.00, 'Aereo', 4),
  (45, 'Joe Hendry', 'Escocia', 105.00, 185.00, 'Tecnico', 4),
  (46, 'Lexis King', 'Estados Unidos', 95.00, 183.00, 'Rudo', 4),
  (47, 'Mistico', 'Mexico', 75.00, 170.00, 'Aereo', 5),
  (48, 'Atlantis', 'Mexico', 90.00, 175.00, 'Tecnico', 5),
  (49, 'Ultimo Guerrero', 'Mexico', 95.00, 178.00, 'Rudo', 5),
  (50, 'Volador Jr', 'Mexico', 78.00, 175.00, 'Aereo', 5),
  (51, 'Hechicero', 'Mexico', 90.00, 180.00, 'Tecnico', 5),
  (52, 'Soberano Jr', 'Mexico', 80.00, 178.00, 'Aereo', 5),
  (53, 'Euforia', 'Mexico', 110.00, 185.00, 'Rudo', 5),
  (54, 'Angel de Oro', 'Mexico', 85.00, 175.00, 'Tecnico', 5),
  (55, 'Bobby Lashley', 'Estados Unidos', 125.00, 191.00, 'Fuerza', 1),
  (56, 'Braun Strowman', 'Estados Unidos', 175.00, 203.00, 'Fuerza', 1),
  (57, 'Kofi Kingston', 'Ghana', 96.00, 183.00, 'Aereo', 1),
  (58, 'Xavier Woods', 'Estados Unidos', 93.00, 180.00, 'Tecnico', 1),
  (59, 'The Miz', 'Estados Unidos', 100.00, 188.00, 'Rudo', 1),
  (60, 'Rey Mysterio', 'Mexico', 79.00, 168.00, 'Aereo', 1),
  (61, 'Shayna Baszler', 'Estados Unidos', 62.00, 170.00, 'Tecnico', 1),
  (62, 'Rhea Ripley', 'Australia', 75.00, 170.00, 'Fuerza', 1),
  (63, 'Becky Lynch', 'Irlanda', 61.00, 168.00, 'Tecnico', 1),
  (64, 'Liv Morgan', 'Estados Unidos', 57.00, 163.00, 'Tecnico', 1),
  (65, 'Braun Strowman', 'Estados Unidos', 175.00, 203.00, 'Fuerza', 2),
  (66, 'Brock Lesnar', 'Estados Unidos', 130.00, 191.00, 'Fuerza', 2),
  (67, 'Ricochet', 'Estados Unidos', 85.00, 175.00, 'Aereo', 2),
  (68, 'Baron Corbin', 'Estados Unidos', 120.00, 196.00, 'Rudo', 2),
  (69, 'Rey Fenix', 'Mexico', 80.00, 178.00, 'Aereo', 2),
  (70, 'Santos Escobar', 'Mexico', 90.00, 180.00, 'Rudo', 2),
  (71, 'Zelina Vega', 'Estados Unidos', 48.00, 155.00, 'Tecnico', 2),
  (72, 'Charlotte Flair', 'Estados Unidos', 73.00, 178.00, 'Rudo', 2),
  (73, 'Asuka', 'Japon', 62.00, 160.00, 'Tecnico', 2),
  (74, 'Bayley', 'Estados Unidos', 54.00, 168.00, 'Tecnico', 2),
  (75, 'Blue Demon Jr', 'Mexico', 95.00, 178.00, 'Tecnico', 3),
  (76, 'El Mesias', 'Puerto Rico', 110.00, 185.00, 'Rudo', 3),
  (77, 'Averno', 'Mexico', 90.00, 175.00, 'Rudo', 3),
  (78, 'Cibernetico', 'Mexico', 120.00, 190.00, 'Rudo', 3),
  (79, 'Abismo Negro', 'Mexico', 100.00, 180.00, 'Rudo', 3),
  (80, 'Faby Apache', 'Mexico', 60.00, 165.00, 'Tecnico', 3),
  (81, 'Lady Shani', 'Mexico', 55.00, 160.00, 'Tecnico', 3),
  (82, 'Laredo Kid', 'Mexico', 75.00, 170.00, 'Aereo', 3),
  (83, 'Octagon', 'Mexico', 80.00, 170.00, 'Aereo', 3),
  (84, 'Taurus', 'Mexico', 110.00, 180.00, 'Fuerza', 3),
  (85, 'Bron Breakker', 'Estados Unidos', 100.00, 183.00, 'Fuerza', 4),
  (86, 'Carmelo Hayes', 'Estados Unidos', 95.00, 178.00, 'Tecnico', 4),
  (87, 'Ilja Dragunov', 'Rusia', 95.00, 178.00, 'Tecnico', 4),
  (88, 'Roxanne Perez', 'Estados Unidos', 50.00, 155.00, 'Tecnico', 4),
  (89, 'Cora Jade', 'Estados Unidos', 55.00, 163.00, 'Rudo', 4),
  (90, 'Lola Vice', 'Estados Unidos', 57.00, 160.00, 'Tecnico', 4),
  (91, 'Dijak', 'Estados Unidos', 120.00, 201.00, 'Fuerza', 4),
  (92, 'Grayson Waller', 'Australia', 95.00, 183.00, 'Rudo', 4),
  (93, 'Axiom', 'España', 75.00, 175.00, 'Aereo', 4),
  (94, 'Duke Hudson', 'Australia', 110.00, 193.00, 'Fuerza', 4),
  (95, 'Blue Panther', 'Mexico', 85.00, 170.00, 'Tecnico', 5),
  (96, 'Dragon Rojo Jr', 'Mexico', 85.00, 175.00, 'Rudo', 5),
  (97, 'Fuego', 'Mexico', 75.00, 170.00, 'Aereo', 5),
  (98, 'Rey Bucanero', 'Mexico', 95.00, 178.00, 'Rudo', 5),
  (99, 'Triton', 'Mexico', 80.00, 175.00, 'Aereo', 5),
  (100, 'Stuka Jr', 'Mexico', 90.00, 175.00, 'Tecnico', 5),
  (101, 'Magnus', 'Mexico', 85.00, 175.00, 'Tecnico', 5),
  (102, 'Guerrero Maya Jr', 'Mexico', 80.00, 170.00, 'Tecnico', 5),
  (103, 'Dark Magic', 'Estados Unidos', 95.00, 180.00, 'Rudo', 5),
  (104, 'Star Jr', 'Mexico', 75.00, 168.00, 'Aereo', 5),
  (105, 'El Carnicero', 'US', 190.00, 190.00, 'Rudo', 3),
  (106, 'Mono De Alambre', 'México', 60.00, 162.00, 'Cominco', 3);

-- Fin del script.
