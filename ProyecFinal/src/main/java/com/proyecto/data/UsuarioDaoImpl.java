/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author jonat
 */
@Stateless
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
        //try {
//            UserTransaction utx = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            //utx.begin();
            //EntityManager em = getEntityManager(); // obtener una instancia del EntityManager
            em.persist(u); // insertar una nueva entidad en la base de datos
            //utx.commit(); // confirmar la transacción
        //} catch (Exception e) {
        //    throw new RuntimeException(e);
        //}
        
    }
    
    @Override
    public void updateUsuarios(Usuarios u){
        em.merge(u);
    }
    
    @Override
    public void deleteUsuarios(Usuarios u){
        em.remove(em.merge(u));
    }
    
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ProyectoFinalPU"); // nombre de la unidad de persistencia en persistence.xml
        }

        return emf.createEntityManager();
    }
}
