/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Videojuegos;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface VideojuegosDao {
    public List<Videojuegos> findAllVideojuegos();
    
    public Videojuegos findVideojuegosById(Videojuegos v);
    
    public Videojuegos findVideojuegosByNombre(Videojuegos v);
    
    public Videojuegos findVideojuegosByStock(Videojuegos v);
    
    public void insertVideojuegos(Videojuegos v);

    public void updateVideojuegos(Videojuegos v);
    
    public void deleteVideojuegos(Videojuegos v);
}