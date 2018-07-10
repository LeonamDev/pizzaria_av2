/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author leonam
 */
@Entity
@Table(name = "atendente")
public class Atendente extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ramal;

    @OneToMany(mappedBy = "atendente")
     private List<Pedido> pedidos = new ArrayList<>();

    public Atendente() {

    }

    public Atendente(int ramal, int registro, String login, String nome) {
        super(registro, login, nome);
        this.ramal = ramal;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

  
}
