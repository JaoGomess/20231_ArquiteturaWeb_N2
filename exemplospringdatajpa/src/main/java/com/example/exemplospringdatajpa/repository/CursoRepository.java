package com.example.exemplospringdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exemplospringdatajpa.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
        List<Curso> findByNome(String nome);

        List<Curso> findByNomeLike(String nome);

}
