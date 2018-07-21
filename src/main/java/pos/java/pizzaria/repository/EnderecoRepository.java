/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pos.java.pizzaria.model.Endereco;

/**
 *
 * @author leonam
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
  @Query("select e from Endereco e where e.cliente.id = ?1")
  List<Endereco> findByCliente(Long cliente_id);

}
