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
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import pos.java.pizzaria.model.Motoboy;
import pos.java.pizzaria.service.MotoboyService;

/**
 *
 * @author leonam
 */
@ManagedBean
@ViewScoped
public class CadastraMotoboyBean implements Serializable {

    Motoboy motoboy = new Motoboy();

    @Autowired
    MotoboyService motoboyService;

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
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

}