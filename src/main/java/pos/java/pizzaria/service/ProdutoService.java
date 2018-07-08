/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.java.pizzaria.model.Produto;
import pos.java.pizzaria.repository.ProdutoRepository;

/**
 *
 * @author leonam
 */
@Service
public class ProdutoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);

    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();

    }

    public void save(Produto produto) {
        produtoRepository.save(produto);
    }

}
