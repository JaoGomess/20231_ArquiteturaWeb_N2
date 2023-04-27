package com.example.exemplospringdatajpa.exceptions;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(String erro) {
        super(erro);
    }
}
