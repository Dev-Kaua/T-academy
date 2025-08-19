CREATE DATABASE biblioteca_velha;

use biblioteca_velha;

CREATE TABLE autores (
	id INT PRIMARY KEY auto_increment,
    nome VARCHAR(50) NOT NULL,
    nacionalidade VARCHAR(50) NOT NULL
);

CREATE TABLE livros (
	id INT PRIMARY KEY auto_increment,
    titulo VARCHAR (70) NOT NULL ,
    genero VARCHAR (50) NOT NULL,
    autor_id INT,
    
    FOREIGN KEY (autor_id) REFERENCES autores(id)
);

CREATE TABLE clientes (
	id INT PRIMARY KEY auto_increment,
    nome VARCHAR (50) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    cidade VARCHAR (50) NOT NULL
);

CREATE TABLE reservas (
	id INT PRIMARY KEY auto_increment,
    cliente_id INT,
    livro_id INT,
    data_reserva DATE NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);

-- inserts --

-- Inserindo autores
INSERT INTO autores (nome, nacionalidade) VALUES
('Machado de Assis', 'Brasileira'),
('Clarice Lispector', 'Brasileira'),
('George Orwell', 'Britânica'),
('J.K. Rowling', 'Britânica');

-- Inserindo livros
INSERT INTO livros (titulo, genero, autor_id) VALUES
('Dom Casmurro', 'Romance', 1),
('A Hora da Estrela', 'Ficção', 2),
('1984', 'Distopia', 3),
('Harry Potter e a Pedra Filosofal', 'Fantasia', 4);

-- Inserindo clientes
INSERT INTO clientes (nome, endereco, cidade) VALUES
('João Silva', 'Rua das Flores, 123', 'São Paulo'),
('Maria Oliveira', 'Av. Brasil, 456', 'Rio de Janeiro'),
('Pedro Santos', 'Travessa da Paz, 789', 'Belo Horizonte');

-- Inserindo reservas
INSERT INTO reservas (cliente_id, livro_id, data_reserva, data_retirada, data_devolucao) VALUES
(1, 1, '2025-08-01', '2025-08-02', '2025-08-15'),
(2, 3, '2025-08-05', '2025-08-06', '2025-08-20'),
(3, 4, '2025-08-10', '2025-08-11', '2025-08-25'),
(1, 2, '2025-08-12', '2025-08-13', '2025-08-27');

-- exercicios inner join --
-- 1 --
select titulo, autores.nome FROM livros
JOIN autores ON livros.autor_id = autores.id;
-- 2 --
select * FROM clientes
JOIN reservas ON reservas.cliente_id = clientes.id
WHERE cliente_id IS NOT NULL;
-- 3 --
select * FROM reservas
JOIN livros ON reservas.livro_id = livros.id
