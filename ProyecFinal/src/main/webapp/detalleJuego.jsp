<%-- 
    Document   : detalleJuego
    Created on : 28 feb. 2023, 23:56:17
    Author     : jonat
--%>

<%@page import="com.proyecto.service.UsuarioServiceImpl"%>
<%@page import="com.proyecto.service.UsuarioService"%>
<%@page import="com.proyecto.dominio.Usuarios"%>
<%@page import="com.proyecto.dominio.Valoraciones"%>
<%@page import="com.proyecto.dominio.Media"%>
<%@page import="java.util.List"%>
<%@page import="com.proyecto.dominio.Videojuegos"%>
<%@page import="com.proyecto.service.VideojuegoServiceImpl"%>
<%@page import="com.proyecto.service.VideojuegoService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="./recursos/headerUsu.jsp" />
<% 
String idJuego = request.getParameter("id");
String portadaUrl = request.getParameter("portada");
Integer id = Integer.parseInt(idJuego);
String iframe = "";
List<Videojuegos> listaGames = (List<Videojuegos>) session.getAttribute("listaGame");
Usuarios usuario = (Usuarios) session.getAttribute("usuario");
for(int i=0; i<listaGames.size(); i++){
    if(id == listaGames.get(i).getId()){
        for(Media media : listaGames.get(i).getMediaList()) {
            if(media.getTipo().equalsIgnoreCase("iframe")){
                iframe = media.getUrlmedia();
            }
        }    
%>


<div class="container-fluid">
    <div class="row h-100" style="height: 700px">
        <div class="p-4 p-md-5 mb-3 text-white rounded bg-dark position-absolute" style="background-image: url(<%= portadaUrl %>); background-size: cover; background-repeat: no-repeat;">
            <div class="col-md-6 px-0" >
                <h1 class="card-title text-capitalize">.</h1>
                <h1 class="card-title text-capitalize">.</h1>
                <h1 class="card-title text-capitalize">.</h1>
                <h1 class="card-title text-capitalize">.</h1>
            </div>
            <div class=" row position-absolute w-100 h-50 justify-content-center ">

                <div class="col-md-4 mb-3 me-5">
                    <div class="card text-center" style="width: 100%; height: 100%;">
                        <img src="<%= portadaUrl %>" class="card-img-top img-fluid" alt="#" style="height: 300px; width: 500px;">
                    </div>
                </div>

                <div class="col-md-4 mb-3 ms-5">
                    <div class="card text-center" style="width: 100%; height: 100%;">
                        <div class="card-body">
                            <h2 class="card-title text-capitalize  mb-4"><%= listaGames.get(i).getNombre() %></h2>
                            <% if(listaGames.get(i).getStock() <= 0){ %>
                                <p class="text-danger  mb-4">EL juego no dispone de stock</p>
                            <% }else{ %>
                                <p class="text-info mb-4">EL juego esta en stock</p>
                            <% } %>
                            <h1 class="mb-4"><%= listaGames.get(i).getPrecio() %> €</h1>
                            <div class="align-items-center justify-content-between">
                                <% if(listaGames.get(i).getStock() <= 0){ %>
                                <form>
                                    <button class="btn btn-outline-danger" type="submit" style="width: 10%;"><i class="fa-solid fa-cart-shopping"></i></button>
                                    <button class="btn btn-outline-danger" type="submit" style="width: 70%;">No se puede añadir al carrito</button>
                                </form>
                            <% }else{ %>
                                <form method="POST" action="CarritoControlador?accion=insertar">
                                    <input type="hidden" value="<%= usuario.getId() %>"  name="idUsuario">
                                    <input type="hidden" value="<%= listaGames.get(i).getId() %>" name="idVideojuego">
                                    <button class="btn btn-outline-warning" type="submit" style="width: 10%;"><i class="fa-solid fa-cart-shopping"></i></button>
                                    <button class="btn btn-outline-warning" type="submit" style="width: 70%;">Añadir al carrito</button>
                                </form>
                            <% } %>
                                
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mb-5 mt-5 pe-5" >
                    <h4 class="text-white-50">Descripcion:</h4>
                    <div class="col " >
                        <h3 class="text-white "><%= listaGames.get(i).getDescripcion() %></h3>
                    </div>
                    
                </div>
                    
                <div class="row  d-flex align-items-center justify-content-center" style="width: 100%;">
                    <h4 class="text-white-50">Visuales:</h4>
                    <div class="col col-md-4 mb-3 ms-5 pe-5 me-5" style="width: 100%;">
                        <iframe width="100%" height="600" src="<%= iframe %>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                    <div class="row mt-1 d-flex align-items-center" >
                        <%for(Media media : listaGames.get(i).getMediaList()) {
                            if(media.getTipo().equalsIgnoreCase("Imagen")){ %>
                                <div class="col col-md-4 mb-3 pe-5">
                                    <div class="card text-center" style="width: 100%; height: 100%;">
                                        <img src="<%= media.getUrlmedia() %>" class="card-img-top img-fluid" alt="#" >
                                    </div>
                                </div>
                        <%  }
                        } %> 
                    </div>
                </div>
                <div class="row d-flex justify-content-center align-items-center mb-4" >
                    <% List<Valoraciones> valocion = listaGames.get(i).getValoracionesList(); 
                    if(valocion.isEmpty()){ %>
                        <div class="col-md-8 mb-4">
                            <div class="card">
                                <div class="card-header">No hay valoraciones</div>
                                    <div class="card-body">
                                        <p class="text-danger">No hay valoraciones</p>
                                    </div>
                            </div>
                        </div>
                    <% }else{ %>
                        <%for(Valoraciones valoracion : listaGames.get(i).getValoracionesList()) { 
                        Usuarios u = valoracion.getIdUsuario();
                        System.out.println("USU VALORACION:" + u);
                        %>
                            <div class="col-md-8 mb-4">
                                <div class="card">
                                    <div class="card-header"><%= valoracion.getIdUsuario().getNombreUsuario() %></div>
                                    <div class="card-body">
                                        <p><%= valoracion.getComentario() %>  </p>
                                        <p>Puntuacion: <%= valoracion.getPuntuacion() %>  </p>
                                    </div>
                                </div>
                            </div>
                        <% } %>
                    <% } %>
                    
                </div>
                <div class="row justify-content-center mb-4">
                    <div class="col-md-8 mb-4">
                      <div class="card">
                        <div class="card-header">Deja tu comentario de este juego</div>
                        <div class="card-body">
                         
                            <form  method="POST" action="ValoracionControlador?accion=insertar">
                                <!--Primer campo-->
                                <div class="mb-3 row">
                                    <label class="col-md-4 col-form-label text-md-end">Comentario:</label>
                                    <div class="col-md-6">
                                        
                                        <textarea name="comentario" style="width: 500px; height: 200px;"></textarea>
                                        <!--input type="text" name="usuario" class="form-control" autofocus-->
                                    </div>
                                </div>

                                <!--Segundo campo-->
                                <div class="mb-3 row">
                                  <label class="col-md-4 col-form-label text-md-end">Puntuacion:</label>
                                  <div class="col-md-6">
                                    <select name="puntuacion" onchange="checkInputType(this)">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                  </div>
                                </div>

                                <div class="mb-3 row">
                                  <div class="col-md-6 offset-md-4">
                                    <button type="submit" class="btn btn-primary">Enviar</button>
                                  </div>
                                </div>
                                <input type="hidden" name="idUsuario" value="<%= usuario.getId() %>">
                                <input type="hidden" name="idVideojuego" value="<%= listaGames.get(i).getId() %>">
                            </form>

                        </div>
                      </div>
                    </div>
                </div>
                
                
                    
            </div>
            
        </div>
                             
    </div>
    
    
</div>                          

    
<% 
    }
}
%>

</main><!-- comment -->

</body>

</html>