package com.sistema.bodega_backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="pedidos")

public class Pedido {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String estudiante;
private LocalDateTime fecha;
private String estado;
private double total;
//constructores 

public Pedido() {
}

public Pedido(Long id, String estudiante, LocalDateTime fecha, String estado, double total) {
    this.id = id;
    this.estudiante = estudiante;
    this.fecha = fecha;
    this.estado = estado;
    this.total = total;
}
@PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
        this.estado = "PENDIENTE"; //cuando un pedido se crae automaticametne es pendiente
    }

}

