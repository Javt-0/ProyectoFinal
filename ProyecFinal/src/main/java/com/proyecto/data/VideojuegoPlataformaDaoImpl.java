/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.VideojuegoPlataforma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
@Stateless
public class VideojuegoPlataformaDaoImpl implements VideojuegoPlataformaDao{
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<VideojuegoPlataforma> findAllVideojuegoPlataforma(){
        return em.createNamedQuery("VideojuegoPlataforma.findAll").getResultList();
    }
    
    @Override
    public  VideojuegoPlataforma  findVideojuegoPlataformaById(VideojuegoPlataforma vp){
        return em.find(VideojuegoPlataforma.class, vp.getId());
    }
    
    @Override
    public void insertUsuarios(VideojuegoPlataforma vp){
        em.persist(vp);
    }
    
    @Override
    public void updateUsuarios(VideojuegoPlataforma vp){
        em.merge(vp);
    }
    
    @Override
    public void deleteUsuarios(VideojuegoPlataforma vp){
        em.remove(vp);
    }
}
