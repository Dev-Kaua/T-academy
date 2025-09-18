package com.Aula5.ProjetoZoo.ApiZoologico.dtos;


import com.Aula5.ProjetoZoo.ApiZoologico.models.Alimentacao;

public record AlimentacaoDto (
    Long id,
    Alimentacao.TipoComida tipoComida,
    double quantidadeDiaria,
    Long animalId
){}
