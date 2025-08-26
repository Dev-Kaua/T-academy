
-- Banco de dados
CREATE DATABASE IF NOT EXISTS FabricaCarros;
USE FabricaCarros;

-- Tabela Fabricante
CREATE TABLE Fabricante (
    id_fabricante INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    pais VARCHAR(50),
    ano_fundacao INT
);

INSERT INTO Fabricante (nome, pais, ano_fundacao) VALUES
('AutoLux', 'Alemanha', 1980),
('CarMaster', 'Brasil', 1995),
('SpeedTech', 'EUA', 2005);

-- Tabela Carro
CREATE TABLE Carro (
    id_carro INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50),
    ano INT,
    cor VARCHAR(30),
    preco DECIMAL(10,2),
    id_fabricante INT,
    quantidade_estoque INT,
    FOREIGN KEY (id_fabricante) REFERENCES Fabricante(id_fabricante)
);

INSERT INTO Carro (modelo, ano, cor, preco, id_fabricante, quantidade_estoque) VALUES
('Lux A1', 2023, 'Preto', 120000.00, 1, 15),
('Lux B2', 2022, 'Branco', 95000.00, 1, 8),
('Master X', 2023, 'Prata', 80000.00, 2, 20),
('Speed Z', 2024, 'Vermelho', 150000.00, 3, 5);

-- Tabela Funcionario
CREATE TABLE Funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cargo VARCHAR(50),
    salario DECIMAL(10,2),
    data_admissao DATE
);

INSERT INTO Funcionario (nome, cargo, salario, data_admissao) VALUES
('João Silva', 'Operador', 3000.00, '2020-03-15'),
('Maria Souza', 'Engenheira', 8000.00, '2019-07-10'),
('Carlos Lima', 'Operador', 3200.00, '2021-05-01');

-- Tabela Venda
CREATE TABLE Venda (
    id_venda INT AUTO_INCREMENT PRIMARY KEY,
    id_carro INT,
    cliente_nome VARCHAR(100),
    cliente_cpf VARCHAR(20),
    data_venda DATE,
    quantidade INT,
    valor_total DECIMAL(10,2),
    FOREIGN KEY (id_carro) REFERENCES Carro(id_carro)
);

INSERT INTO Venda (id_carro, cliente_nome, cliente_cpf, data_venda, quantidade, valor_total) VALUES
(1, 'Lucas Pereira', '123.456.789-00', '2025-08-01', 1, 120000.00),
(3, 'Ana Costa', '987.654.321-00', '2025-08-02', 2, 160000.00);

-- Tabela Producao
CREATE TABLE Producao (
    id_producao INT AUTO_INCREMENT PRIMARY KEY,
    id_carro INT,
    id_funcionario INT,
    data_producao DATE,
    quantidade INT,
    FOREIGN KEY (id_carro) REFERENCES Carro(id_carro),
    FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id_funcionario)
);

INSERT INTO Producao (id_carro, id_funcionario, data_producao, quantidade) VALUES
(1, 1, '2025-08-01', 5),
(2, 3, '2025-08-01', 3),
(3, 2, '2025-08-02', 4);

-- EXERCICIOS --
-- 1 --
CREATE VIEW vw_carros_estoque10 AS
SELECT * FROM CARRO
WHERE quantidade_estoque > 10;

SELECT * FROM vw_carros_estoque10;

-- 2 --
CREATE VIEW vw_total_vendas_por_carro AS
SELECT carro.modelo AS modelo_carro, fabricante.nome AS nome_fabricante, SUM(venda.quantidade) AS total_vendido FROM venda
JOIN carro ON venda.id_carro = carro.id_carro
JOIN fabricante ON carro.id_fabricante = fabricante.id_fabricante
GROUP BY carro.modelo, fabricante.nome;

SELECT * FROM vw_total_vendas_por_carro;

-- 3 --
DELIMITER //

CREATE FUNCTION fn_valor_medio_venda(p_id_carro INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE media DECIMAL(10,2);
    SELECT AVG(v.valor_total / v.quantidade)
    INTO media
    FROM venda v
    JOIN carro c ON v.id_carro = c.id_carro
    WHERE v.id_carro = p_id_carro;

    RETURN media;
END;
//
DELIMITER ;

SELECT fn_valor_medio_venda(1);

-- 4 --
DELIMITER //
CREATE FUNCTION fn_funcionario_carros_produzidos(p_id_funcionario INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE total INT;
    SELECT SUM(producao.quantidade) INTO total FROM producao
    JOIN funcionario ON producao.id_funcionario = funcionario.id_funcionario
    WHERE producao.id_funcionario = p_id_funcionario;
    
    RETURN total;
END;
//
DELIMITER ;

SELECT fn_funcionario_carros_produzidos(1);

-- 5 --
DELIMITER //
CREATE PROCEDURE sp_nova_venda(
IN p_id_carro INT, 
IN p_cliente_nome VARCHAR(100),
IN p_cliente_cpf VARCHAR(20),
IN p_data_venda DATE,
IN p_quantidade INT)
BEGIN
	DECLARE v_preco_unitario DECIMAL(10,2);
    DECLARE v_estoque_atual INT;
    
    SELECT preco INTO v_preco_unitario FROM carro
    WHERE id_carro = p_id_carro;
    
    SELECT quantidade_estoque INTO v_estoque_atual FROM carro
    WHERE id_carro = p_id_carro;
    
    IF v_estoque_atual >= p_quantidade THEN
		INSERT INTO venda (id_carro,cliente_nome, cliente_cpf, data_venda, quantidade, valor_total)
        VALUES(p_id_carro, p_cliente_nome, p_cliente_cpf, p_data_venda, p_quantidade, v_preco_unitario * p_quantidade);
    ELSE
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Estoque insuficiente para finalizar a venda.';
    END IF;
END; 
//
DELIMITER ;

CALL sp_nova_venda(1, 'Pedro Oliveira', '111.222.333-44', '2025-08-26', 2);