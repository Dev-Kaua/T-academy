-- CREATE TABLES --
CREATE DATABASE CyberLeagueDB;

USE CyberLeagueDB;

-- Tabela de Regiões Geográficas
CREATE TABLE Regiao (
    regiao_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Tabela de Países
CREATE TABLE Pais (
    pais_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    continente VARCHAR(50),
    regiao_id INT,
    FOREIGN KEY (regiao_id) REFERENCES Regiao(regiao_id)
);


-- Tabela de Empresas (Desenvolvedoras, Organizações de E-sports, etc.)
CREATE TABLE Empresa (
    empresa_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    apelido VARCHAR(50),
    ano_fundacao INT,
    ativo BOOLEAN DEFAULT TRUE,
    pais_id INT NOT NULL, -- Corresponde a ||--|{
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id)
);

-- Tabela de Jogos
CREATE TABLE Jogo (
    jogo_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    empresa_id INT NOT NULL, -- Corresponde a ||--|{
    FOREIGN KEY (empresa_id) REFERENCES Empresa(empresa_id)
);

-- Tabela de Temporadas Competitivas
CREATE TABLE Temporada (
    temporada_id INT AUTO_INCREMENT PRIMARY KEY,
    ano INT NOT NULL,
    nome VARCHAR(100)
);

-- Tabela de Torneios
CREATE TABLE Torneio (
    torneio_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    data_inicio DATE,
    data_termino DATE,
    premio_total DECIMAL(15, 2),
    jogo_id INT NOT NULL, -- Corresponde a ||--|{
    temporada_id INT, -- Permite NULL, correspondendo a }o--o{
    FOREIGN KEY (jogo_id) REFERENCES Jogo(jogo_id),
    FOREIGN KEY (temporada_id) REFERENCES Temporada(temporada_id)
);

-- Tabela de Ligas Regionais
CREATE TABLE Liga (
    liga_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    codigo VARCHAR(20),
    nivel INT DEFAULT 1,
    jogo_id INT NOT NULL, -- Corresponde a ||--|{
    regiao_id INT, -- Permite NULL, correspondendo a }o--o{
    FOREIGN KEY (jogo_id) REFERENCES Jogo(jogo_id),
    FOREIGN KEY (regiao_id) REFERENCES Regiao(regiao_id)
);

-- Tabela de Equipes
CREATE TABLE Equipe (
    equipe_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    tag VARCHAR(10) NOT NULL UNIQUE,
    data_fundacao DATE,
    empresa_id INT NOT NULL, -- ALTERADO! Corresponde a ||--|{ no diagrama
    regiao_id INT, -- Permite NULL, correspondendo a }o--o{
    pais_id INT,
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id),
    FOREIGN KEY (empresa_id) REFERENCES Empresa(empresa_id),
    FOREIGN KEY (regiao_id) REFERENCES Regiao(regiao_id)
);

-- Tabela de Funções/Posições dentro do jogo
CREATE TABLE Funcao (
    funcao_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela de Jogadores
CREATE TABLE Jogador (
    jogador_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    data_nascimento DATE,
    pais_id INT NOT NULL, -- Corresponde a ||--|{
    -- ALTERADO! A coluna funcao_id foi removida para corresponder ao diagrama N-M.
    equipe_id INT, -- Permite NULL, correspondendo a }o--o{
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id),
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id)
);

-- Tabela de ligação Jogador <-> Funcao (Muitos para Muitos)
CREATE TABLE Funcao_Jogador (
    jogador_id INT NOT NULL,
    funcao_id INT NOT NULL, 
    PRIMARY KEY (jogador_id, funcao_id),
    FOREIGN KEY (jogador_id) REFERENCES Jogador(jogador_id),
    FOREIGN KEY (funcao_id) REFERENCES Funcao(funcao_id)
);

-- Tabela de Partidas
CREATE TABLE Partida (
    partida_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    data_inicio DATETIME,
    data_termino DATETIME,
    equipe1_id INT NOT NULL, -- Corresponde a ||--|{
    equipe2_id INT NOT NULL, -- Corresponde a ||--|{
    equipe_vencedor_id INT, -- Permite NULL, correspondendo a }o--o{
    jogo_id INT NOT NULL, -- Corresponde a ||--|{
    torneio_id INT, -- Permite NULL, correspondendo a }o--|{
    FOREIGN KEY (equipe1_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (equipe2_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (equipe_vencedor_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (jogo_id) REFERENCES Jogo(jogo_id),
    FOREIGN KEY (torneio_id) REFERENCES Torneio(torneio_id)
);

-- Tabela de ligação Jogador <-> Partida (Escalação)
CREATE TABLE Jogador_Partida (
    jogador_partida_id INT AUTO_INCREMENT PRIMARY KEY,
    jogador_id INT NOT NULL,
    partida_id INT NOT NULL,
    UNIQUE (jogador_id, partida_id),
    FOREIGN KEY (jogador_id) REFERENCES Jogador(jogador_id),
    FOREIGN KEY (partida_id) REFERENCES Partida(partida_id)
);

-- Tabela de Jogos dentro de uma Partida (Ex: Mapa 1 de uma MD3)
CREATE TABLE Jogo_Partida (
    jogo_partida_id INT AUTO_INCREMENT PRIMARY KEY,
    numero_jogo INT NOT NULL,
    mapa VARCHAR(100),
    duracao TIME,
    partida_id INT NOT NULL, -- Corresponde a ||--|{
    equipe_vencedor_id INT, -- Permite NULL, correspondendo a }o--o{
    FOREIGN KEY (partida_id) REFERENCES Partida(partida_id),
    FOREIGN KEY (equipe_vencedor_id) REFERENCES Equipe(equipe_id)
);

-- Tabela de estatísticas agregadas do jogador por torneio
CREATE TABLE Estatisticas_Jogador_Torneio (
    estatistica_id INT AUTO_INCREMENT PRIMARY KEY,
    vitorias INT DEFAULT 0,
    derrotas INT DEFAULT 0,
    kills INT DEFAULT 0,
    assistencias INT DEFAULT 0,
    jogador_id INT NOT NULL,
    torneio_id INT NOT NULL,
    FOREIGN KEY (jogador_id) REFERENCES Jogador(jogador_id),
    FOREIGN KEY (torneio_id) REFERENCES Torneio(torneio_id)
);

-- Tabela de estatísticas do jogador por jogo individual (mapa)
CREATE TABLE Estatistica_Jogador_Jogo (
    estatistica_id INT AUTO_INCREMENT PRIMARY KEY,
    kills INT DEFAULT 0,
    assistencias INT DEFAULT 0,
    mortes INT DEFAULT 0,
    vitorias INT DEFAULT 0,
    jogador_id INT NOT NULL,
    jogo_partida_id INT NOT NULL,
    FOREIGN KEY (jogador_id) REFERENCES Jogador(jogador_id),
    FOREIGN KEY (jogo_partida_id) REFERENCES Jogo_Partida(jogo_partida_id)
);

-- Tabela de estatísticas da equipe por jogo individual (mapa)
CREATE TABLE Estatistica_Equipe_Jogo (
    estatistica_id INT AUTO_INCREMENT PRIMARY KEY,
    pontuacao INT DEFAULT 0,
    vitorias INT DEFAULT 0,
    equipe_id INT NOT NULL,
    jogo_partida_id INT NOT NULL,
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (jogo_partida_id) REFERENCES Jogo_Partida(jogo_partida_id)
);

-- Tabela de ligação Equipe <-> Torneio
CREATE TABLE Participacao_Torneio (
    participacao_id INT AUTO_INCREMENT PRIMARY KEY,
    colocacao_final INT,
    torneio_id INT NOT NULL,
    equipe_id INT NOT NULL,
    FOREIGN KEY (torneio_id) REFERENCES Torneio(torneio_id),
    FOREIGN KEY (equipe_id) REFERENCES Equipe(equipe_id)
);

-- Tabela de Avaliações de Torneios
CREATE TABLE Avaliacao_Torneio (
    avaliacao_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(100),
    estrelas INT NOT NULL CHECK (estrelas BETWEEN 1 AND 5),
    comentario TEXT,
    torneio_id INT NOT NULL, -- Corresponde a ||--o{
    FOREIGN KEY (torneio_id) REFERENCES Torneio(torneio_id)
);

-- Tabela de Patrocinadores
CREATE TABLE Patrocinador (
    patrocinador_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    empresa_id INT NOT NULL, -- Corresponde a ||--|{
    FOREIGN KEY (empresa_id) REFERENCES Empresa(empresa_id)
);

-- Tabela de ligação Patrocinador <-> Torneio
CREATE TABLE Patrocinio_Torneio (
    patrocinio_id INT AUTO_INCREMENT PRIMARY KEY,
    valor_investido DECIMAL(15, 2),
    patrocinador_id INT NOT NULL,
    torneio_id INT NOT NULL,
    FOREIGN KEY (patrocinador_id) REFERENCES Patrocinador(patrocinador_id),
    FOREIGN KEY (torneio_id) REFERENCES Torneio(torneio_id)
);

-- Tabela de Status de Eventos
CREATE TABLE Status_Evento (
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela de Eventos (Ex: Cerimônia de Abertura)
CREATE TABLE Evento (
    evento_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    data_inicio DATETIME,
    data_fim DATETIME,
    torneio_id INT NOT NULL, -- Corresponde a ||--|{
    status_id INT NOT NULL, -- Corresponde a ||--|{
    FOREIGN KEY (torneio_id) REFERENCES Torneio(torneio_id),
    FOREIGN KEY (status_id) REFERENCES Status_Evento(status_id)
);

-- Tabela de Torcedores/Participantes em Eventos
CREATE TABLE Torcedor (
    participante_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    idade INT,
    genero VARCHAR(50),
    tipo ENUM('Fã', 'Staff', 'Convidado', 'Imprensa') DEFAULT 'Fã',
    evento_id INT NOT NULL, -- Corresponde a ||--|{
    equipe_favorita_id INT, -- Permite NULL, correspondendo a }o--o{
    pais_id INT NOT NULL, -- ALTERADO! Corresponde a ||--o{ no diagrama
    FOREIGN KEY (evento_id) REFERENCES Evento(evento_id),
    FOREIGN KEY (equipe_favorita_id) REFERENCES Equipe(equipe_id),
    FOREIGN KEY (pais_id) REFERENCES Pais(pais_id)
);

-- Tabela de ligação Evento <-> Patrocinador
CREATE TABLE Evento_Patrocinador (
    evento_patrocinador_id INT AUTO_INCREMENT PRIMARY KEY,
    valor_investido DECIMAL(15, 2),
    evento_id INT NOT NULL,
    patrocinador_id INT NOT NULL,
    FOREIGN KEY (evento_id) REFERENCES Evento(evento_id),
    FOREIGN KEY (patrocinador_id) REFERENCES Patrocinador(patrocinador_id)
);

USE CyberLeagueDB;

