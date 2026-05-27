package com.sistema.bodega_backend.service;

import com.sistema.bodega_backend.entity.Pedido;
import com.sistema.bodega_backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Listar todos los pedidos (Requerimiento: GET /api/pedidos)
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    // Guardar un pedido
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}