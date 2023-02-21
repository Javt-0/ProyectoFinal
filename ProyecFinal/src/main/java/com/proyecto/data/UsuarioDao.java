/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.data;

import com.proyecto.dominio.Usuarios;
import java.util.List;

/**
 *
 * @author jonat
 */
public interface UsuarioDao {
    
    public List<Usuarios> findAllUsuarios();
    
    public Usuarios findUsuariosByEmail(Usuarios u);
    
    public Usuarios findUsuariosByNomUsuario(Usuarios u);
    
    public  Usuarios  findUsuariosById(Usuarios u);
    
    public void insertUsuarios(Usuarios u);

    public void updateUsuarios(Usuarios u);
    
    public void deleteUsuarios(Usuarios u);
}
