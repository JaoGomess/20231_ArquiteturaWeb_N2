package com.example.exemplospringdatajpa.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiError {
    @Getter
    private List<String> errors;

    public ApiError(String erro) {
        this.errors = Arrays.asList(erro);
    }
}
