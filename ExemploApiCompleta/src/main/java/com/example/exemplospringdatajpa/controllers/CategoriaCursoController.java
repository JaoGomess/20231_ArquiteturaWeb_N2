package com.example.exemplospringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplospringdatajpa.dtos.CategoriaCursoDTO;
import com.example.exemplospringdatajpa.services.CategoriaCursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoriaCurso")
public class CategoriaCursoController {
    private CategoriaCursoService categoriaCursoService;

    public CategoriaCursoController(
            CategoriaCursoService categoriaCursoService) {
        this.categoriaCursoService = categoriaCursoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long inserir(@Valid @RequestBody CategoriaCursoDTO dto) {
        return categoriaCursoService.inserir(dto);
    }
}
