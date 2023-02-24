/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.web;

import com.proyecto.dominio.Videojuegos;
import com.proyecto.service.VideojuegoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
@WebServlet(name = "VideojuegoControlador", urlPatterns = {"/VideojuegoControlador"})
public class VideojuegoServlet extends HttpServlet {
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
                    case "add":
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
        
        String nombreJuego = request.getParameter("nombre");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        String descripcion = request.getParameter("descripcion");
        
        Videojuegos game = new Videojuegos(nombreJuego, precio, stock, descripcion);
        System.out.println("GAME: " + game);
        
        videojuegoService.insertarVideojuegos(game);
        
        List<Videojuegos> videojuegos = videojuegoService.listarVideojuegos();
        request.getSession().setAttribute("listaGame", videojuegos);
        
        response.sendRedirect("./listaGames.jsp");
        
    }

}
