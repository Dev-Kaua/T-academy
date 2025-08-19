-- Criar o banco de dados (opcional)
CREATE DATABASE IF NOT EXISTS clinica_veterinaria;
USE clinica_veterinaria;

-- 1. Tabela de espécies
CREATE TABLE especie (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL UNIQUE
);

-- 2. Tabela de donos
CREATE TABLE dono (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  telefone VARCHAR(20),
  email VARCHAR(100),
  endereco TEXT
);

-- 3. Tabela de animais
CREATE TABLE animal (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  especie_id INT NOT NULL,
  dono_id INT NOT NULL,
  idade INT,
  peso DECIMAL(5,2),
  altura DECIMAL(5,2),
  observacoes TEXT,
  FOREIGN KEY (especie_id) REFERENCES especie(id),
  FOREIGN KEY (dono_id) REFERENCES dono(id)
);

-- 4. Tabela de consultas
CREATE TABLE consulta (
  id INT AUTO_INCREMENT PRIMARY KEY,
  animal_id INT NOT NULL,
  data_consulta DATE NOT NULL,
  peso_ultimo DECIMAL(5,2),
  observacoes TEXT,
  FOREIGN KEY (animal_id) REFERENCES animal(id)
);

INSERT INTO especie (nome) VALUES 
  ('Cão'),
  ('Gato'),
  ('Pássaro'),
  ('Cobra'),
  ('Iguana'),
  ('Coruja'),
  ('Furão'),
  ('Raposa'),
  ('Chinchila'),
  ('Porquinho-da-índia'),
  ('Peixe'),
  ('Polvo'),
  ('Hamster'),
  ('Corvo');

INSERT INTO dono (nome, telefone, email, endereco) VALUES
  ('João Silva', '11999998888', 'joao@email.com', 'Sítio Boa Esperança'),
  ('Maria Lopes', '21988887777', 'maria@email.com', 'Rua das Palmeiras, 32'),
  ('Carlos Neto', '31997776666', 'carlos@email.com', 'Estrada da Serra, km 7'),
  ('Fernanda Souza', '41996665555', 'fernanda@email.com', 'Fazenda Rio Claro'),
  ('Dr. Estranho', '11912345678', 'estranho@email.com', 'Sanctum Sanctorum, NY');

-- Exemplo com nomes criativos
INSERT INTO animal (nome, especie_id, dono_id, idade, peso, altura, observacoes) VALUES
  ('Rex', 1, 1, 5, 25.0, NULL, 'Latido rouco, tratado com antibiótico.'),
  ('Mittens', 2, 2, 3, 4.5, NULL, 'Perda de apetite; exames solicitados.'),
  ('Cthulhu', 12, 3, 3, 75.0, 1.60, 'Ficava encarando o vazio. Já está morto.'),
  ('Salém', 2, 1, 13, 5.0, NULL, 'Parece ronronar para o vazio.'),
  ('Beelzebark', 1, 4, 6, 2.1, NULL, 'Ansioso, late para espelhos.'),
  ('Glitch', 7, 3, 3, 1.0, NULL, 'Foi encontrado no freezer. Família nega.'),
  ('Balthazar', 14, 5, 9, 1.1, 0.50, 'Aprendeu a gritar "socorro". Veterinário assustado.'),
  ('Soraka', 2, 2, 6, 3.8, NULL, 'Problema nos olhos. Usando colírio.'),
  ('Aloy', 8, 4, 4, 8.2, NULL, 'Vocaliza à noite. Provável cio.'),
  ('Drizzt', 4, 1, 3, 7.1, NULL, 'Muda completa. Animal saudável.');

INSERT INTO consulta (animal_id, data_consulta, peso_ultimo, observacoes) VALUES
  (1, '2025-06-01', 25.0, 'Consulta de rotina.'),
  (2, '2025-07-15', 4.4, 'Febre baixa detectada.'),
  (3, '2025-08-01', 75.0, 'Morto. Encerrado cadastro.'),
  (4, '2025-07-05', 5.0, 'Comportamento estranho, exames normais.'),
  (5, '2025-07-28', 2.1, 'Alta ansiedade, prescrito calmante.'),
  (6, '2025-08-01', 1.0, 'Congelado acidentalmente. Está bem agora.'),
  (7, '2025-07-20', 1.1, 'Falando palavras humanas. Acompanhamento iniciado.'),
  (8, '2025-07-28', 3.8, 'Olhos vermelhos.'),
  (9, '2025-07-10', 8.2, 'Consulta noturna, sem anormalidades.'),
  (10, '2019-06-15', 7.1, 'Atendido entre maio-julho de 2019.');
  
-- MINHA PARTE DO CODIGO --

select * FROM consulta
JOIN animal on consulta.animal_id = animal.id
where animal.peso > 10;

select animal.nome, especie.nome FROM animal
JOIN especie ON animal.especie_id = especie.id
WHERE especie.nome = 'gato';

select animal.nome, animal.peso FROM animal
JOIN dono ON animal.dono_id =  dono.id
WHERE dono.email LIKE '%gmail%';