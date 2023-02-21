/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
public class UsuarioDaoImpl implements UsuarioDao{
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Usuarios> findAllUsuarios(){
        return em.createNamedQuery("Usuarios.findAll").getResultList();
    }
    
    @Override
    public Usuarios findUsuariosByEmail(Usuarios u){
        return em.find(Usuarios.class, u.getEmail());
    }
    
    @Override
    public Usuarios findUsuariosByNomUsuario(Usuarios u){
        return em.find(Usuarios.class, u.getNombreUsuario());
    }
    
    @Override
    public  Usuarios  findUsuariosById(Usuarios u){
        return em.find(Usuarios.class, u.getId());
    }
    
    @Override
    public void insertUsuarios(Usuarios u){
        em.persist(u);
    }
    
    @Override
    public void updateUsuarios(Usuarios u){
        em.merge(u);
    }
    
    @Override
    public void deleteUsuarios(Usuarios u){
        em.remove(u);
    }
}
