package com.example.exemplospringdatajpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplospringdatajpa.dtos.CursoDTO;
import com.example.exemplospringdatajpa.dtos.DadosCursoDTO;
import com.example.exemplospringdatajpa.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("{id}")
    public DadosCursoDTO obterCursoPorId(@PathVariable Long id) {
        return cursoService.obterCursoPorId(id);
    }

    @GetMapping
    public List<DadosCursoDTO> obterTodos() {
        return cursoService.obterTodos();
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Long id) {
        cursoService.remover(id);
    }

    @PutMapping("{id}")
    public void editar(@PathVariable Long id,
            @RequestBody CursoDTO dto) {
        cursoService.editar(id, dto);
    }

    @PostMapping
    public Long inserir(@RequestBody CursoDTO cursoDTO) {
        return cursoService.inserir(cursoDTO);
    }
}
