package com.sistema.bodega_backend.service;

import com.sistema.bodega_backend.entity.Incidencia;
import com.sistema.bodega_backend.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    // Listar todas 
    public List<Incidencia> obtenerTodas() {
        return incidenciaRepository.findAll();
    }

    // Guardar nueva incidencia 
    public Incidencia guardar(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    // Contar total de registros 
    public long contarTotal() {
        return incidenciaRepository.count();
    }

    // Cambiar estado 
    public Optional<Incidencia> cambiarEstado(Long id, String nuevoEstado) {
        return incidenciaRepository.findById(id).map(incidencia -> {
            incidencia.setEstado(nuevoEstado.toUpperCase()); // Asegura mayúsculas
            return incidenciaRepository.save(incidencia);
        });
    }
}