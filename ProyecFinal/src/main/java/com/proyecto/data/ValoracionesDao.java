/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Valoraciones;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface ValoracionesDao {
    public List<Valoraciones> findAllValoraciones();
    
    public Valoraciones findValoracionesById(Valoraciones v);
    
    public Valoraciones findValoracionesByComentario(Valoraciones v);
    
    public  Valoraciones  findValoracionesByPuntuacion(Valoraciones v);
    
    public void insertValoraciones(Valoraciones v);

    public void updateValoraciones(Valoraciones v);
    
    public void deleteValoraciones(Valoraciones v);
}
