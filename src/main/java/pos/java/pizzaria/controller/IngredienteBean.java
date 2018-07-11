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
import pos.java.pizzaria.model.Ingrediente;
import pos.java.pizzaria.service.IngredienteService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class IngredienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Ingrediente ingrediente = new Ingrediente();
    List<Ingrediente> todosIngredientes = new ArrayList<>();

    @Autowired
    IngredienteService ingredienteService;

    public void consultar() {
        this.todosIngredientes = ingredienteService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        ingredienteService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Ingrediente removido com sucesso!"));

    }

    public String editar(Ingrediente ingrediente) {

        this.ingrediente = ingrediente;
        return "CadastraIngrediente.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        ingredienteService.save(this.ingrediente);
        this.ingrediente = new Ingrediente();
        context.addMessage(null, new FacesMessage(
                "Ingrediente cadastrado com sucesso!"));

    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<Ingrediente> getTodosIngredientes() {
        return todosIngredientes;
    }

}
