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
import javax.persistence.Table;

/**
 *
 * @author leonam
 */
@Entity
@Table(name = "motoboy")
public class Motoboy extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String moto_placa;

    @OneToMany(mappedBy = "entregador")
    private List<Pedido> pedidos = new ArrayList<>();

    public Motoboy() {

    }

    public Motoboy(String moto_placa, int registro, String login, String nome) {
        super(registro, login, nome);
        this.moto_placa = moto_placa;
    }

    public String getMoto_placa() {
        return moto_placa;
    }

    public void setMoto_placa(String moto_placa) {
        this.moto_placa = moto_placa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
