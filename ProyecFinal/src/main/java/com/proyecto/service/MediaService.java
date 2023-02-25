/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dominio.Media;
import com.proyecto.dominio.Videojuegos;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface MediaService {
    public List<Media> listarMedia();
    
    public Media buscarPorId(Media m);
    
    public Media buscarPorUrlmedia(Media m);
    
    public Media buscarPorTipo(Media m);
    
    public void insertarMedia(Media m);

    public void actualizarMedia(Media m);
    
    public void eliminarMedia(Media m);
    
    public String obtenerUrlImagen(Videojuegos v, List<Media> listaMedia);
    
    public String obtenerUrlVideo(Videojuegos v, List<Media> listaMedia);
}
