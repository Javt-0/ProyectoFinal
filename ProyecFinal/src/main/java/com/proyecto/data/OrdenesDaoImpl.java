/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Ordenes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
public class OrdenesDaoImpl implements OrdenesDao{
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Ordenes> findAllOrdenes(){
        return em.createNamedQuery("Ordenes.findAll").getResultList();
    }
    
    @Override
    public Ordenes findOrdenesById(Ordenes o){
        return em.find(Ordenes.class, o.getId());
    }
    
    @Override
    public Ordenes findOrdenesByFecha(Ordenes o){
        return em.find(Ordenes.class, o.getFecha());
    }
    
    @Override
    public void insertOrdenes(Ordenes o){
        em.persist(o);
    }
    
    @Override
    public void updateOrdenes(Ordenes o){
        em.merge(o);
    }
    
    @Override
    public void deleteOrdenes(Ordenes o){
        em.remove(o);
    }
}
