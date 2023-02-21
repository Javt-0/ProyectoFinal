/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.dominio.Usuarios;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface UsuarioService {
    public List<Usuarios> listarUsuarios();
    
    public Usuarios buscarPorEmail(Usuarios u);
    
    public Usuarios buscarPorNombreUsuario(Usuarios u);
    
    public  Usuarios buscarPorId(Usuarios u);
    
    public void insertarUsuarios(Usuarios u);

    public void actualizarUsuarios(Usuarios u);
    
    public void eliminarUsuarios(Usuarios u);
}
