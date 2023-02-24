/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.web;

import com.proyecto.dominio.Usuarios;
import com.proyecto.dominio.Videojuegos;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.VideojuegoService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jonat
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
@MultipartConfig
public class UsuarioServlet extends HttpServlet {
    @Inject
    UsuarioService usuarioService;
    @Inject
    VideojuegoService videojuegoService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "logear":
                        this.login(request, response);
                        break;

                    case "registrar":
                        this.registrar(request, response);
                        break;
                        
                    case "editar":
                        //this.editar(request, response);
                        break;
                        
                    case "eliminar":
                        this.eliminar(request, response);
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String fechaOrigen = request.getParameter("fechaNac");
        String nomUsuario = request.getParameter("nomUsu");
        String clave = request.getParameter("clave");
        String apellidos = request.getParameter("apellido");
        
        //Subir fotos
        Part filePart = request.getPart("imgPerfil");
        String fileName = filePart.getSubmittedFileName();
        filePart.write(fileName);
        File imgTemporal = new File("C:\\glassfish5\\glassfish\\domains\\domain1\\generated\\jsp\\ProyecFinal-1.0\\" + fileName);
        String rutaTemporal = imgTemporal.getPath();
        System.out.println("Temporal: " + rutaTemporal);
        String url = "C:\\Users\\jonat\\Desktop\\DAM 2\\1º Evaluacion\\PROGRAMACION (Acceso a datos)\\Java\\PROYECFINAL\\ProyectoFinal\\ProyecFinal\\src\\main\\webapp\\img\\user\\" + fileName;
        System.out.println("RUTA DESTINO: " + url);
        File destFile = new File(url);
        Files.move(Paths.get(rutaTemporal), Paths.get(url));
        String imgUrl = "./img/user/" + fileName;
        //termina codigo para subir foto
        System.out.println("datos: " + email + pais);
        SimpleDateFormat formatoOrigen = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNac;
        try {
            fechaNac = formatoOrigen.parse(fechaOrigen);
            System.out.println("nacimiento" + fechaNac);
            Usuarios nuevoUsuario = new Usuarios(nombre, apellidos, email, nomUsuario, clave, fechaNac, pais, imgUrl);
            System.out.println(nuevoUsuario);
            usuarioService.insertarUsuarios(nuevoUsuario);
            Usuarios usuarioSesion = usuarioService.usuarioSesion(nuevoUsuario);
            request.getSession().setAttribute("usuario", usuarioSesion);
            response.sendRedirect("./homeUser.jsp");

        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String nomUsuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String error;
        
        Usuarios usuario = new Usuarios(nomUsuario, clave);
        System.out.println("USU: " + usuario);
        List<Usuarios> usuarios = usuarioService.listarUsuarios();
        List<Videojuegos> videojuegos = videojuegoService.listarVideojuegos();
        
        System.out.println("DATOS: " + usuario);
        if(usuarioService.validacionUsu(usuario)){
            Usuarios usuarioSesion = usuarioService.usuarioSesion(usuario);
            if(nomUsuario.equals("admin")){
                request.getSession().setAttribute("listaGame", videojuegos);
                request.getSession().setAttribute("listaUsu", usuarios);
                request.getSession().setAttribute("usuario", usuarioSesion);
                response.sendRedirect("./homeAdmin.jsp");
            }else{
                request.getSession().setAttribute("listaGame", videojuegos);
                request.getSession().setAttribute("usuario", usuarioSesion);
                response.sendRedirect("./homeUser.jsp");
            }
            
        }else{
            error = "Error en las credenciales";
            request.getSession().setAttribute("error", error);
            response.sendRedirect("./login.jsp");
        }
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        Integer id = Integer.parseInt(request.getParameter("idEliminar"));
        
        Usuarios user = new Usuarios(id);
        
        usuarioService.eliminarUsuarios(user);
        System.out.println("HOLA PASO POR AQUI:" + user);
        List<Usuarios> usuarios = usuarioService.listarUsuarios();
        request.getSession().setAttribute("listaUsu", usuarios);
        response.sendRedirect("./homeAdmin.jsp");
    }
}
