/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pos.java.pizzaria.model.Pedido;

/**
 *
 * @author leonam
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
