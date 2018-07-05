/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.java.pizzaria.service;

import java.util.List;

/**
 *
 * @author leonam
 */
public interface GenericService<T> {
    
    
    public void save();
    public T find(Long id);
    public void update();
    public void delete();
    public List<T> findAll();
    
    
}
