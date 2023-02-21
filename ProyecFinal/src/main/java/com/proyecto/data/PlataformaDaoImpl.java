/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Plataforma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
public class PlataformaDaoImpl implements PlataformaDao{
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Plataforma> findAllPlataforma(){
        return em.createNamedQuery("Plataforma.findAll").getResultList();
    }
    
    @Override
    public Plataforma findPlataformafindById(Plataforma p){
        return em.find(Plataforma.class, p.getId());
    }
    
    @Override
    public Plataforma findPlataformaByNombre(Plataforma p){
        return em.find(Plataforma.class, p.getNombre());
    }
    
    @Override
    public void insertPlataforma(Plataforma p){
        em.persist(p);
    }
    
    @Override
    public void updatePlataforma(Plataforma p){
        em.merge(p);
    }
    
    @Override
    public void deletePlataforma(Plataforma p){
        em.remove(p);
    }
}
