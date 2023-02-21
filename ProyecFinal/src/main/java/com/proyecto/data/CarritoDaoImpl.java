/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Carrito;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
public class CarritoDaoImpl implements CarritoDao{
    
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Carrito> findAllCarrito(){
        return em.createNamedQuery("Carrito.findAll").getResultList();
    }
    
    @Override
    public Carrito findCarritoById(Carrito c){
        return em.find(Carrito.class, c.getId());
    }
    
    @Override
    public void insertCarrito(Carrito c){
        em.persist(c);
    }
    
    @Override
    public void updateCarrito(Carrito c){
        em.merge(c);
    }
    
    @Override
    public void deleteCarrito(Carrito c){
        em.remove(c);
    }
    
}
