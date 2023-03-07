/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.web;

import com.proyecto.dominio.Carrito;
import com.proyecto.dominio.Usuarios;
import com.proyecto.dominio.Videojuegos;
import com.proyecto.service.CarritoService;
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
@WebServlet(name = "CarritoControlador", urlPatterns = {"/CarritoControlador"})
public class CarritoServlet extends HttpServlet {
    @Inject
    CarritoService carritoService;
    
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
        Integer idUser = Integer.parseInt(request.getParameter("idUsuario"));
        Integer idGame = Integer.parseInt(request.getParameter("idVideojuego"));
        
        Usuarios user = new Usuarios(idUser);
        Videojuegos game = new Videojuegos(idGame);
        
        Carrito carro = new Carrito(user, game);
        carritoService.insertarCarrito(carro);
        
        List<Carrito> carritoLista = carritoService.listarCarrito();
        request.getSession().setAttribute("listaCarrito", carritoLista);
        response.sendRedirect("./carrito.jsp");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
