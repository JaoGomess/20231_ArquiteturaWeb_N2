package com.example.exemplospringdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exemplospringdatajpa.model.CategoriaCurso;
import com.example.exemplospringdatajpa.model.Curso;
import com.example.exemplospringdatajpa.repository.CategoriaCursoRepository;
import com.example.exemplospringdatajpa.repository.CursoRepository;

@SpringBootApplication
public class ExemplospringdatajpaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository) {
		return args -> {
			System.out.println("*** INSERINDO CATEGORIA E CURSO ***");
			CategoriaCurso categ1 = new CategoriaCurso((long) 0, "Categoria 1", null);
			categ1 = categoriaRepository.save(categ1);

			Curso c1 = new Curso((long) 0, "ADS", 2000, categ1);
			Curso c2 = new Curso((long) 0, "JD", 2100, categ1);
			c1 = cursoRepository.save(c1);
			c2 = cursoRepository.save(c2);

			System.out.println("*** LISTAR TODOS OS CURSOS ***");
			List<Curso> cursos = cursoRepository.findAll();
			cursos.forEach(c -> {
				System.out.println(c);
			});

			System.out.println("*** LISTAR POR NOME DO CURSO ***");
			cursos = cursoRepository.findByNomeLike("A%");
			cursos.forEach(c -> {
				System.out.println(c);
			});

			System.out.println("*** LISTAR CATEGORIA 1 ***");
			categ1 = categoriaRepository.findCategoriaCursoFetchCursos((long) 1);
			System.out.println(categ1 + "cursos: " + categ1.getCursos());

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplospringdatajpaApplication.class, args);
	}

}
