package com.example.Projeto_Relacoes.Dtos;

public record ViaCepResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade, // esse é o campo da cidade
        String uf //esse é do estado
) {
}
