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
import pos.java.pizzaria.model.Atendente;
import pos.java.pizzaria.model.Categoria;
import pos.java.pizzaria.repository.CategoriaRepository;

/**
 *
 * @author leonam
 */
@Service
public class CategoriaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Optional<Categoria> findById(Long id) {

        return categoriaRepository.findById(id);

    }

    public List<Categoria> findAll() {

        return categoriaRepository.findAll();

    }

    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);

    }

    public void remove(Long id) {
        categoriaRepository.deleteById(id);
    }

}
