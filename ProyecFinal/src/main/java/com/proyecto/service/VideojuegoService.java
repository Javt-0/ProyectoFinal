/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dominio.Videojuegos;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface VideojuegoService {
    public List<Videojuegos> listarVideojuegos();
    
    public Videojuegos buscarPorId(Videojuegos v);
    
    public Videojuegos buscarPorNombre(Videojuegos v);
    
    public Videojuegos buscarPorStock(Videojuegos v);
    
    public void insertarVideojuegos(Videojuegos v);

    public void actualizarVideojuegos(Videojuegos v);
    
    public void eliminarVideojuegos(Videojuegos v);
}
