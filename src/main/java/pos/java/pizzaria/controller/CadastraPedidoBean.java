/*
 * Copyright 2018 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pos.java.pizzaria.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import pos.java.pizzaria.model.Atendente;
import pos.java.pizzaria.model.Cliente;
import pos.java.pizzaria.model.Motoboy;
import pos.java.pizzaria.model.Pedido;
import pos.java.pizzaria.model.Produto;
import pos.java.pizzaria.model.TipoStatus;
import pos.java.pizzaria.service.AtendenteService;
import pos.java.pizzaria.service.ClienteService;
import pos.java.pizzaria.service.MotoboyService;
import pos.java.pizzaria.service.PedidoService;
import pos.java.pizzaria.service.ProdutoService;

/**
 *
 * @author leonam
 */
@ManagedBean
@ViewScoped
public class CadastraPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pedido pedido = new Pedido();
    private List<Cliente> todosClientes;
    private List<Atendente> todosAtendentes;
    private List<Motoboy> todosMotoboys;
    private List<Produto> todosProdutos;

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AtendenteService atendenteService;
    @Autowired
    private MotoboyService motoboyService;
    @Autowired
    private ProdutoService produtoService;

    public void prepararCadastro() {

        this.todosClientes = clienteService.findAll();
        //  this.todosAtendentes = atendenteService.findAll();
        this.todosMotoboys = motoboyService.findAll();
        this.todosProdutos = produtoService.findAll();

    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedido.setData(new java.sql.Date(System.currentTimeMillis()));
        this.pedido.setHora(new java.sql.Timestamp(System.currentTimeMillis()));
        pedidoService.save(this.pedido);
        this.pedido = new Pedido();
        context.addMessage(null, new FacesMessage(
                "Pedido cadastrado com sucesso!"));
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> getTodosClientes() {
        return todosClientes;
    }

    public void setTodosClientes(List<Cliente> todosClientes) {
        this.todosClientes = todosClientes;
    }

    public List<Atendente> getTodosAtendentes() {
        return todosAtendentes;
    }

    public void setTodosAtendentes(List<Atendente> todosAtendentes) {
        this.todosAtendentes = todosAtendentes;
    }

    public List<Motoboy> getTodosMotoboys() {
        return todosMotoboys;
    }

    public void setTodosMotoboys(List<Motoboy> todosMotoboys) {
        this.todosMotoboys = todosMotoboys;
    }

    public List<Produto> getTodosProdutos() {
        return todosProdutos;
    }

    public void setTodosProdutos(List<Produto> todosProdutos) {
        this.todosProdutos = todosProdutos;
    }

    public PedidoService getPedidoService() {
        return pedidoService;
    }

    public void setPedidoService(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public AtendenteService getAtendenteService() {
        return atendenteService;
    }

    public void setAtendenteService(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    public MotoboyService getMotoboyService() {
        return motoboyService;
    }

    public void setMotoboyService(MotoboyService motoboyService) {
        this.motoboyService = motoboyService;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public TipoStatus[] getTiposStatus() {
        return TipoStatus.values();
    }

}
