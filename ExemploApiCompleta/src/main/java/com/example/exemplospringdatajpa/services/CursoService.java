package com.example.exemplospringdatajpa.services;

import com.example.exemplospringdatajpa.dtos.CursoDTO;
import com.example.exemplospringdatajpa.models.Curso;

public interface CursoService {
    Long inserir(CursoDTO cursoDTO);
}
