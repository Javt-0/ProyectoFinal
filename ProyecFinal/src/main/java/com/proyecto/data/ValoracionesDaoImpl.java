
package com.proyecto.data;

import com.proyecto.dominio.Usuarios;
import com.proyecto.dominio.Valoraciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonat
 */
@Stateless
public class ValoracionesDaoImpl implements ValoracionesDao{
    @PersistenceContext(unitName="ProyectoFinalPU")
    EntityManager em;
    
    @Override
    public List<Valoraciones> findAllValoraciones(){
        return em.createNamedQuery("Valoraciones.findAll").getResultList();
    }
    
    @Override
    public Valoraciones findValoracionesById(Valoraciones v){
        return em.find(Valoraciones.class, v.getId());
    }
    
    @Override
    public Valoraciones findValoracionesByComentario(Valoraciones v){
        return em.find(Valoraciones.class, v.getComentario());
    }
    
    @Override
    public  Valoraciones  findValoracionesByPuntuacion(Valoraciones v){
        return em.find(Valoraciones.class, v.getPuntuacion());
    }
    
    @Override
    public void insertValoraciones(Valoraciones v){
        em.persist(v);
    }
    
    @Override
    public void updateValoraciones(Valoraciones v){
        em.merge(v);
    }
    
    @Override
    public void deleteValoraciones(Valoraciones v){
        em.remove(v);
    }
}
