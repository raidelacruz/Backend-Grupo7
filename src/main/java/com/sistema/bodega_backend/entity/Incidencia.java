package com.sistema.bodega_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "incidencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aula;       
    private String equipo;     
    private String tipo;       
    
    @Column(length = 500)
    private String descripcion; 
    
    private String estado;      // examen pide "PENDIENTE", "EN_PROCESO", "ATENDIDA"
    private LocalDateTime fechaReporte;

    
    @PrePersist
    protected void onCreate() {
        this.fechaReporte = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = "PENDIENTE"; // Toda incidencia inicia abierta por defecto
        }
    }
}