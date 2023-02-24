package com.aula1.aula1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aula1.aula1.model.NumeroDTO;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@SpringBootApplication
@RestController
public class Aula1Application {

	@GetMapping("/olamundo")
	public String olaMundo() {
		return "Olá Mundo";
	}

	@GetMapping(value = "/teste")
	public String exemploParametro(@RequestParam(value = "p") String parametro) {
		return "O parâmetro digitado é: " + parametro;
	}

	@GetMapping(value = "/teste2/{p}")
	public String exemploParametro2(@PathVariable("p") String parametro) {
		System.out.println("**** Entrou no método teste2 *****");
		return "O parâmetro digitado é: " + parametro;
	}

	@PostMapping(value = "/exemploPost")
	public Double postMethodName(@RequestBody NumeroDTO numero) {
		return numero.getNumero1() + numero.getNumero2();
	}

	@PutMapping(value = "exemploPut/{id}")
	public String putMethodName(@PathVariable String id,
			@RequestBody NumeroDTO numero) {
		return "Exemplo de PUT";
	}

	@DeleteMapping(value = "exemploDelete/{id}")
	public String delete(@PathVariable("id") long id) {
		return "Exemplo delete";
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula1Application.class, args);
	}

}
