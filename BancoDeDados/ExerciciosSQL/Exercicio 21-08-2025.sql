-- Criação das tabelas
CREATE DATABASE LojaOnline;
USE LojaOnline;

CREATE TABLE Categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
);

CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(100),
    estado VARCHAR(50)
);

CREATE TABLE Pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    data_pedido DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE ItensPedido (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_produto INT,
    quantidade INT,
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id_produto)
);

-- Categorias
INSERT INTO Categorias (nome) VALUES
('Eletrônicos'), ('Livros'), ('Roupas'), ('Alimentos');

-- Produtos
INSERT INTO Produtos (nome, preco, id_categoria) VALUES
('Notebook', 3500.00, 1),
('Smartphone', 2500.00, 1),
('Livro SQL', 80.00, 2),
('Livro Java', 90.00, 2),
('Camiseta', 50.00, 3),
('Calça Jeans', 120.00, 3),
('Arroz 5kg', 25.00, 4),
('Feijão 1kg', 10.00, 4);

-- Clientes
INSERT INTO Clientes (nome, cidade, estado) VALUES
('Ana', 'São Paulo', 'SP'),
('Bruno', 'Rio de Janeiro', 'RJ'),
('Carla', 'Belo Horizonte', 'MG'),
('Diego', 'São Paulo', 'SP'),
('Fernanda', 'Curitiba', 'PR');

-- Pedidos
INSERT INTO Pedidos (id_cliente, data_pedido) VALUES
(1, '2025-08-01'),
(2, '2025-08-02'),
(3, '2025-08-03'),
(1, '2025-08-04'),
(4, '2025-08-05');

-- Itens dos pedidos
INSERT INTO ItensPedido (id_pedido, id_produto, quantidade) VALUES
(1, 1, 1), -- Ana comprou 1 Notebook
(1, 3, 2), -- Ana comprou 2 Livros SQL
(2, 2, 1), -- Bruno comprou 1 Smartphone
(2, 5, 3), -- Bruno comprou 3 Camisetas
(3, 7, 2), -- Carla comprou 2 Arroz
(3, 8, 5), -- Carla comprou 5 Feijão
(4, 4, 1), -- Ana comprou 1 Livro Java
(4, 6, 2), -- Ana comprou 2 Calças Jeans
(5, 2, 1), -- Diego comprou 1 Smartphone
(5, 5, 1); -- Diego comprou 1 Camiseta

-- EXERCICIOS --
-- 1 --
select clientes.nome, count(pedidos.id_pedido) as "número de pedidos" FROM pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
group by clientes.nome ;
-- 2 --
select categorias.nome, count(produtos.id_produto) as "quantidades de produtos da categoria" from produtos
join categorias on produtos.id_categoria = categorias.id_categoria
group by categorias.nome;
-- 3 --
select produtos.nome, SUM(itensPedido.quantidade) from itenspedido
join produtos on itenspedido.id_produto = produtos.id_produto
group by produtos.nome;
-- 4 --
select clientes.nome, SUM(produtos.preco * itenspedido.quantidade) from produtos
join itenspedido on itenspedido.id_produto = produtos.id_produto
join pedidos on itenspedido.id_pedido = pedidos.id_pedido
join clientes on pedidos.id_cliente = clientes.id_cliente
group by clientes.nome;
-- 5 --
SELECT Categorias.nome AS categoria, SUM(ItensPedido.quantidade * Produtos.preco) AS faturamento FROM ItensPedido
JOIN Produtos ON ItensPedido.id_produto = Produtos.id_produto
JOIN Categorias ON Produtos.id_categoria = Categorias.id_categoria
GROUP BY Categorias.nome;
-- 6 --
select clientes.cidade, count(pedidos.id_pedido) as "quantidade de pedidos" from pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
group by clientes.cidade;
-- 7 --
select produtos.nome, SUM(itenspedido.quantidade) as Quantidade from itenspedido
join produtos on itenspedido.id_produto = produtos.id_produto
group by produtos.nome
order by Quantidade DESC limit 1;
-- 8 --
select clientes.nome, avg(valor_pedido) from clientes
join (
    SELECT pedidos.id_cliente, pedidos.id_pedido, SUM(produtos.preco * itenspedido.quantidade) AS valor_pedido FROM pedidos
    JOIN itenspedido ON pedidos.id_pedido = itenspedido.id_pedido
    JOIN produtos ON itenspedido.id_produto = produtos.id_produto
    GROUP BY pedidos.id_pedido
) pedidos_valores ON clientes.id_cliente = pedidos_valores.id_cliente
group by clientes.nome;

-- 9 --
select clientes.nome , SUM(itenspedido.quantidade * produtos.preco) as Valor_total_gasto from itenspedido
join produtos on itenspedido.id_produto = produtos.id_produto
join pedidos on itenspedido.id_pedido = pedidos.id_pedido
join clientes on pedidos.id_cliente = clientes.id_cliente
group by clientes.nome
order by Valor_total_gasto desc limit 1;
-- 10 --



Fáceis
	1.	Mostrar quantos pedidos cada cliente fez.
	2.	Mostrar quantos produtos existem em cada categoria.
	3.	Mostrar a soma das quantidades vendidas de cada produto.

Médios
	4.	Mostrar o total gasto por cada cliente em todos os pedidos.
	5.	Mostrar o faturamento total por categoria.
	6.	Mostrar a quantidade de pedidos feitos em cada cidade.

Difíceis
	7.	Mostrar o produto mais vendido (em quantidade).
	8.	Mostrar a média de valor dos pedidos de cada cliente.
	9.	Mostrar o cliente que mais gastou em toda a loja.

Desafiador (nível alto 🚀)
	10.	Mostrar o faturamento mensal por categoria, agrupando por mês/ano e categoria (mesmo que o banco 
    ainda tenha dados de apenas um mês, a query deve ser genérica para vários).

Last: Faturamento mensal por categoria
Liste o faturamento total por categoria, agrupado por mês e ano.