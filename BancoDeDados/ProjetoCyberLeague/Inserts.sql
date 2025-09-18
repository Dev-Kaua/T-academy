USE CyberLeagueDB;

-- =========================================================
-- Bloco 1: Tabelas sem dependências de chaves estrangeiras
-- =========================================================

--- Inserindo dados na tabela 'Regiao'
INSERT INTO Regiao (nome) VALUES
('South America'),
('North America'),
('Europe'),
('Korea'),
('China'),
('Japan'),
('Oceania');

--- Inserindo dados na tabela 'Pais'
INSERT INTO Pais (nome, continente, regiao_id) VALUES
('Brasil', 'América do Sul', (SELECT regiao_id FROM Regiao WHERE nome = 'South America')),
('Estados Unidos', 'América do Norte', (SELECT regiao_id FROM Regiao WHERE nome = 'North America')),
('Coreia do Sul', 'Ásia', (SELECT regiao_id FROM Regiao WHERE nome = 'Korea')),
('China', 'Ásia', (SELECT regiao_id FROM Regiao WHERE nome = 'China')),
('Japão', 'Ásia', (SELECT regiao_id FROM Regiao WHERE nome = 'Japan')),
('Alemanha', 'Europa', (SELECT regiao_id FROM Regiao WHERE nome = 'Europe')),
('Reino Unido', 'Europa', (SELECT regiao_id FROM Regiao WHERE nome = 'Europe')),
('França', 'Europa', (SELECT regiao_id FROM Regiao WHERE nome = 'Europe'));

--- Inserindo dados na tabela 'Empresa'
INSERT INTO Empresa (nome, apelido, ano_fundacao, pais_id) VALUES
('Riot Games', 'Riot', 2006, (SELECT pais_id FROM Pais WHERE nome = 'Estados Unidos'));

--- Inserindo dados na tabela 'Funcao'
INSERT INTO Funcao (nome) VALUES
('Top Laner'), ('Jungle'), ('Mid Laner'), ('ADC'), ('Support'),
('Duelista'), ('Iniciador'), ('Controlador'), ('Sentinela');

--- Inserindo dados na tabela 'Temporada'
INSERT INTO Temporada (ano, nome) VALUES
(2023, 'Temporada 2023'),
(2024, 'Temporada 2024');

--- Inserindo dados na tabela 'Status_Evento'
INSERT INTO Status_Evento (descricao) VALUES
('Planejado'), ('Em Andamento'), ('Concluído'), ('Cancelado');

-- =========================================================
-- Bloco 2: Tabelas que dependem das tabelas do Bloco 1
-- =========================================================

