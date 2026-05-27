package com.sistema.bodega_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.bodega_backend.entity.Producto;
import com.sistema.bodega_backend.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired //aca se el repositorio usando inyecto de dependencias
    private ProductoRepository productoRepository;
    // Lógica para obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
    //logica para guardar o actualizar un producto
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> buscarPorId(long id){
        return productoRepository.findById(id);
    }
}
