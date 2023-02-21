/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Media;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface MediaDao {
    public List<Media> findAllMedia();
    
    public Media findMediaById(Media m);
    
    public Media findMediaByUrlmedia(Media m);
    
    public Media findMediaByTipo(Media m);
    
    public void insertMedia(Media m);

    public void updateMedia(Media m);
    
    public void deleteMedia(Media m);
}
