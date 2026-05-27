package com.sistema.bodega_backend.controller;

import com.sistema.bodega_backend.entity.Pedido;
import com.sistema.bodega_backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*") // Permite la conexión con el frontend
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // 1. GET /api/pedidos -> Mostrar todos los pedidos
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.obtenerTodos();
    }

    // 2. POST /api/pedidos -> Registrar un pedido nuevo
    @PostMapping
    public Pedido registrarPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardar(pedido);
    }
}