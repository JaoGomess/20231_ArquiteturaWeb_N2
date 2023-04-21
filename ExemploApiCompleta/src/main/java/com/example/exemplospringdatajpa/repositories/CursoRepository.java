package com.example.exemplospringdatajpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exemplospringdatajpa.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
        List<Curso> findByNome(String nome);

        List<Curso> findByNomeLike(String nome);

}
