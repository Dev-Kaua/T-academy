package com.Aula5.ProjetoZoo.ApiZoologico.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Alimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private double quantidadeDiaria;

    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;

    public enum TipoComida {
        CARNE,
        FRUTAS,
        RACAO_ESPECIAL
    }

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}