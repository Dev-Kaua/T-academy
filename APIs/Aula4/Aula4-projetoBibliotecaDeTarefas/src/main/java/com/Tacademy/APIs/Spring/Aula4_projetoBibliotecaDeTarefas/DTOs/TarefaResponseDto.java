package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.DTOs;

import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Status;

import java.time.LocalDate;

public record TarefaResponseDto(
        Long id,
        String titulo,
        String descricao,
        Status status,
        LocalDate dataCriacao,
        LocalDate prazo
) {
}
