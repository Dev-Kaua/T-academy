package com.APIs.aula2.segundo.projeto.Spring.boot.T_academy.dtos;

import java.util.List;

public record TimeDTO(long id, String nome, String cidade, List<JogadorDTO> jogadores) {
}
