/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.data.UsuarioDao;
import com.proyecto.dominio.Usuarios;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jonat
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    @Inject 
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuarios> listarUsuarios(){
        return usuarioDao.findAllUsuarios();
    }
    
    @Override
    public Usuarios buscarPorEmail(Usuarios u){
        return usuarioDao.findUsuariosByEmail(u);
    }
    
    @Override
    public Usuarios buscarPorNombreUsuario(Usuarios u){
        return usuarioDao.findUsuariosByNomUsuario(u);
    }
    
    @Override
    public  Usuarios buscarPorId(Usuarios u){
        return usuarioDao.findUsuariosById(u);
    }
    
    @Override
    public void insertarUsuarios(Usuarios u){
        usuarioDao.insertUsuarios(u);
    }
    
    @Override
    public void actualizarUsuarios(Usuarios u){
        usuarioDao.updateUsuarios(u);
    }
    
    @Override
    public void eliminarUsuarios(Usuarios u){
        usuarioDao.deleteUsuarios(u);
    }
    
    @Override
    public Usuarios usuarioID(Usuarios usuario){
        ArrayList<Usuarios> todosUsuarios = new ArrayList<>();
        todosUsuarios.addAll(usuarioDao.findAllUsuarios());
        Usuarios usuSesion = new Usuarios();
        for(int i=0; i<todosUsuarios.size(); i++){
            if(todosUsuarios.get(i).getId() == usuario.getId()){
                usuSesion = todosUsuarios.get(i);
            }
        }
        return usuSesion;
    }
    
    
    @Override
    public Usuarios usuarioSesion(Usuarios usuario){
        ArrayList<Usuarios> todosUsuarios = new ArrayList<>();
        todosUsuarios.addAll(usuarioDao.findAllUsuarios());
        Usuarios usuSesion = new Usuarios();
        for(int i=0; i<todosUsuarios.size(); i++){
            if(todosUsuarios.get(i).getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario()) && todosUsuarios.get(i).getClave().equalsIgnoreCase(usuario.getClave())){
                usuSesion = todosUsuarios.get(i);
            }
        }
       
        return usuSesion;
    }
    
    
    @Override
    public boolean validacionUsu (Usuarios usuario){
        
        List<Usuarios> todosUsuarios = new ArrayList<>();
        todosUsuarios.addAll(usuarioDao.findAllUsuarios());
        boolean result = false;
        System.out.println("USU: " + todosUsuarios);
        for(int i=0; i<todosUsuarios.size(); i++){
            if(todosUsuarios.get(i).getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario()) && todosUsuarios.get(i).getClave().equalsIgnoreCase(usuario.getClave())){
                result = true;
            }
        }
        
        System.out.println("RESULTADO " + result);
        return result;
    }
    
    @Override
    public String calcularEdad(Usuarios u){
        DateTimeFormatter formatoFechaSalida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat formatoFechaEntrada = new SimpleDateFormat("dd/MM/yyyy");
        
        //Se transforma la fecha a String
        String fechaString = formatoFechaEntrada.format(u.getFechaNacimiento());
        
        LocalDate fechaNacSalida = LocalDate.parse(fechaString, formatoFechaSalida);
        LocalDate fechaActual = LocalDate.now();

        int periodo = Period.between(fechaNacSalida, fechaActual).getYears();
        
        return String.valueOf(periodo);
    }
}
