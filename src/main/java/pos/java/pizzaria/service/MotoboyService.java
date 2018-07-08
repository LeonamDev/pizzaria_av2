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
import pos.java.pizzaria.model.Motoboy;
import pos.java.pizzaria.repository.MotoboyRepository;

/**
 *
 * @author leonam
 */
@Service
public class MotoboyService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private MotoboyRepository motoboyRepository;

    public Optional<Motoboy> findById(Long id) {

        return motoboyRepository.findById(id);

    }

    public List<Motoboy> findAll() {

        return motoboyRepository.findAll();

    }

    public void save(Motoboy motoboy) {

        motoboyRepository.save(motoboy);

    }

}
