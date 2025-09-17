package com.Tacademy.APIs.Spring.Aula4_projetoBibliotecaDeTarefas.models;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private LocalDate dataCriacao;
    private LocalDate prazo;


}
