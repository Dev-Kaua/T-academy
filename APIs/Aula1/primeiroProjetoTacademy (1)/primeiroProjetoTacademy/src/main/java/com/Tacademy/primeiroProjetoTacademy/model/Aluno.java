package com.Tacademy.primeiroProjetoTacademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que é o modelo de um objeto. todos os modelos de objeto devem ter essa anotação
@Table(name = "alunos")
@Data //cria os getters, setters e construtor sem argumentos
@AllArgsConstructor //cria o construtor com todos os argumentos
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private int idade;
}
