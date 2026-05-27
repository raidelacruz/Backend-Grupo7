package com.sistema.bodega_backend.controller;

import com.sistema.bodega_backend.entity.Curso;
import com.sistema.bodega_backend.service.CursoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id);
    }
}