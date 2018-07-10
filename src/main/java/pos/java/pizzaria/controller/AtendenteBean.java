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
import pos.java.pizzaria.service.AtendenteService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class AtendenteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Atendente atendente = new Atendente();
    List<Atendente> todosAtendentes = new ArrayList<>();

    @Autowired
    AtendenteService atendenteService;

    public void consultar() {
        this.todosAtendentes = atendenteService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        atendenteService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Atendente removido com sucesso!"));

    }

    public String editar(Atendente atendente) {

        this.atendente = atendente;
        return "CadastraAtendente.xhtml";

    }

    public void salvar() {

        FacesContext context = FacesContext.getCurrentInstance();
        atendenteService.save(this.atendente);
        this.atendente = new Atendente();
        context.addMessage(null, new FacesMessage(
                "Atendente cadastrado com sucesso!"));

    }

    public List<Atendente> getTodosAtendentes() {
        return todosAtendentes;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

}
