package com.sistema.bodega_backend.controller;

import com.sistema.bodega_backend.entity.Incidencia;
import com.sistema.bodega_backend.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    
    @GetMapping
    public List<Incidencia> listar() {
        return incidenciaService.obtenerTodas();
    }

    @GetMapping("/total")
    public long obtenerTotal() {
        return incidenciaService.contarTotal();
    }

    
    @PostMapping
    public Incidencia registrar(@RequestBody Incidencia incidencia) {
        return incidenciaService.guardar(incidencia);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Incidencia> actualizarEstado(
            @PathVariable Long id, 
            @RequestBody Map<String, String> body) {
        
        String nuevoEstado = body.get("estado");
        
        if (nuevoEstado == null) {
            return ResponseEntity.badRequest().build();
        }

        return incidenciaService.cambiarEstado(id, nuevoEstado)
                .map(incidencia -> ResponseEntity.ok().body(incidencia))
                .orElse(ResponseEntity.notFound().build());
    }
}