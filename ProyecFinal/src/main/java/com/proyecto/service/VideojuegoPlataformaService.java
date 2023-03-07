/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dominio.VideojuegoPlataforma;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface VideojuegoPlataformaService {
    public List<VideojuegoPlataforma> listarVideojuegoPlataforma();
      
    public  VideojuegoPlataforma  buscarPorById(VideojuegoPlataforma vp);
    
    public void insertarVideojuegoPlataforma(VideojuegoPlataforma vp);

    public void actualizarVideojuegoPlataforma(VideojuegoPlataforma vp);
    
    public void eliminarVideojuegoPlataforma(VideojuegoPlataforma vp);
}
