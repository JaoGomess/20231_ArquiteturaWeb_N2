package com.example.exemplojdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.exemplojdbc.model.Usuario;

@Repository
public class UsuarioRepository {
    private static String SELECT_ALL = "SELECT * FROM USUARIO";
    private static String INSERT = "INSERT INTO USUARIO (nome,email,senha) VALUES(?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario inserir(Usuario usu) {
        jdbcTemplate.update(INSERT, new Object[] {
                usu.getNome(), usu.getEmail(), usu.getSenha()
        });
        return usu;
    }

    public List<Usuario> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL,
                Usuario.getRowMapper());
    }
}
