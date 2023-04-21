package com.example.exemplospringdatajpa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    private Long categoriaCursoId;
}
