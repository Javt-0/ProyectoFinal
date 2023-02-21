/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Plataforma;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface PlataformaDao {
    public List<Plataforma> findAllPlataforma();
    
    public Plataforma findPlataformafindById(Plataforma p);
    
    public Plataforma findPlataformaByNombre(Plataforma p);
    
    public void insertPlataforma(Plataforma p);

    public void updatePlataforma(Plataforma p);
    
    public void deletePlataforma(Plataforma p);
}
