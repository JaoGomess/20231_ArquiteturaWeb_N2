package com.example.exemplojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exemplojpa.model.Curso;
import com.example.exemplojpa.repository.CursoRepository;

@SpringBootApplication
public class ExemplojpaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository) {
		return args -> {
			Curso c1 = new Curso((long) 0, "ADS", 2000);
			Curso c2 = new Curso((long) 0, "JD", 2100);
			cursoRepository.inserir(c1);
			cursoRepository.inserir(c2);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplojpaApplication.class, args);
	}

}
