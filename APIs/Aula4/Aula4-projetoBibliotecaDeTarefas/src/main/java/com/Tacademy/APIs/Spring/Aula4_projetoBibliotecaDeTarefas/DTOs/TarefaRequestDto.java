package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.DTOs;

import com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models.Status;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public record TarefaRequestDto(
        @NotNull String titulo,
        String descricao,
        @NotNull Status status,
        LocalDate prazo
) {
}
