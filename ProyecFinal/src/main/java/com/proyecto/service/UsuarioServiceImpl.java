/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.UsuarioDao;
import com.proyecto.dominio.Usuarios;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
public class UsuarioServiceImpl implements UsuarioService{
    @Inject 
    private UsuarioDao usuarioDao;
    
    public List<Usuarios> listarUsuarios(){
        return usuarioDao.findAllUsuarios();
    }
    
    public Usuarios buscarPorEmail(Usuarios u){
        return usuarioDao.findUsuariosByEmail(u);
    }
    
    public Usuarios buscarPorNombreUsuario(Usuarios u){
        return usuarioDao.findUsuariosByNomUsuario(u);
    }
    
    public  Usuarios buscarPorId(Usuarios u){
        return usuarioDao.findUsuariosById(u);
    }
    
    public void insertarUsuarios(Usuarios u){
        usuarioDao.insertUsuarios(u);
    }

    public void actualizarUsuarios(Usuarios u){
        usuarioDao.updateUsuarios(u);
    }
    
    public void eliminarUsuarios(Usuarios u){
        usuarioDao.deleteUsuarios(u);
    }
}