--- Inserindo dados na tabela 'Jogo'
INSERT INTO Jogo (nome, genero, empresa_id) VALUES
('League of Legends', 'MOBA', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games')),
('Valorant', 'Tiro tático em primeira pessoa', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'));

--- Inserindo dados na tabela 'Patrocinador'
INSERT INTO Patrocinador (nome, empresa_id) VALUES
('Red Bull', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games')),
('Kia Motors', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games')),
('Mastercard', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'));

--- Inserindo dados na tabela 'Equipe'
INSERT INTO Equipe (nome, tag, data_fundacao, empresa_id, regiao_id) VALUES
('LOUD', 'LOUD', '2019-02-28', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'), (SELECT regiao_id FROM Regiao WHERE nome = 'South America')),
('T1', 'T1', '2004-12-13', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'), (SELECT regiao_id FROM Regiao WHERE nome = 'Korea')),
('Fnatic', 'FNC', '2004-07-23', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'), (SELECT regiao_id FROM Regiao WHERE nome = 'Europe')),
('DRX', 'DRX', '2017-01-01', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'), (SELECT regiao_id FROM Regiao WHERE nome = 'Korea')),
('Gen.G Esports', 'GEN', '2017-08-10', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'), (SELECT regiao_id FROM Regiao WHERE nome = 'Korea')),
('Cloud9', 'C9', '2013-01-01', (SELECT empresa_id FROM Empresa WHERE nome = 'Riot Games'), (SELECT regiao_id FROM Regiao WHERE nome = 'North America'));

-- =========================================================
-- Bloco 3: Tabelas que dependem das tabelas do Bloco 2
-- =========================================================

--- Inserindo dados na tabela 'Torneio'
INSERT INTO Torneio (nome, data_inicio, data_termino, premio_total, jogo_id, temporada_id) VALUES
('MSI 2024', '2024-05-01', '2024-05-19', 250000.00, (SELECT jogo_id FROM Jogo WHERE nome = 'League of Legends'), (SELECT temporada_id FROM Temporada WHERE ano = 2024)),
('Worlds 2023', '2023-10-10', '2023-11-19', 2225000.00, (SELECT jogo_id FROM Jogo WHERE nome = 'League of Legends'), (SELECT temporada_id FROM Temporada WHERE ano = 2023)),
('VCT Masters Madrid 2024', '2024-03-14', '2024-03-24', 500000.00, (SELECT jogo_id FROM Jogo WHERE nome = 'Valorant'), (SELECT temporada_id FROM Temporada WHERE ano = 2024)),
('VCT Champions 2023', '2023-08-06', '2023-08-26', 2250000.00, (SELECT jogo_id FROM Jogo WHERE nome = 'Valorant'), (SELECT temporada_id FROM Temporada WHERE ano = 2023));

--- Inserindo dados na tabela 'Liga'
INSERT INTO Liga (nome, codigo, nivel, jogo_id, regiao_id) VALUES
('League of Legends Champions Korea', 'LCK', 1, (SELECT jogo_id FROM Jogo WHERE nome = 'League of Legends'), (SELECT regiao_id FROM Regiao WHERE nome = 'Korea')),
('League of Legends Pro League', 'LPL', 1, (SELECT jogo_id FROM Jogo WHERE nome = 'League of Legends'), (SELECT regiao_id FROM Regiao WHERE nome = 'China')),
('VALORANT Champions Tour Americas', 'VCT Americas', 1, (SELECT jogo_id FROM Jogo WHERE nome = 'Valorant'), (SELECT regiao_id FROM Regiao WHERE nome = 'South America')),
('VALORANT Champions Tour EMEA', 'VCT EMEA', 1, (SELECT jogo_id FROM Jogo WHERE nome = 'Valorant'), (SELECT regiao_id FROM Regiao WHERE nome = 'Europe')),
('Campeonato Brasileiro de League of Legends', 'CBLOL', 1, (SELECT jogo_id FROM Jogo WHERE nome = 'League of Legends'), (SELECT regiao_id FROM Regiao WHERE nome = 'South America'));


-- =========================================================
-- Bloco 4: Tabelas que dependem de tabelas dos blocos anteriores
-- =========================================================


--- Inserindo dados na tabela 'Jogador' (LoL e Valorant)
INSERT INTO Jogador (nome, nickname, data_nascimento, pais_id, equipe_id) VALUES
-- Jogadores de LoL
('Lee Sang-hyeok', 'Faker', '1996-05-07', (SELECT pais_id FROM Pais WHERE nome = 'Coreia do Sul'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1')),
('Ryu Min-seok', 'Keria', '2002-10-20', (SELECT pais_id FROM Pais WHERE nome = 'Coreia do Sul'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1')),
('Choi Hyeon-jun', 'Zeus', '2004-01-31', (SELECT pais_id FROM Pais WHERE nome = 'Coreia do Sul'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1')),
('Kim Hyuk-kyu', 'Deft', '1996-10-23', (SELECT pais_id FROM Pais WHERE nome = 'Coreia do Sul'), (SELECT equipe_id FROM Equipe WHERE tag = 'DRX')),
-- Jogadores de Valorant
('Erick Santos', 'aspas', '2003-01-15', (SELECT pais_id FROM Pais WHERE nome = 'Brasil'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD')),
('Felipe de Paula', 'Less', '2004-02-14', (SELECT pais_id FROM Pais WHERE nome = 'Brasil'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD')),
('Jake Howlett', 'Boaster', '1995-05-25', (SELECT pais_id FROM Pais WHERE nome = 'Reino Unido'), (SELECT equipe_id FROM Equipe WHERE tag = 'FNC')),
('Emir Ali Beder', 'Alfajer', '2005-09-08', (SELECT pais_id FROM Pais WHERE nome = 'Alemanha'), (SELECT equipe_id FROM Equipe WHERE tag = 'FNC'));


--- Inserindo dados na tabela 'Participacao_Torneio'
INSERT INTO Participacao_Torneio (colocacao_final, torneio_id, equipe_id) VALUES
(1, (SELECT torneio_id FROM Torneio WHERE nome = 'Worlds 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1')),
(2, (SELECT torneio_id FROM Torneio WHERE nome = 'Worlds 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'DRX')),
(1, (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD')),
(2, (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'DRX'));


--- Inserindo dados na tabela 'Avaliacao_Torneio'
INSERT INTO Avaliacao_Torneio (usuario, estrelas, comentario, torneio_id) VALUES
('João P.', 5, 'Melhor torneio que já assisti!', (SELECT torneio_id FROM Torneio WHERE nome = 'Worlds 2023')),
('Maria S.', 5, 'Vibração incrível, ótima produção.', (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'));


--- Inserindo dados na tabela 'Patrocinio_Torneio'
INSERT INTO Patrocinio_Torneio (valor_investido, patrocinador_id, torneio_id) VALUES
(500000.00, (SELECT patrocinador_id FROM Patrocinador WHERE nome = 'Kia Motors'), (SELECT torneio_id FROM Torneio WHERE nome = 'Worlds 2023')),
(200000.00, (SELECT patrocinador_id FROM Patrocinador WHERE nome = 'Red Bull'), (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'));


--- Inserindo dados na tabela 'Evento'
INSERT INTO Evento (nome, data_inicio, data_fim, torneio_id, status_id) VALUES
('Cerimônia de Abertura MSI 2024', '2024-05-01 09:00:00', '2024-05-01 10:00:00', (SELECT torneio_id FROM Torneio WHERE nome = 'MSI 2024'), (SELECT status_id FROM Status_Evento WHERE descricao = 'Concluído')),
('Final VCT Champions 2023', '2023-08-26 13:00:00', '2023-08-26 15:45:00', (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'), (SELECT status_id FROM Status_Evento WHERE descricao = 'Concluído'));


-- =========================================================
-- Bloco 5: Tabelas que dependem de tabelas dos blocos 3 e 4
-- =========================================================


--- Inserindo dados na tabela 'Funcao_Jogador' (muitos para muitos)
INSERT INTO Funcao_Jogador (jogador_id, funcao_id) VALUES
((SELECT jogador_id FROM Jogador WHERE nickname = 'Faker'), (SELECT funcao_id FROM Funcao WHERE nome = 'Mid Laner')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Keria'), (SELECT funcao_id FROM Funcao WHERE nome = 'Support')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Zeus'), (SELECT funcao_id FROM Funcao WHERE nome = 'Top Laner')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Deft'), (SELECT funcao_id FROM Funcao WHERE nome = 'ADC')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'aspas'), (SELECT funcao_id FROM Funcao WHERE nome = 'Duelista')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Less'), (SELECT funcao_id FROM Funcao WHERE nome = 'Controlador')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Boaster'), (SELECT funcao_id FROM Funcao WHERE nome = 'Iniciador')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Alfajer'), (SELECT funcao_id FROM Funcao WHERE nome = 'Sentinela'));


--- Inserindo dados na tabela 'Partida'
INSERT INTO Partida (nome, data_inicio, data_termino, equipe1_id, equipe2_id, equipe_vencedor_id, jogo_id, torneio_id) VALUES
('Final Worlds 2023', '2023-11-19 05:00:00', '2023-11-19 07:30:00', (SELECT equipe_id FROM Equipe WHERE tag = 'T1'), (SELECT equipe_id FROM Equipe WHERE tag = 'DRX'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1'), (SELECT jogo_id FROM Jogo WHERE nome = 'League of Legends'), (SELECT torneio_id FROM Torneio WHERE nome = 'Worlds 2023')),
('Final VCT Champions 2023', '2023-08-26 13:00:00', '2023-08-26 15:45:00', (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT equipe_id FROM Equipe WHERE tag = 'DRX'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT jogo_id FROM Jogo WHERE nome = 'Valorant'), (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'));


--- Inserindo dados na tabela 'Torcedor'
INSERT INTO Torcedor (nome, idade, genero, tipo, evento_id, equipe_favorita_id, pais_id) VALUES
-- Populando com nomes fictícios para permitir métricas de torcida
-- LOUD com mais torcedores
('Ana Clara', 22, 'Feminino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT pais_id FROM Pais WHERE nome = 'Brasil')),
('Pedro Henrique', 19, 'Masculino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT pais_id FROM Pais WHERE nome = 'Brasil')),
('Fernanda Lima', 25, 'Feminino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT pais_id FROM Pais WHERE nome = 'Brasil')),
('Lucas Oliveira', 20, 'Masculino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT pais_id FROM Pais WHERE nome = 'Brasil')),
('Maria Eduarda', 18, 'Feminino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT pais_id FROM Pais WHERE nome = 'Brasil')),
('Carlos Souza', 21, 'Masculino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT pais_id FROM Pais WHERE nome = 'Brasil')),
-- T1 e FNC com menos torcedores, mas ainda presentes
('Kim Ji-Hoon', 24, 'Masculino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Cerimônia de Abertura MSI 2024'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1'), (SELECT pais_id FROM Pais WHERE nome = 'Coreia do Sul')),
('Emily White', 23, 'Feminino', 'Fã', (SELECT evento_id FROM Evento WHERE nome = 'Cerimônia de Abertura MSI 2024'), (SELECT equipe_id FROM Equipe WHERE tag = 'FNC'), (SELECT pais_id FROM Pais WHERE nome = 'Reino Unido'));


--- Inserindo dados na tabela 'Evento_Patrocinador'
INSERT INTO Evento_Patrocinador (valor_investido, evento_id, patrocinador_id) VALUES
(150000.00, (SELECT evento_id FROM Evento WHERE nome = 'Final VCT Champions 2023'), (SELECT patrocinador_id FROM Patrocinador WHERE nome = 'Red Bull')),
(300000.00, (SELECT evento_id FROM Evento WHERE nome = 'Cerimônia de Abertura MSI 2024'), (SELECT patrocinador_id FROM Patrocinador WHERE nome = 'Mastercard'));


-- =========================================================
-- Bloco 6: Tabelas que dependem de Partida e Jogador
-- =========================================================


--- Inserindo dados na tabela 'Jogador_Partida'
INSERT INTO Jogador_Partida (jogador_id, partida_id) VALUES
((SELECT jogador_id FROM Jogador WHERE nickname = 'Faker'), (SELECT partida_id FROM Partida WHERE nome = 'Final Worlds 2023')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'aspas'), (SELECT partida_id FROM Partida WHERE nome = 'Final VCT Champions 2023')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Less'), (SELECT partida_id FROM Partida WHERE nome = 'Final VCT Champions 2023')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Keria'), (SELECT partida_id FROM Partida WHERE nome = 'Final Worlds 2023')),
((SELECT jogador_id FROM Jogador WHERE nickname = 'Zeus'), (SELECT partida_id FROM Partida WHERE nome = 'Final Worlds 2023'));


--- Inserindo dados na tabela 'Jogo_Partida'
INSERT INTO Jogo_Partida (numero_jogo, mapa, duracao, partida_id, equipe_vencedor_id) VALUES
(1, 'Summoner''s Rift', '00:35:00', (SELECT partida_id FROM Partida WHERE nome = 'Final Worlds 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1')),
(2, 'Summoner''s Rift', '00:41:00', (SELECT partida_id FROM Partida WHERE nome = 'Final Worlds 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'T1')),
(3, 'Ascent', '00:28:00', (SELECT partida_id FROM Partida WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD')),
(4, 'Split', '00:32:00', (SELECT partida_id FROM Partida WHERE nome = 'Final VCT Champions 2023'), (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'));


--- Inserindo dados na tabela 'Estatisticas_Jogador_Torneio'
INSERT INTO Estatisticas_Jogador_Torneio (vitorias, derrotas, kills, assistencias, jogador_id, torneio_id) VALUES
(12, 1, 150, 200, (SELECT jogador_id FROM Jogador WHERE nickname = 'Faker'), (SELECT torneio_id FROM Torneio WHERE nome = 'Worlds 2023')),
(15, 2, 210, 50, (SELECT jogador_id FROM Jogador WHERE nickname = 'aspas'), (SELECT torneio_id FROM Torneio WHERE nome = 'VCT Champions 2023'));




-- =========================================================
-- Bloco 7: Tabelas que dependem de Jogo_Partida
-- =========================================================


--- Inserindo dados na tabela 'Estatistica_Jogador_Jogo'
INSERT INTO Estatistica_Jogador_Jogo (kills, assistencias, mortes, vitorias, jogador_id, jogo_partida_id) VALUES
(12, 5, 3, 1, (SELECT jogador_id FROM Jogador WHERE nickname = 'aspas'), (SELECT jogo_partida_id FROM Jogo_Partida WHERE numero_jogo = 3)),
(8, 2, 4, 1, (SELECT jogador_id FROM Jogador WHERE nickname = 'Faker'), (SELECT jogo_partida_id FROM Jogo_Partida WHERE numero_jogo = 1));


--- Inserindo dados na tabela 'Estatistica_Equipe_Jogo'
INSERT INTO Estatistica_Equipe_Jogo (pontuacao, vitorias, equipe_id, jogo_partida_id) VALUES
(13, 1, (SELECT equipe_id FROM Equipe WHERE tag = 'LOUD'), (SELECT jogo_partida_id FROM Jogo_Partida WHERE numero_jogo = 3)),
(13, 1, (SELECT equipe_id FROM Equipe WHERE tag = 'T1'), (SELECT jogo_partida_id FROM Jogo_Partida WHERE numero_jogo = 1));


