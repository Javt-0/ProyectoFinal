/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.MediaDao;
import com.proyecto.dominio.Media;
import com.proyecto.dominio.Videojuegos;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
@Stateless
public class MediaServiceImpl implements MediaService{
    @Inject 
    private MediaDao mediaDao;
    
    
    @Override
    public List<Media> listarMedia(){
        return mediaDao.findAllMedia();
    }
    
    @Override
    public Media buscarPorId(Media m){
        return mediaDao.findMediaById(m);
    }
    
    @Override
    public Media buscarPorUrlmedia(Media m){
        return mediaDao.findMediaByUrlmedia(m);
    }
    
    @Override
    public Media buscarPorTipo(Media m){
        return mediaDao.findMediaByTipo(m);
    }
    
    @Override
    public void insertarMedia(Media m){
        mediaDao.insertMedia(m);
    }
    
    @Override
    public void actualizarMedia(Media m){
        mediaDao.updateMedia(m);
    }
    
    @Override
    public void eliminarMedia(Media m){
        mediaDao.deleteMedia(m);
    }
    
    @Override
    public String obtenerUrlImagen(Videojuegos v, List<Media> listaMedia){
        String url = "";
        
        int id = v.getId();
        for(int j=0; j<listaMedia.size(); j++){
            Videojuegos game = listaMedia.get(j).getIdVideojuego();
            System.out.println("ESTE ES EL ID "+game.getId());
            if(game.getId() == id && listaMedia.get(j).getTipo().equalsIgnoreCase("imagen")){
                url = listaMedia.get(j).getUrlmedia();
            }
        }
        System.out.println("URL en NEGOCIO: " + url);
        return url;
    }
    
    @Override
    public String obtenerUrlVideo(Videojuegos v, List<Media> listaMedia){
        String url = "";
        
        int id = v.getId();
        for(int j=0; j<listaMedia.size(); j++){
            Videojuegos game = listaMedia.get(j).getIdVideojuego();
            System.out.println("ESTE ES EL ID "+game.getId());
            if(game.getId() == id && listaMedia.get(j).getTipo().equalsIgnoreCase("video")){
                url = listaMedia.get(j).getUrlmedia();
            }
        }
        System.out.println("URL en video: " + url);
        return url;        
                
    }
    
}
