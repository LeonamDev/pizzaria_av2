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
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import pos.java.pizzaria.model.Produto;
import pos.java.pizzaria.service.ProdutoService;

/**
 *
 * @author leonam
 */
@Named
@ViewScoped
public class ConsultaProdutosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Produto> produtos = new ArrayList<>();

    @Autowired
    ProdutoService produtoService;

    public void consultar() {
        this.produtos = produtoService.findAll();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    

}
