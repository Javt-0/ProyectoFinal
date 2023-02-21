/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Carrito;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface CarritoDao {
    public List<Carrito> findAllCarrito();
    
    public Carrito findCarritoById(Carrito c);
    
    public void insertCarrito(Carrito c);

    public void updateCarrito(Carrito c);
    
    public void deleteCarrito(Carrito c);
}
