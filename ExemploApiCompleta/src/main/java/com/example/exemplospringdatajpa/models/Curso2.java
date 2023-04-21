package com.example.exemplospringdatajpa.models;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso2 {
    @Id
    private Integer id;
    @ManyToMany(mappedBy = "cursos")
    List<Pessoa> pessoas;

}
