/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author leonam
 */
@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

    private int registro;
    private String login;
    private char[] senha = new char[10];

    public Funcionario() {

    }

    public Funcionario(int registro, String login, String nome) {
        super(nome);
        this.registro = registro;
        this.login = login;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }
    
    

}
