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
import pos.java.pizzaria.model.Endereco;
import pos.java.pizzaria.service.ClienteService;
import pos.java.pizzaria.service.EnderecoService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class EnderecoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Endereco endereco = new Endereco();
    private List<Endereco> todosEnderecos = new ArrayList<>();
    private List<Cliente> todosClientes = new ArrayList<>();

    @Autowired
    EnderecoService enderecoService;
    @Autowired
    ClienteService clienteService;

    public void prepararCadastro() {
        this.todosClientes = clienteService.findAll();
    }

    public void consultar() {
        this.todosEnderecos = enderecoService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        enderecoService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Endereco removido com sucesso!"));

    }

    public String editar(Endereco endereco) {
        this.endereco = endereco;
        return "Cadastraendereco.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        enderecoService.save(this.endereco);
        this.endereco = new Endereco();
        context.addMessage(null, new FacesMessage(
                "Endereco cadastrado com sucesso!"));

    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getTodosEnderecos() {
        return todosEnderecos;
    }

    public List<Cliente> getTodosClientes() {
        return todosClientes;
    }

}
