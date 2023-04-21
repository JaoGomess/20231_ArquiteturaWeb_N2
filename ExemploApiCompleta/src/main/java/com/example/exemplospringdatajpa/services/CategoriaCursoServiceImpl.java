package com.example.exemplospringdatajpa.services;

import org.springframework.stereotype.Service;

import com.example.exemplospringdatajpa.dtos.CategoriaCursoDTO;
import com.example.exemplospringdatajpa.models.CategoriaCurso;
import com.example.exemplospringdatajpa.repositories.CategoriaCursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaCursoServiceImpl implements CategoriaCursoService {
    private final CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public Long inserir(CategoriaCursoDTO dto) {
        CategoriaCurso categ = new CategoriaCurso();
        categ.setNome(dto.getNome());
        CategoriaCurso categAdd = categoriaCursoRepository.save(categ);
        return categAdd.getId();
    }

}
