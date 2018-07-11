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
import pos.java.pizzaria.model.Cliente;
import pos.java.pizzaria.model.Ingrediente;
import pos.java.pizzaria.service.ClienteService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Cliente cliente = new Cliente();
    List<Cliente> todosClientes = new ArrayList<>();

    @Autowired
    ClienteService clienteService;

    public void consultar() {
        this.todosClientes = clienteService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        clienteService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Cliente removido com sucesso!"));

    }

    public String editar(Cliente cliente) {
        this.cliente = cliente;
        return "CadastraCliente.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        clienteService.save(this.cliente);
        this.cliente = new Cliente();
        context.addMessage(null, new FacesMessage(
                "Cliente cadastrado com sucesso!"));

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getTodosClientes() {
        return todosClientes;
    }

}
