package com.example.aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class Aula2Application {
	@Autowired
	@Qualifier("nome")
	private String nomeAplicacao;

	@Autowired
	@Qualifier("versao")
	private String versaoAplicacao;

	@GetMapping(value = "/")
	public String getNome() {
		return nomeAplicacao + " " + versaoAplicacao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula2Application.class, args);
	}

}
