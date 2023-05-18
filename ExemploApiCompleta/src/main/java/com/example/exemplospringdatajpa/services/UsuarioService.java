package com.example.exemplospringdatajpa.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.exemplospringdatajpa.dtos.UsuarioDTO;
import com.example.exemplospringdatajpa.models.Usuario;

public interface UsuarioService {
    Usuario salvar(UsuarioDTO dto);

    UsuarioDTO obterUsuarioPorId(Integer id);

    List<UsuarioDTO> obterUsuarios();

    UserDetails autenticar(Usuario usuario);
}
