package com.sistema.bodega_backend.controller;

import com.sistema.bodega_backend.entity.Tarea;
import com.sistema.bodega_backend.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Listar todas
    @GetMapping
    public List<Tarea> listar() {
        return tareaService.obtenerTodas();
    }

    //Crear nueva tarea
    @PostMapping
    public Tarea registrar(@RequestBody Tarea tarea) {
        return tareaService.guardar(tarea);
    }

    // Editar tarea (Logro destacado)
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> modificar(@PathVariable Long id, @RequestBody Tarea tarea) {
        return tareaService.actualizar(id, tarea)
                .map(tareaEditada -> ResponseEntity.ok().body(tareaEditada))
                .orElse(ResponseEntity.notFound().build());
    }

    //Eliminar tarea (Logro destacado)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (tareaService.eliminar(id)) {
            return ResponseEntity.ok().build(); // Retorna 200 si eliminó con éxito
        }
        return ResponseEntity.notFound().build(); // Retorna 404 si el ID no existía
    }
}