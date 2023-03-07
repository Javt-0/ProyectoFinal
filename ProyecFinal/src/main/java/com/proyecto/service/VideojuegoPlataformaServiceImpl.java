/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.VideojuegoPlataformaDao;
import com.proyecto.dominio.VideojuegoPlataforma;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
@Stateless
public class VideojuegoPlataformaServiceImpl implements VideojuegoPlataformaService{
    @Inject 
    private VideojuegoPlataformaDao videojuegoPlataformaDao;
    
    @Override
    public List<VideojuegoPlataforma> listarVideojuegoPlataforma(){
        return videojuegoPlataformaDao.findAllVideojuegoPlataforma();
    }
    
    @Override
    public  VideojuegoPlataforma  buscarPorById(VideojuegoPlataforma vp){
        return videojuegoPlataformaDao.findVideojuegoPlataformaById(vp);
    }
    
    @Override
    public void insertarVideojuegoPlataforma(VideojuegoPlataforma vp){
        videojuegoPlataformaDao.insertVideojuegoPlataforma(vp);
    }
    
    @Override
    public void actualizarVideojuegoPlataforma(VideojuegoPlataforma vp){
        videojuegoPlataformaDao.updateVideojuegoPlataforma(vp);
    }
    
    @Override
    public void eliminarVideojuegoPlataforma(VideojuegoPlataforma vp){
        videojuegoPlataformaDao.deleteVideojuegoPlataforma(vp);
    }
}
