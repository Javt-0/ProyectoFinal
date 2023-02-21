/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Ordenes;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface OrdenesDao {
    public List<Ordenes> findAllOrdenes();
    
    public Ordenes findOrdenesById(Ordenes o);
    
    public Ordenes findOrdenesByFecha(Ordenes o);
    
    public void insertOrdenes(Ordenes o);

    public void updateOrdenes(Ordenes o);
    
    public void deleteOrdenes(Ordenes o);
}
