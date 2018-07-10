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
import pos.java.pizzaria.model.Ingrediente;
import pos.java.pizzaria.repository.IngredienteRepository;

/**
 *
 * @author leonam
 */
@Service
public class IngredienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Optional<Ingrediente> findById(Long id) {

        return ingredienteRepository.findById(id);

    }

    public List<Ingrediente> findAll() {

        return ingredienteRepository.findAll();

    }

    public void save(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);

    }

    public void remove(Long id) {
        ingredienteRepository.deleteById(id);
    }

}
