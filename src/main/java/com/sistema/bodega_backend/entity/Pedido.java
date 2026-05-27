package com.sistema.bodega_backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pedidos")

public class Pedido {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String estudiante;
private LocalDateTime fecha;
private String estado;
private double total;

@PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
        this.estado = "PENDIENTE"; //cuando un pedido se crae automaticametne es pendiente
    }

}

