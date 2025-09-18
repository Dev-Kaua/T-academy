—--------------------------------SELECTS—-------------------------------------


-- SELECTS --

#1
SELECT 
    t.nome AS torneio,
    t.data_inicio,
    t.data_termino,
    t.premio_total
FROM Torneio t
INNER JOIN Jogo j ON t.jogo_id = j.jogo_id
WHERE j.nome = 'League of Legends';



#2
SELECT 
    j.nome,
    j.nickname,
    SUM(ejj.vitorias) AS total_vitorias
FROM Jogador j
INNER JOIN Estatistica_Jogador_Jogo ejj ON j.jogador_id = ejj.jogador_id
INNER JOIN JogoPartida jp ON ejj.jogo_partida_id = jp.jogo_partida_id
INNER JOIN Partida p ON jp.partida_id = p.partida_id
INNER JOIN Torneio t ON p.torneio_id = t.torneio_id
INNER JOIN Temporada temp ON t.temporada_id = temp.temporada_id
WHERE temp.ano = 2023   -- aqui você define a temporada desejada
GROUP BY j.jogador_id, j.nome, j.nickname
ORDER BY total_vitorias DESC
LIMIT 5;

#3
SELECT 
    e.nome AS equipe
FROM Equipe e
INNER JOIN Participacao_Torneio pt ON e.equipe_id = pt.equipe_id
INNER JOIN Torneio t ON pt.torneio_id = t.torneio_id
WHERE t.nome = 'Worlds 2023';

#4
SELECT 
    j.nome,
    j.nickname,
    ROUND(AVG(ejj.vitorias) * 100, 2) AS taxa_vitorias
FROM Jogador j
INNER JOIN Estatistica_Jogador_Jogo ejj 
    ON j.jogador_id = ejj.jogador_id
INNER JOIN JogoPartida jp 
    ON ejj.jogo_partida_id = jp.jogo_partida_id
INNER JOIN Partida p 
    ON jp.partida_id = p.partida_id
INNER JOIN Torneio t 
    ON p.torneio_id = t.torneio_id
INNER JOIN Temporada temp
    ON t.temporada_id = temp.temporada_id
WHERE temp.ano >= 2023
GROUP BY j.jogador_id, j.nome, j.nickname
ORDER BY taxa_vitorias ASC
LIMIT 5;


#5
SELECT 
    e.nome AS empresa_patrocinadora,
    pt.valor_investido
FROM Patrocinio_Torneio pt
INNER JOIN Patrocinador p ON pt.patrocinador_id = p.patrocinador_id
INNER JOIN Empresa e ON p.empresa_id = e.empresa_id
INNER JOIN Torneio t ON pt.torneio_id = t.torneio_id
WHERE t.nome = 'Worlds 2023';

#6
SELECT 
    t.nome AS torneio,
    t.data_inicio,
    t.data_termino,
    SUM(pt.valor_investido) AS total_patrocinios
FROM Torneio t
INNER JOIN Patrocinio_Torneio pt 
    ON t.torneio_id = pt.torneio_id
WHERE t.data_inicio >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
GROUP BY t.torneio_id, t.nome, t.data_inicio, t.data_termino
ORDER BY total_patrocinios DESC;

#7
SELECT 
    e.nome AS equipe,
    pa.nome AS pais_origem,
    e.data_fundacao
FROM Equipe e
INNER JOIN Regiao r ON e.regiao_id = r.regiao_id
INNER JOIN Pais pa ON r.pais_id = pa.pais_id
LEFT JOIN Jogador j ON e.equipe_id = j.equipe_id
GROUP BY e.equipe_id, e.nome, pa.nome, e.data_fundacao
HAVING COUNT(j.jogador_id) < 5;

#8
SELECT 
    j.nome,
    j.nickname,
    t.nome AS torneio
FROM Jogador j
INNER JOIN Estatisticas_Jogador_Torneio ejt ON j.jogador_id = ejt.jogador_id
INNER JOIN Torneio t ON ejt.torneio_id = t.torneio_id
WHERE j.nickname = 'Faker'
  AND t.nome = 'Worlds 2023';

#9
SELECT 
    t.nome AS torneio,
    ROUND(AVG(a.estrelas), 2) AS media_estrelas,
    COUNT(a.avaliacao_id) AS total_avaliacoes
FROM Torneio t
INNER JOIN Avaliacao_Torneio a ON t.torneio_id = a.torneio_id
GROUP BY t.torneio_id, t.nome
ORDER BY media_estrelas DESC, total_avaliacoes DESC;

#10
SELECT 
    e.nome AS equipe,
    COALESCE(SUM(eej.vitorias), 0) AS total_vitorias,
    pt.colocacao_final
FROM Participacao_Torneio pt
INNER JOIN Equipe e ON pt.equipe_id = e.equipe_id
LEFT JOIN Estatistica_Equipe_Jogo eej 
    ON e.equipe_id = eej.equipe_id
LEFT JOIN Jogo_Partida jp ON eej.jogo_partida_id = jp.jogo_partida_id
LEFT JOIN Partida p ON jp.partida_id = p.partida_id
WHERE pt.torneio_id = 2
GROUP BY e.equipe_id, e.nome, pt.colocacao_final
ORDER BY pt.colocacao_final ASC;


-- TRIGGERS --

DELIMITER //

CREATE TRIGGER AtualizaEquipeJogador
AFTER INSERT ON Jogador
FOR EACH ROW
BEGIN
    -- Atualiza data_fundacao para a data atual apenas como exemplo de trigger
    UPDATE Equipe
    SET data_fundacao = CURDATE()
    WHERE equipe_id = NEW.equipe_id;
END;
//

DELIMITER ;


DELIMITER //

CREATE TRIGGER ValidaEstrelasAvaliacao
BEFORE INSERT ON Avaliacao_Torneio
FOR EACH ROW
BEGIN
    IF NEW.estrelas < 1 OR NEW.estrelas > 5 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Valor de estrelas inválido, deve ser entre 1 e 5';
    END IF;
END;
//

DELIMITER ;

-- VIEWS --


CREATE VIEW View_RankingJogadores AS
SELECT 
    j.jogador_id,
    j.nome,
    j.nickname,
    SUM(ejj.vitorias) AS total_vitorias
FROM Jogador j
INNER JOIN Estatistica_Jogador_Jogo ejj ON j.jogador_id = ejj.jogador_id
GROUP BY j.jogador_id, j.nome, j.nickname
ORDER BY total_vitorias DESC;

-- FUNCTIONS --

1. Calcular média de vitórias de um jogador

DELIMITER //

CREATE FUNCTION MediaVitoriasJogador(jogador INT)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE media DECIMAL(5,2);
    SELECT AVG(vitorias) INTO media
    FROM Estatistica_Jogador_Jogo
    WHERE jogador_id = jogador;
    RETURN media;
END;
//

DELIMITER ;

-- PROCEDURES --

1. Listar equipes com menos de 5 jogadores (recrutamento)

DELIMITER //

CREATE PROCEDURE EquipesRecrutando()
BEGIN
    SELECT 
        e.nome AS equipe,
        p.nome AS pais_origem,
        e.data_fundacao,
        COUNT(j.jogador_id) AS total_jogadores
    FROM Equipe e
    LEFT JOIN Jogador j ON e.equipe_id = j.equipe_id
    LEFT JOIN Pais p ON e.pais_id = p.pais_id
    GROUP BY e.equipe_id, e.nome, p.nome, e.data_fundacao
    HAVING COUNT(j.jogador_id) < 5;
END;
//
DELIMITER ;
CALL EquipesRecrutando();