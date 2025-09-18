# CyberLeague - Banco de Dados de E-Sports 🎮

## Descrição
Projeto acadêmico: modelagem e implementação do banco de dados da *CyberLeague, uma liga de e-sports que organiza torneios, gerencia equipes e acompanha estatísticas de jogadores. Projeto desenvolvido apenas com **SQL* e versionado no *Git/GitHub*.

---

## Autores / Equipe
- Kaua Reis Rodrigues  
- Rhuan  
- Pedro  
- Enzo  
- Thiago

---

## Tecnologias
- MySQL (ou outro SGBD compatível com SQL ANSI)
- Git / GitHub

---

## Objetivo
Modelar um banco relacional que permita:
- Registrar jogos, torneios e temporadas;
- Gerenciar equipes e jogadores (com funções N-M);
- Armazenar estatísticas por torneio e por partida;
- Registrar patrocinadores e avaliações de fãs;
- Gerar relatórios (top jogadores, equipes participantes, torneios por jogo, etc).

---

## Estrutura resumida (entidades principais)
- *Regiao, **Pais*  
- *Empresa* (desenvolvedoras / orgs)  
- *Jogo* (nome, genero, empresa_id)  
- *Temporada, **Torneio* (data_inicio, data_termino, premio_total, jogo_id, temporada_id)  
- *Liga, **Equipe* (nome, tag, data_fundacao, empresa_id, regiao_id, pais_id)  
- *Funcao, **Jogador, **Funcao_Jogador* (N-M)  
- *Partida, **Jogo_Partida, **Jogador_Partida*  
- *Estatisticas_Jogador_Torneio, **Estatistica_Jogador_Jogo, **Estatistica_Equipe_Jogo*  
- *Patrocinador, **Patrocinio_Torneio, **Evento, **Evento_Patrocinador, **Torcedor*  
- *Avaliacao_Torneio, **Status_Evento, **Participacao_Torneio*

> Observação: nomes de tabelas e colunas seguem o script BancoDeDados (ex.: Torneio.torneio_id, Jogo.jogo_id, Jogador.jogador_id, etc.).

---

## Exemplos de consultas (compatíveis com o script fornecido)

### 1) Torneios disponíveis para um jogo específico
```sql
SELECT 
    t.nome AS torneio,
    t.data_inicio,
    t.data_termino,
    t.premio_total
FROM Torneio t
INNER JOIN Jogo j ON t.jogo_id = j.jogo_id
WHERE j.nome = 'Valorant';
```

2) Top 5 jogadores mais vitoriosos em uma temporada

(usa a tabela Estatisticas_Jogador_Torneio + ligação com Temporada)
```sql
SELECT 
    j.nome,
    j.nickname,
    SUM(ejt.vitorias) AS total_vitorias
FROM Jogador j
INNER JOIN Estatisticas_Jogador_Torneio ejt ON j.jogador_id = ejt.jogador_id
INNER JOIN Torneio t ON ejt.torneio_id = t.torneio_id
INNER JOIN Temporada temp ON t.temporada_id = temp.temporada_id
WHERE temp.ano = 2023
GROUP BY j.jogador_id, j.nome, j.nickname
ORDER BY total_vitorias DESC
LIMIT 5;
```
3) Equipes participantes de um torneio específico
```sql
SELECT 
    e.nome AS equipe
FROM Equipe e
INNER JOIN Participacao_Torneio pt ON e.equipe_id = pt.equipe_id
INNER JOIN Torneio t ON pt.torneio_id = t.torneio_id
WHERE t.nome = 'CyberLeague Grand Finals 2025';
```

---

Views / Triggers / Procedures incluídas (exemplos no script)

View_RankingJogadores — ranking por total de vitórias.

Trigger ValidaEstrelasAvaliacao — valida 1 a 5 estrelas antes de inserir.

Trigger AtualizaEquipeJogador — exemplo de ação após insert em Jogador.

Function MediaVitoriasJogador(jogador INT) — média de vitórias por jogador.

Procedure EquipesRecrutando() — lista equipes com menos de 5 jogadores.



---

Como rodar (MySQL)

1. Clone o repositório:



git clone https://github.com/seu-repo/cyberleague-db.git

2. No terminal, importe o script (assumindo BancoDeDados.sql):



mysql -u <usuario> -p < BancoDeDados.sql

3. Conecte ao banco e verifique dados:


```sql
USE CyberLeagueDB;
SELECT * FROM Torneio LIMIT 10;
```
---

Status

✅ Concluído (implementação SQL + dados de exemplo). Aberto a melhorias e otimizações.


---
