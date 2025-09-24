package com.example.Projeto_Relacoes.Dtos;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String cep,
        String cidade,
        String estado,
        String bairro
) {
}
