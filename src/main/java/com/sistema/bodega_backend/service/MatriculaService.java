package com.sistema.bodega_backend.service;

import com.sistema.bodega_backend.entity.Curso;
import com.sistema.bodega_backend.entity.Matricula;
import com.sistema.bodega_backend.repository.CursoRepository;
import com.sistema.bodega_backend.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final CursoRepository cursoRepository; 

    public MatriculaService(MatriculaRepository matriculaRepository, CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.cursoRepository = cursoRepository;
    }

    public Matricula registrarMatricula(Matricula matricula) {
        Curso curso = cursoRepository.findById(matricula.getCurso().getId()).orElse(null);
        
        if (curso != null && curso.getVacantes() > 0) {
            curso.setVacantes(curso.getVacantes() - 1); 
            cursoRepository.save(curso);               
            matricula.setCurso(curso);
            return matriculaRepository.save(matricula); 
        }
        return null;
    }
}