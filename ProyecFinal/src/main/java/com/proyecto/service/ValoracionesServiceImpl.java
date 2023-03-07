/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.ValoracionesDao;
import com.proyecto.dominio.Valoraciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
@Stateless
public class ValoracionesServiceImpl implements ValoracionesService{
    @Inject
    private ValoracionesDao valoracionesDao;
    
    @Override
    public List<Valoraciones> listarValoraciones(){
        return valoracionesDao.findAllValoraciones();
    }
    
    @Override
    public Valoraciones buscarPorId(Valoraciones v){
        return valoracionesDao.findValoracionesById(v);
    }
    
    @Override
    public Valoraciones buscarPorComentario(Valoraciones v){
        return valoracionesDao.findValoracionesByComentario(v);
    }
    
    @Override
    public  Valoraciones  buscarPorPuntuacion(Valoraciones v){
        return valoracionesDao.findValoracionesByPuntuacion(v);
    }
    
    @Override
    public void insertarValoraciones(Valoraciones v){
        valoracionesDao.insertValoraciones(v);
    }
    
    @Override
    public void actualizarValoraciones(Valoraciones v){
        valoracionesDao.updateValoraciones(v);
    }
    
    @Override
    public void eliminarValoraciones(Valoraciones v){
        valoracionesDao.deleteValoraciones(v);
    }
}