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
import pos.java.pizzaria.model.Gerente;
import pos.java.pizzaria.repository.GerenteRepository;

/**
 *
 * @author leonam
 */
@Service
public class GerenteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private GerenteRepository gerenteRepository;

    public Optional<Gerente> findById(Long id) {

        return gerenteRepository.findById(id);

    }

    public List<Gerente> findAll() {

        return gerenteRepository.findAll();

    }

}
