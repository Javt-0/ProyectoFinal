/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Media;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
@Stateless
public class MediaDaoImpl implements MediaDao{
    
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Media> findAllMedia(){
        return em.createNamedQuery("Media.findAll").getResultList();
    }
    
    @Override
    public Media findMediaById(Media m){
        return em.find(Media.class, m.getId());
    }
    
    @Override
    public Media findMediaByUrlmedia(Media m){
        return em.find(Media.class, m.getUrlmedia());
    }
    
    @Override
    public Media findMediaByTipo(Media m){
        return em.find(Media.class, m.getTipo());
    }
    
    @Override
    public void insertMedia(Media m){
        em.persist(m);
    }
    
    @Override
    public void updateMedia(Media m){
        em.merge(m);
    }
    
    @Override
    public void deleteMedia(Media m){
        em.remove(m);
    }
}
