/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.web;

import com.proyecto.dominio.Media;
import com.proyecto.dominio.Usuarios;
import com.proyecto.dominio.Valoraciones;
import com.proyecto.dominio.Videojuegos;
import com.proyecto.service.ValoracionesService;
import com.proyecto.service.VideojuegoService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jonat
 */
@WebServlet(name = "ValoracionControlador", urlPatterns = {"/ValoracionControlador"})
public class ValoracionServlet extends HttpServlet {
    @Inject
    ValoracionesService valoracionesService;
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
                    case "insertar":
                        this.insertar(request, response);
                        break;

                    case "registrar":
                        //this.registrar(request, response);
                        break;
                        
                    case "editar":
                        //this.editar(request, response);
                        break;
                        
                    case "eliminar":
                        //this.eliminar(request, response);
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
    }
    
    private void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
        Integer idUser = Integer.parseInt(request.getParameter("idUsuario"));
        Usuarios u = new Usuarios(idUser);
        Integer idGame = Integer.parseInt(request.getParameter("idVideojuego"));
        Videojuegos v = new Videojuegos(idGame);
        String comentario = request.getParameter("comentario");
        
        Valoraciones valoracion = new Valoraciones(comentario, puntuacion, u, v);
        System.out.println("Valoracion: " + valoracion);
        valoracionesService.insertarValoraciones(valoracion);
        
        List<Videojuegos> videojuegos = videojuegoService.listarVideojuegos();
        request.getSession().setAttribute("listaGame", videojuegos);
        
        response.sendRedirect("./homeUser.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
