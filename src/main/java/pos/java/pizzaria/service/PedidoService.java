/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.java.pizzaria.model.Pedido;
import pos.java.pizzaria.repository.PedidoRepository;

/**
 *
 * @author leonam
 */
@Service
public class PedidoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);

    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();

    }

    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

}
