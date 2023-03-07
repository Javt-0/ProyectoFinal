/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dominio.Carrito;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface CarritoService {
    public List<Carrito> listarCarrito();
    
    public Carrito buscarPorId(Carrito c);
    
    public void insertarCarrito(Carrito c);

    public void actualizarCarrito(Carrito c);
    
    public void eliminarCarrito(Carrito c);
}
