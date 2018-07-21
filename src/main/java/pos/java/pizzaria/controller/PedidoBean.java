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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import pos.java.pizzaria.enums.FormaPagamento;
import pos.java.pizzaria.model.Atendente;
import pos.java.pizzaria.model.Cliente;
import pos.java.pizzaria.model.Motoboy;
import pos.java.pizzaria.model.Pedido;
import pos.java.pizzaria.model.Produto;
import pos.java.pizzaria.enums.TipoStatus;
import pos.java.pizzaria.model.Endereco;
import pos.java.pizzaria.model.ProdutoPedido;
import pos.java.pizzaria.service.AtendenteService;
import pos.java.pizzaria.service.ClienteService;
import pos.java.pizzaria.service.EnderecoService;
import pos.java.pizzaria.service.MotoboyService;
import pos.java.pizzaria.service.PedidoService;
import pos.java.pizzaria.service.ProdutoService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class PedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pedido pedido = new Pedido();
    private List<Cliente> todosClientes;
    private List<Atendente> todosAtendentes;
    private List<Motoboy> todosMotoboys;
    private List<Produto> todosProdutos;
    private List<Endereco> clienteEnderecos;
    private List<ProdutoPedido> produtoPedido = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    private Produto produto = new Produto();
    private ProdutoPedido pp = new ProdutoPedido();
    private String nome;

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
    @Autowired
    private EnderecoService enderecoService;

    public void consultar() {
        this.pedidos = pedidoService.findAll();
    }

    public void consultarPeloNomeDoCliente() {
        this.pedidos.clear();
        this.pedidos = pedidoService.findByClienteNome(this.nome);

    }

    public void prepararCadastro() {

        this.todosClientes = clienteService.findAll();
        this.todosAtendentes = atendenteService.findAll();
        this.todosMotoboys = motoboyService.findAll();
        this.todosProdutos = produtoService.findAll();

    }

    public void addProdutoPedido() {
        setClienteEnderecos();
        this.pp.setProduto(this.produto);
        this.pp.setObs("ads");
        this.pp.setQuantidade(5);

        this.produtoPedido.add(this.pp);
        this.produto = new Produto();
        this.pp = new ProdutoPedido();

    }

    public void setClienteEnderecos() {

        this.clienteEnderecos = enderecoService.findEnderecoByCliente(this.pedido.getCliente().getId());
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.pedido.setData(new java.sql.Date(System.currentTimeMillis()));
        this.pedido.setHora(new java.sql.Timestamp(System.currentTimeMillis()));

        for (ProdutoPedido pedido : this.produtoPedido) {
            pedido.setPedido(this.pedido);
            this.pedido.getProdutoPedidos().add(pedido);
        }
        pedidoService.save(this.pedido);
        this.produto = new Produto();
        this.produtoPedido.clear();
        this.pedido = new Pedido();
        context.addMessage(null, new FacesMessage(
                "Pedido cadastrado com sucesso!"));
    }

    public String editar(Pedido pedido) {
        this.pedido = pedido;
        return "CadastraPedido.xhtml";
    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        pedidoService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Pedido removido com sucesso!"));
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

    public FormaPagamento[] getFormaPagamento() {
        return FormaPagamento.values();
    }

    public List<Endereco> getClienteEnderecos() {
        return clienteEnderecos;
    }

    public void setClienteEnderecos(List<Endereco> clienteEnderecos) {
        this.clienteEnderecos = clienteEnderecos;
    }

    public List<ProdutoPedido> getProdutoPedido() {
        return produtoPedido;
    }

    public void setProdutoPedido(List<ProdutoPedido> produtoPedido) {
        this.produtoPedido = produtoPedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
