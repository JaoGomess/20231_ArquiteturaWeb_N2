package com.example.exemplojdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exemplojdbc.model.Usuario;
import com.example.exemplojdbc.repository.UsuarioRepository;

@SpringBootApplication
public class ExemplojdbcApplication {
	@Bean
	public CommandLineRunner init(@Autowired UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository.inserir(new Usuario(0, "Teste", "teste@teste", "123"));
			List<Usuario> listaUsuarios = usuarioRepository.obterTodos();
			listaUsuarios.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ExemplojdbcApplication.class, args);
	}

}
