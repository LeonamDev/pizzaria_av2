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
import pos.java.pizzaria.model.Categoria;
import pos.java.pizzaria.model.Ingrediente;
import pos.java.pizzaria.model.Produto;
import pos.java.pizzaria.service.CategoriaService;
import pos.java.pizzaria.service.IngredienteService;
import pos.java.pizzaria.service.ProdutoService;

/**
 *
 * @author leonam
 */
@ManagedBean
@ViewScoped
public class CadastraProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Produto produto = new Produto();
    List<Categoria> todasCategorias;
    List<Ingrediente> todosIngredientes;

    @Autowired
    ProdutoService produtoService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    IngredienteService ingredienteService;

    public void prepararCadastro() {
        this.todasCategorias = categoriaService.findAll();
        this.todosIngredientes = ingredienteService.findAll();
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        produtoService.save(this.produto);
        this.produto = new Produto();
        context.addMessage(null, new FacesMessage(
                "Produto cadastrado com sucesso!"));
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Categoria> getTodasCategorias() {
        return todasCategorias;
    }

    public List<Ingrediente> getTodosIngredientes() {
        return todosIngredientes;
    }

}
