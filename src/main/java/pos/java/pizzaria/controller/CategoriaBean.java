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
import pos.java.pizzaria.model.Atendente;
import pos.java.pizzaria.model.Categoria;
import pos.java.pizzaria.service.CategoriaService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class CategoriaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Categoria categoria = new Categoria();
    List<Categoria> todasCategorias = new ArrayList<>();

    @Autowired
    CategoriaService categoriaService;

    public void consultar() {
        this.todasCategorias = categoriaService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        categoriaService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Categoria removida com sucesso!"));

    }

    public String editar(Categoria categoria) {

        this.categoria = categoria;
        return "CadastraCategoria.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        categoriaService.save(this.categoria);
        this.categoria = new Categoria();
        context.addMessage(null, new FacesMessage(
                "Categoria cadastrada com sucesso!"));

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getTodasCategorias() {
        return todasCategorias;
    }

}
