/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import pos.java.pizzaria.model.Pedido;
import pos.java.pizzaria.repository.PedidoRepository;
import javax.inject.Named;
import pos.java.pizzaria.service.PedidoService;

/**
 *
 * @author leonam
 */
@Named
@ViewScoped
public class ConsultaPedidosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PedidoService pedidoService;

    private List<Pedido> pedidos = new ArrayList();

    public void consultar() {
        this.pedidos = pedidoService.findAll();

    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

}
