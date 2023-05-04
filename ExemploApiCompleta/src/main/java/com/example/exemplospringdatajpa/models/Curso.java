package com.example.exemplospringdatajpa.models;

import com.example.exemplospringdatajpa.validations.NomeCurso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    @NomeCurso(message = "Nome inválido. [Exemplo: curso01]")
    private String nome;
    @Column(nullable = false)
    @Max(value = 3000, message = "CH máxima é 3000")
    @Min(value = 1000, message = "CH mínima é 1000")
    private int cargaHoraria;
    @ManyToOne
    @JoinColumn(name = "categoriaCurso_id")
    private CategoriaCurso categoriaCurso;

}
