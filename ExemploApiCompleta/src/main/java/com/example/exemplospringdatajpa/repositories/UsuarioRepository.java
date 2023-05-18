package com.example.exemplospringdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exemplospringdatajpa.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
