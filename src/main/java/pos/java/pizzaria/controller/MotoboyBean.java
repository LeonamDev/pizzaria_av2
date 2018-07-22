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
import pos.java.pizzaria.model.Motoboy;
import pos.java.pizzaria.service.MotoboyService;

/**
 *
 * @author leonam
 */
@ManagedBean
public class MotoboyBean implements Serializable {

    Motoboy motoboy = new Motoboy();
    List<Motoboy> todosMotoboys = new ArrayList();

    @Autowired
    MotoboyService motoboyService;

    public void consultar() {
        this.todosMotoboys = motoboyService.findAll();
    }

    public void remover(Long id) {
        FacesContext context = FacesContext.getCurrentInstance();
        motoboyService.remove(id);
        consultar();
        context.addMessage(null, new FacesMessage(
                "Motoboy removido com sucesso!"));
    }

    public String editar(Motoboy motoboy) {

        this.motoboy = motoboy;
        return "CadastraMotoboy.xhtml";
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.motoboy.setSenha(new BCryptPasswordEncoder().encode(this.motoboy.getSenha()));
        motoboyService.save(this.motoboy);
        this.motoboy = new Motoboy();
        context.addMessage(null, new FacesMessage(
                "Motoboy cadastrado com sucesso!"));

    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public void setMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
    }

    public List<Motoboy> getTodosMotoboys() {
        return todosMotoboys;
    }

}
