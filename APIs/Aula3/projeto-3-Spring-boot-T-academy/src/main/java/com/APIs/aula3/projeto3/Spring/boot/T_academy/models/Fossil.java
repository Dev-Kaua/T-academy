package com.APIs.aula3.projeto3.Spring.boot.T_academy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fossil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Era era;

    private String descricao;
}
