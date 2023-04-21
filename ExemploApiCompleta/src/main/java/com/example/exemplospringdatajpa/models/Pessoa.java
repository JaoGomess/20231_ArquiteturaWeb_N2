package com.example.exemplospringdatajpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pessoa {
    @Id
    private Integer id;
    @ManyToMany
    @JoinTable(name = "pessoa_curso", joinColumns = { @JoinColumn(name = "pessoa_id") }, inverseJoinColumns = {
            @JoinColumn(name = "curso_id") })
    List<Curso2> cursos;
}
