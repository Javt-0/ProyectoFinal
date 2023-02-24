/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.VideojuegosDao;
import com.proyecto.dominio.Videojuegos;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
public class VideojuegoServiceImpl implements VideojuegoService{
    @Inject 
    private VideojuegosDao videojuegosDao;
    
    @Override
    public List<Videojuegos> listarVideojuegos(){
        return videojuegosDao.findAllVideojuegos();
    }
    
    @Override
    public Videojuegos buscarPorId(Videojuegos v){
        return videojuegosDao.findVideojuegosById(v);
    }
    
    @Override
    public Videojuegos buscarPorNombre(Videojuegos v){
        return videojuegosDao.findVideojuegosByNombre(v);
    }
    
    @Override
    public Videojuegos buscarPorStock(Videojuegos v){
        return videojuegosDao.findVideojuegosByStock(v);
    }
    
    @Override
    public void insertarVideojuegos(Videojuegos v){
        videojuegosDao.insertVideojuegos(v);
    }
    
    @Override
    public void actualizarVideojuegos(Videojuegos v){
        videojuegosDao.updateVideojuegos(v);
    }
    
    @Override
    public void eliminarVideojuegos(Videojuegos v){
        videojuegosDao.deleteVideojuegos(v);
    }
}
