package com.example.exemplospringdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exemplospringdatajpa.models.CategoriaCurso;
import com.example.exemplospringdatajpa.models.Curso;
import com.example.exemplospringdatajpa.repositories.CategoriaCursoRepository;
import com.example.exemplospringdatajpa.repositories.CursoRepository;

@SpringBootApplication
public class ExemplospringdatajpaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository) {
		return args -> {

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplospringdatajpaApplication.class, args);
	}

}
