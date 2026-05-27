package com.sistema.bodega_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.bodega_backend.entity.Producto;
import com.sistema.bodega_backend.service.ProductoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/productos")//la URL BASE DEL ENDPOINT NO OLVIDAR!!!
@CrossOrigin(origins="*")//permite que se conecte al front sin bloqueos de cors
public class ProductoController {
    //conectamos el controlador  con el servicio 
    @Autowired
    private ProductoService productoService;

   // Endpoint para LISTAR (GET http://localhost:8080/api/productos)
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.obtenerTodos();
    }

    // Endpoint para CREAR (POST http://localhost:8080/api/productos)
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id){
        return productoService.buscarPorId(id)
        .map(producto->ResponseEntity.ok().body(producto))
        .orElse(ResponseEntity.notFound().build());
    }

}
    
