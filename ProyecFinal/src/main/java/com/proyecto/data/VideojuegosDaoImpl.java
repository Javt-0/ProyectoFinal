/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Videojuegos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
public class VideojuegosDaoImpl implements VideojuegosDao{
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Videojuegos> findAllUsuarios(){
        return em.createNamedQuery("Videojuegos.findAll").getResultList();
    }
    
    @Override
    public Videojuegos findVideojuegosById(Videojuegos v){
        return em.find(Videojuegos.class, v.getId());
    }
    
    @Override
    public Videojuegos findVideojuegosByNombre(Videojuegos v){
        return em.find(Videojuegos.class, v.getNombre());
    }
    
    @Override
    public Videojuegos findVideojuegosByStock(Videojuegos v){
        return em.find(Videojuegos.class, v.getStock());
    }
    
    @Override
    public void insertVideojuegos(Videojuegos v){
        
    }
    
    @Override
    public void updateVideojuegos(Videojuegos v){
        
    }
    
    @Override  
    public void deleteVideojuegos(Videojuegos v){
        
    }
}
