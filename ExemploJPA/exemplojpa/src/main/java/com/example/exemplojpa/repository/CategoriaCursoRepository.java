package com.example.exemplojpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.exemplojpa.model.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaCurso inserir(CategoriaCurso categ) {
        return entityManager.merge(categ);
    }

    public List<CategoriaCurso> obterTodos() {
        return entityManager
                .createQuery("from CategoriaCurso",
                        CategoriaCurso.class)
                .getResultList();
    }
}
