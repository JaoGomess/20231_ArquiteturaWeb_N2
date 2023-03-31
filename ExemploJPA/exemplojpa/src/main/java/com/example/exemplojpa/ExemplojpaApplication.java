package com.example.exemplojpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exemplojpa.model.CategoriaCurso;
import com.example.exemplojpa.model.Curso;
import com.example.exemplojpa.repository.CategoriaCursoRepository;
import com.example.exemplojpa.repository.CursoRepository;

@SpringBootApplication
public class ExemplojpaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaCursoRepository) {
		return args -> {
			System.out.println("*** INSERINDO CURSO ***");
			Curso c1 = new Curso((long) 0, "ADS", 2000);
			Curso c2 = new Curso((long) 0, "JD", 2100);
			cursoRepository.inserir(c1);
			cursoRepository.inserir(c2);

			System.out.println("*** INSERINDO CATEGORIA ***");
			categoriaCursoRepository.inserir(
					new CategoriaCurso((long) 0, "Tecnólogo", null));
			CategoriaCurso categ = categoriaCursoRepository
					.obterTodos().get(0);

			System.out.println("*** EDITANDO CURSO ***");
			c1 = cursoRepository.obterPorId(1);
			c1.setNome("Análise e Desenvolvimento de Sistemas");
			c1.setCategoriaCurso(categ);
			cursoRepository.editar(c1);

			System.out.println("*** LISTAR TODOS CURSOS ***");
			List<Curso> cursos = cursoRepository.obterTodos();
			for (Curso c : cursos) {
				System.out.println(c.getNome());
			}

			System.out.println("*** OBTER POR NOME ***");
			cursos = cursoRepository.obterPorNome("Análise%");
			for (Curso c : cursos) {
				System.out.println(c.getNome());
			}

			System.out.println("*** EXCLUIR CURSO ***");
			cursoRepository.excluir(2);

			System.out.println("*** MOSTRAR TODOS CURSOS ***");
			cursos = cursoRepository.obterTodos();
			for (Curso c : cursos) {
				System.out.println(c.getNome());
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplojpaApplication.class, args);
	}

}
