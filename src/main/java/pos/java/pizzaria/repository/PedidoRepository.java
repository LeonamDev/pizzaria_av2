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
import pos.java.pizzaria.model.Pedido;

/**
 *
 * @author leonam
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select p from Pedido p where p.cliente.nome = ?1")
    List<Pedido> findByClienteNome(String clienteNome);

}
