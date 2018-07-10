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
import pos.java.pizzaria.repository.AtendenteRepository;

/**
 *
 * @author leonam
 */
@Service
public class AtendenteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private AtendenteRepository atendenteRepository;

    public Optional<Atendente> findById(Long id) {
        return atendenteRepository.findById(id);

    }

    public List<Atendente> findAll() {
        return atendenteRepository.findAll();

    }

    public void save(Atendente atendente) {
        atendenteRepository.save(atendente);

    }

    public void remove(Long id) {
        atendenteRepository.deleteById(id);
    }

}
