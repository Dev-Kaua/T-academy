create database ExercicioAnimais;
use ExercicioAnimais;

CREATE TABLE especies(
	id INT PRIMARY KEY auto_increment,
    nomeDaEspecie varchar(50) NOT NULL
);

CREATE TABLE animal(
	id INT PRIMARY KEY auto_increment,
    idade INT NOT NULL,
    nome varchar(50) NOT NULL,
    raca varchar(50) NOT NULL,
    peso_id DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
	descricao TEXT,
    especie_id INT ,
    
    FOREIGN KEY (especie_id) REFERENCES especies(id)
);


CREATE TABLE consultas(
	id INT PRIMARY KEY auto_increment,
    dataDaConsulta DATE NOT NULL,
    animal_id INT NOT NULL,
    Observacoes varchar(255),
    
    FOREIGN KEY (animal_id) REFERENCES animal(id)
);

 -- ----- INSERTS -------
INSERT INTO especies
VALUES (null, 'pássaros'), (null, 'cão'), (null, 'gato'), (null, 'cobra'), (null, 'ramster') , (null, 'lagarto');


INSERT INTO animal
VALUES (null, 8, 'Joguibos', 'tucano-aribapuera', 9.32, 0.35, 'tucano negro de asas brancas', 1),
(null, 3, 'Rex', 'pitbull', 21.3 , 0.60, 'cão pitbull raivoso saudável', 2),
(null, 11, 'Mittens', 'Persa', 10.8, 0.25, 'gato bonito', 3),
(null, 1, 'petter', 'Sphynx', 3.2, 0.20, null, 3),
(null, 3, 'miura', 'Sphynx', 8.8, 0.22, 'gato femea', 3),
(null, 26, 'Dinossauro', 'lobster', 11.3, 0.50, 'lagarto com idade avançada', 6),
(null, 19, 'anaconda', 'coral', 3.4, 1.80, 'cobra coral perigosa', 4),
(null, 6, 'fitschi', 'ramster-listrado', 0.8, 0.15, null, 5);

INSERT INTO consultas (dataDaConsulta, animal_id, Observacoes) VALUES
('2025-01-15', 1, 'Check-up geral, tudo ok'),
('2025-02-20', 2, 'Vacinação anti-rábica aplicada'),
('2025-03-10', 3, 'Tratamento para alergia na pele'),
('2025-03-12', 4, 'Consulta de rotina, saúde boa'),
('2025-04-05', 5, 'Exame de sangue normal'),
('2025-05-22', 6, 'Observação para problemas respiratórios'),
('2025-06-18', 7, 'Consulta para controle de peso'),
('2025-07-01', 8, 'Vacinação contra gripe aplicada');

-- inserindo a altura nos animais --


UPDATE animal SET altura = 0.35 WHERE id = 1;
UPDATE animal SET altura = 0.60 WHERE id = 2;
UPDATE animal SET altura = 0.25 WHERE id = 3;
UPDATE animal SET altura = 0.20 WHERE id = 4;
UPDATE animal SET altura = 0.22 WHERE id = 5;
UPDATE animal SET altura = 0.50 WHERE id = 6;
UPDATE animal SET altura = 1.80 WHERE id = 7;
UPDATE animal SET altura = 0.15 WHERE id = 8;

  -- ----- SELECTS --------
 
Select * FROM animal;

-- 1 --

Select * FROM animal
WHERE especie_id = 1;

-- 2 --

select idade FROM animal
WHERE nome = 'Rex';

-- 3 --

SELECT AVG(idade) FROM animal 
WHERE especie_id = 2;

-- 4 --
SELECT 