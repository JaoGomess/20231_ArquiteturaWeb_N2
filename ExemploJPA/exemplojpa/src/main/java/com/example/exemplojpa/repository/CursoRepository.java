package com.example.exemplojpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.exemplojpa.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso inserir(Curso curso) {
        return entityManager.merge(curso);
    }

    @Transactional
    public Curso editar(Curso curso) {
        return entityManager.merge(curso);
    }

    @Transactional
    public void excluir(Curso curso) {
        entityManager.remove(curso);
    }

    public Curso obterPorId(long id) {
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public void excluir(long id) {
        entityManager.remove(obterPorId(id));
    }

    public List<Curso> obterTodos() {
        return entityManager
                .createQuery("from Curso", Curso.class).getResultList();
    }

    public List<Curso> obterPorNome(String nome) {
        String jpql = "select c from Curso c where nome like :nome";
        TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }

}
