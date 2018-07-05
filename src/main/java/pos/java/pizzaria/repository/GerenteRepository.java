/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pos.java.pizzaria.model.Gerente;

/**
 *
 * @author leonam
 */
@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long>{
    
}
