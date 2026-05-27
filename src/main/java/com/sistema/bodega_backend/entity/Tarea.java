package com.sistema.bodega_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String curso;
    private LocalDate fechaEntrega;
    private String estado;     
    private String prioridad;   

    @PrePersist
    protected void onCreate() {
        if (this.estado == null) {
            this.estado = "PENDIENTE"; // Por defecto arranca pendiente
        }
    }
}