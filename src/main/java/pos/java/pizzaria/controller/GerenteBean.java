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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pos.java.pizzaria.model.Gerente;
import pos.java.pizzaria.model.Role;
import pos.java.pizzaria.repository.RoleRepository;
import pos.java.pizzaria.service.GerenteService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class GerenteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    Gerente gerente = new Gerente();
    List<Gerente> todosGerentes = new ArrayList<>();

    @Autowired
    GerenteService gerenteService;
    @Autowired
    RoleRepository roleRepository;

    public void consultar() {
        this.todosGerentes = gerenteService.findAll();

    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        gerenteService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Gerente removido com sucesso!"));

    }

    public String editar(Gerente gerente) {

        this.gerente = gerente;
        return "CadastraGerente.xhtml";

    }

    public void salvar() {
        Role atendenteRole = roleRepository.findByRoleNome("ROLE_GERENTE");

        FacesContext context = FacesContext.getCurrentInstance();
        this.gerente.getRoles().add(atendenteRole);
        gerenteService.save(this.gerente);
        this.gerente = new Gerente();
        context.addMessage(null, new FacesMessage(
                "Gerente cadastrado com sucesso!"));

    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Gerente> getTodosGerentes() {
        return todosGerentes;
    }

}
