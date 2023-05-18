package com.example.exemplospringdatajpa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.exemplospringdatajpa.dtos.AutenticacaoDTO;
import com.example.exemplospringdatajpa.dtos.TokenDTO;
import com.example.exemplospringdatajpa.exceptions.RegraNegocioException;
import com.example.exemplospringdatajpa.models.Usuario;
import com.example.exemplospringdatajpa.services.UsuarioService;
import com.example.exemplospringdatajpa.services.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UsuarioService usuarioService;
    private JwtService jwtService;

    public AuthController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping()
    public TokenDTO autenticar(@RequestBody AutenticacaoDTO autenticacao) {
        try {
            Usuario usuario = new Usuario(0, "", autenticacao.getEmail(), autenticacao.getSenha(), "");
            UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getEmail(), token);
        } catch (UsernameNotFoundException | RegraNegocioException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }
    }

}
