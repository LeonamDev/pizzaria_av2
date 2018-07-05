/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.model;

import java.io.Serializable;
import javax.persistence.Entity;
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

    @OneToOne(mappedBy = "atendente")
    private Pedido pedido;

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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
