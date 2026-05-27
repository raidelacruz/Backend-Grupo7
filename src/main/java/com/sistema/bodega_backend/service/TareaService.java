package com.sistema.bodega_backend.service;

import com.sistema.bodega_backend.entity.Tarea;
import com.sistema.bodega_backend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public boolean eliminar(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    
    public Optional<Tarea> actualizar(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(tareaExistente -> {
            tareaExistente.setTitulo(tareaActualizada.getTitulo());
            tareaExistente.setCurso(tareaActualizada.getCurso());
            tareaExistente.setFechaEntrega(tareaActualizada.getFechaEntrega());
            tareaExistente.setEstado(tareaActualizada.getEstado());
            tareaExistente.setPrioridad(tareaActualizada.getPrioridad());
            return tareaRepository.save(tareaExistente);
        });
    }
}