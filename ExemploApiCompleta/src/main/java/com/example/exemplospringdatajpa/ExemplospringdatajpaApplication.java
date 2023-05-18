package com.example.exemplospringdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.exemplospringdatajpa.models.CategoriaCurso;
import com.example.exemplospringdatajpa.models.Curso;
import com.example.exemplospringdatajpa.models.Usuario;
import com.example.exemplospringdatajpa.repositories.CategoriaCursoRepository;
import com.example.exemplospringdatajpa.repositories.CursoRepository;
import com.example.exemplospringdatajpa.repositories.UsuarioRepository;
import com.example.exemplospringdatajpa.services.security.JwtService;

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
		ConfigurableApplicationContext contexto = SpringApplication.run(ExemplospringdatajpaApplication.class);
		JwtService service = contexto.getBean(JwtService.class);
		UsuarioRepository usuarioRepository = contexto.getBean(UsuarioRepository.class);
		PasswordEncoder passwordEncoder = contexto.getBean(PasswordEncoder.class);

		Usuario usuario = new Usuario(0, "Rafael", "rafael.moreno@facens.br", passwordEncoder.encode("123"),
				"Administrador");
		String token = service.gerarToken(usuario);
		System.out.println(token);
		boolean isValid = service.validarToken(token);
		System.out.println("Token válido? " + isValid);
		System.out.println("Usuário: " + service.obterLoginUsuario(token));

		usuarioRepository.save(usuario);
	}

}
