/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dominio.Valoraciones;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface ValoracionesService {
    public List<Valoraciones> listarValoraciones();
    
    public Valoraciones buscarPorId(Valoraciones v);
    
    public Valoraciones buscarPorComentario(Valoraciones v);
    
    public  Valoraciones  buscarPorPuntuacion(Valoraciones v);
    
    public void insertarValoraciones(Valoraciones v);

    public void actualizarValoraciones(Valoraciones v);
    
    public void eliminarValoraciones(Valoraciones v);
}
