package com.sistema.bodega_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")//asi se llamara la tabla en mysql
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrementable en MySQL para los id´s
    private Long id;
    private String nombre;
    private double precio;
    private Integer stock;
    
}
