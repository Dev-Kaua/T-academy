CREATE DATABASE LojaMagica;
USE LojaMagica;

-- Tabela Cliente
CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefone VARCHAR(20)
);

-- Tabela Endereco (1 Cliente -> N Endereços)
CREATE TABLE Endereco (
    id_endereco INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    rua VARCHAR(150) NOT NULL,
    numero VARCHAR(10),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(20),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabela Categoria (1 Categoria -> N Produtos)
CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

-- Tabela ProdutosMagicos
CREATE TABLE ProdutosMagicos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT DEFAULT 0,
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);

-- Tabela Pedido (1 Cliente -> N Pedidos)
CREATE TABLE Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) DEFAULT 'Pendente',
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabela associativa Pedido_Produto (N:M)
CREATE TABLE Pedido_Produto (
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT DEFAULT 1,
    preco_unitario DECIMAL(10,2),
    PRIMARY KEY (id_pedido, id_produto),
    FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES ProdutosMagicos(id_produto)
);

-- INSERTS --

-- Inserindo clientes
INSERT INTO Cliente (nome, email, telefone)
VALUES 
('Harry Potter', 'harry@hogwarts.com', '99999-1111'),
('Hermione Granger', 'hermione@hogwarts.com', '99999-2222'),
('Rony Weasley', 'rony@hogwarts.com', '99999-3333'),
('Pedro balistieri', 'balista@gmail.com', '99384-1234');

-- Inserindo endereços (1 cliente pode ter vários endereços)
INSERT INTO Endereco (id_cliente, rua, numero, cidade, estado, cep)
VALUES
(1, 'Rua dos Alfeneiros', '4', 'Londres', 'Inglaterra', '12345-000'),
(2, 'Travessa do Tranco', '77', 'Londres', 'Inglaterra', '12345-111'),
(3, 'A Toca', '67', 'Ottery St Catchpole', 'Devon', '12345-222'),
(4, 'rua franchesco', '34', 'Guaramirealm', 'santa cruz', '84023-78');

-- Inserindo categorias
INSERT INTO Categoria (nome, descricao)
VALUES
('Poções', 'Poções mágicas diversas'),
('Varinhas', 'Varinhas mágicas feitas sob medida'),
('Artefatos', 'Artefatos mágicos raros e poderosos'),
('ingrediente', 'itens para colocar em coisas'),
('arma','artefatos para autodefesa');

-- Inserindo produtos mágicos
INSERT INTO ProdutosMagicos (id_categoria, nome, descricao, preco, estoque)
VALUES
(1, 'Poção Polissuco', 'Permite assumir a forma de outra pessoa.', 250.00, 10),
(1, 'Poção Felix Felicis', 'Dá sorte temporária.', 500.00, 5),
(2, 'Varinha de Azevinho', 'Varinha do Harry.', 1500.00, 1),
(2, 'Varinha de Videira', 'Varinha da Hermione.', 1400.00, 2),
(3, 'Capa da Invisibilidade', 'Torna o usuário invisível.', 3000.00, 1),
(4, 'Pó de Flu', 'Permite viajar entre lareiras mágicas.', 120.00, 50),
(4, 'Asa de Morcego', 'Ingrediente raro para poções.', 75.00, 100),
(5, 'Espada de Prata', 'Arma afiada encantada contra criaturas mágicas.', 2000.00, 3),
(5, 'Adaga Enfeitiçada', 'Adaga leve com encantos de proteção.', 800.00, 5),
(3, 'Orbe da Visão', 'Permite ver acontecimentos distantes, mas consome muita energia mágica.', 2200.00, 2);


-- Inserindo pedidos (ligados a clientes)
INSERT INTO Pedido (id_cliente, status)
VALUES
(1, 'Concluído'),
(2, 'Pendente'),
(3, 'Concluído'),
(4, 'Concluído'),
(4, 'Pendente');

-- Ligando pedidos a produtos (N:M)
INSERT INTO Pedido_Produto (id_pedido, id_produto, quantidade, preco_unitario)
VALUES
(1, 1, 2, 250.00), -- Harry comprou 2 Poções Polissuco
(1, 3, 1, 1500.00), -- Harry comprou 1 Varinha de Azevinho
(2, 2, 1, 500.00), -- Hermione pediu 1 Felix Felicis
(2, 4, 1, 1400.00), -- Hermione pediu 1 Varinha de Videira
(3, 5, 1, 3000.00), -- Rony comprou 1 Capa da Invisibilidade
(4, 6, 3, 120.00), -- Pedro comprou 3 Pó de Flu
(4, 8, 1, 800.00), -- Pedro comprou 1 Adaga Enfeitiçada
(5, 7, 1, 2000.00), -- Pedro pediu 1 Espada de Prata
(5, 2, 2, 500.00); -- Pedro pediu 2 Felix Felicis

-- SELECTS / JOINS -> exercicios --
-- 1 --
select * from pedido
join cliente on pedido.id_cliente = cliente.id_cliente
join endereco on endereco.id_cliente = cliente.id_cliente
where endereco.cidade like '%Guaramirealm%';
-- 2 --
select * from produtosmagicos
join categoria on produtosmagicos.id_categoria = categoria.id_categoria;
-- 3 --
select * from produtosmagicos
ORDER BY preco DESC
LIMIT 1;
-- 4 --
select categoria.nome AS categoria, count(produtosmagicos.id_produto) AS total_produtos FROM categoria
JOIN produtosmagicos ON categoria.id_categoria = produtosmagicos.id_categoria
GROUP BY categoria.id_categoria, categoria.nome;
-- 5 --
select cliente.nome from pedido
join cliente on pedido.id_cliente = cliente.id_cliente
join pedido_produto on pedido_produto.id_pedido = pedido.id_pedido
join produtosmagicos on pedido_produto.id_produto = produtosmagicos.id_produto
join categoria on produtosmagicos.id_categoria = categoria.id_categoria
where categoria.nome = 'arma';
-- 6 --
select distinct cliente.nome, endereco.rua from cliente
join endereco on endereco.id_cliente = cliente.id_cliente
join pedido on pedido.id_cliente = cliente.id_cliente
join pedido_produto on pedido_produto.id_pedido = pedido.id_pedido
where pedido_produto.preco_unitario > 100;
-- 7 --
select * from pedido
join pedido_produto on pedido_produto.id_pedido = pedido.id_pedido
join produtosmagicos on  pedido_produto.id_produto = produtosmagicos.id_produto
join categoria on produtosmagicos.id_categoria = categoria.id_categoria
where categoria.nome = 'ingrediente';
-- 8 --
select * from produtosmagicos
left join pedido_produto on pedido_produto.id_produto = produtosmagicos.id_produto
where pedido_produto.id_produto is null;

-- 9 --
select pedido.*, produtosmagicos.nome AS nome_do_produto, categoria.nome AS categoria from pedido
join pedido_produto on pedido_produto.id_pedido = pedido.id_pedido
join produtosmagicos on pedido_produto.id_produto = produtosmagicos.id_produto
join categoria on produtosmagicos.id_categoria = categoria.id_categoria;