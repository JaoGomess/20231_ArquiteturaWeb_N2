package com.example.exemplospringdatajpa.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exemplospringdatajpa.exceptions.ApiError;
import com.example.exemplospringdatajpa.exceptions.RegraNegocioException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    public ApiError handlerRegraNegocioException(
            RegraNegocioException ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ApiError handlerConstraintViolationException(
            ConstraintViolationException ex) {
        List<String> erros = ex.getConstraintViolations()
                .stream()
                .map(erro -> erro.getMessage())
                .collect(Collectors.toList());
        return new ApiError(erros);
    }
}
