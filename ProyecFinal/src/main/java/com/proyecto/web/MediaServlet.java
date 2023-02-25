/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proyecto.web;

import com.proyecto.dominio.Media;
import com.proyecto.dominio.Videojuegos;
import com.proyecto.service.MediaService;
import com.proyecto.service.VideojuegoService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
@WebServlet(name = "MediaControlador", urlPatterns = {"/MediaControlador"})
@MultipartConfig
public class MediaServlet extends HttpServlet {
    @Inject
    MediaService mediaService;
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
        
        Integer id = Integer.parseInt(request.getParameter("idVideojuego"));
        Videojuegos game = new Videojuegos(id);
        
        String tipoMedia = request.getParameter("tipo");
        
        //Subir fotos
        Part filePart = request.getPart("archivoMedia");
        String fileName = filePart.getSubmittedFileName();
        filePart.write(fileName);
        File imgTemporal = new File("C:\\glassfish5\\glassfish\\domains\\domain1\\generated\\jsp\\ProyecFinal-1.0\\" + fileName);
        String rutaTemporal = imgTemporal.getPath();
        System.out.println("Temporal: " + rutaTemporal);
        String url = "C:\\Users\\jonat\\Desktop\\DAM 2\\1º Evaluacion\\PROGRAMACION (Acceso a datos)\\Java\\PROYECFINAL\\ProyectoFinal\\ProyecFinal\\src\\main\\webapp\\img\\game\\" + fileName;
        System.out.println("RUTA DESTINO: " + url);
        File destFile = new File(url);
        Files.move(Paths.get(rutaTemporal), Paths.get(url));
        String imgUrl = "./img/game/" + fileName;
        //termina codigo para subir foto
        
        Media media = new Media(imgUrl, tipoMedia, game);
        System.out.println("MEDIA: " + media);
        mediaService.insertarMedia(media);
        List<Videojuegos> videojuegos = videojuegoService.listarVideojuegos();
        
        List<Media> mediaLista = mediaService.listarMedia();
        System.out.println("MEDIA: " + mediaLista);
        request.getSession().setAttribute("listaMedia", mediaLista);
        request.getSession().setAttribute("listaGame", videojuegos);
        response.sendRedirect("./listaGames.jsp");
    }

}
