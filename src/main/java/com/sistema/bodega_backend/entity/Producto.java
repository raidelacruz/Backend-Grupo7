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
    private String categoria;
    private double precio;
    private Integer stock;

//Constructores
    public Producto(){
    }
    public Producto(long id,String nombre,double precio,Integer stock){
        this.id=id;
        this.nombre = nombre;
        this.precio=precio;
        this.stock=stock;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}
