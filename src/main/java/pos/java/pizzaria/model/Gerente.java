/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author leonam
 */
@Entity
@Table(name = "gerente")
public class Gerente extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

}
