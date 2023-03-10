/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.VideojuegoPlataforma;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface VideojuegoPlataformaDao {
    public List<VideojuegoPlataforma> findAllVideojuegoPlataforma();
      
    public  VideojuegoPlataforma  findVideojuegoPlataformaById(VideojuegoPlataforma vp);
    
    public void insertVideojuegoPlataforma(VideojuegoPlataforma vp);

    public void updateVideojuegoPlataforma(VideojuegoPlataforma vp);
    
    public void deleteVideojuegoPlataforma(VideojuegoPlataforma vp);
}
