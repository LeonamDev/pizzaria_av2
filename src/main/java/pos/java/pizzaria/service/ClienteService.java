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
import pos.java.pizzaria.model.Cliente;
import pos.java.pizzaria.repository.ClienteRepository;

/**
 *
 * @author leonam
 */
@Service
public class ClienteService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> findById(Long id) {

        return clienteRepository.findById(id);

    }

    public List<Cliente> findAll() {

        return clienteRepository.findAll();

    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);

    }

    public void remove(Long id) {
        clienteRepository.deleteById(id);
    }

}
