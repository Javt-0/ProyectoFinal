/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.CarritoDao;
import com.proyecto.dominio.Carrito;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
@Stateless
public class CarritoServiceImpl implements CarritoService{
    @Inject 
    private CarritoDao carritoDao;
    
    @Override        
    public List<Carrito> listarCarrito(){
        return carritoDao.findAllCarrito();
    }
    
    @Override
    public Carrito buscarPorId(Carrito c){
        return carritoDao.findCarritoById(c);
    }
    
    @Override
    public void insertarCarrito(Carrito c){
        carritoDao.insertCarrito(c);
    }
    
    @Override
    public void actualizarCarrito(Carrito c){
        carritoDao.updateCarrito(c);
    }
    
    @Override
    public void eliminarCarrito(Carrito c){
        carritoDao.deleteCarrito(c);
    }
}
