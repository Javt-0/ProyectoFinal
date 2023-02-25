<%-- 
    Document   : listaGames
    Created on : 23 feb. 2023, 22:56:13
    Author     : jonat
--%>


<%@page import="com.proyecto.service.MediaService"%>
<%@page import="com.proyecto.service.MediaServiceImpl"%>
<%@page import="com.proyecto.dominio.Media"%>
<%@page import="com.proyecto.dominio.Videojuegos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="./recursos/headerAdmin.jsp" />
    <div class="container pt-4 p-3 ">
            <div class="row mb-4">
              <div class="col-md-4 mx-auto">
                <div>
                  <form class="d-flex" method="POST" action="./busqueda.php">
                      <input class="form-control me-2 " name="busqueda" type="search" placeholder="Search" aria-label="Search">
                      <button class="btn btn-outline-secondary" type="submit">  <i class="fa-sharp fa-solid fa-magnifying-glass"></i></button>
                  </form>
                </div>
              </div>
            </div>
            <div class="row">
                <% 
                int id = 0;
                List<Videojuegos> listaGames = (List<Videojuegos>) session.getAttribute("listaGame");
                List<Media> listaMedia = (List<Media>) session.getAttribute("listaMedia");
                MediaService mediaServiceImpl = new MediaServiceImpl();
                for(int i=0; i<listaGames.size(); i++){
                    String urlImagen = "";
                    String urlVideo = "";
                    urlImagen = mediaServiceImpl.obtenerUrlImagen(listaGames.get(i), listaMedia);
                    urlVideo = mediaServiceImpl.obtenerUrlVideo(listaGames.get(i), listaMedia);
                %>
                    <div class="col-md-4 mb-3">
                        
                        <div class="card text-center" style="width: 100%; height: 100%;">
                            <% if(urlImagen.equals("") && urlVideo.equals("")){ %>
                                <p class="text-center text-danger mt-3">Aun no hay media de este videojuego</p>
                            <% }else if(!urlImagen.equals("") && urlVideo.equals("")){ %>
                                <img src="<%= urlImagen %>" class="card-img-top img-fluid" alt="#" style="height: 235px;">
                            <% }else{%>
                                <video id="video" loop>
                                    <source src="<%= urlVideo %>" type="video/webm">
                                </video>
                            <% } %>
                          <div class="card-body">
                              <h3 class="card-title text-capitalize"><%= listaGames.get(i).getNombre() %></h3>
                            <p> <text class="text-info">Precio:  </text>  <%= listaGames.get(i).getPrecio() %> €</p>
                            <p> <text class="text-info">Stock:  </text> <%= listaGames.get(i).getStock() %></p>
                 
                            <div class="d-flex justify-content-center align-items-center">
                                <div class="me-4">
                                    <form class="d-flex" method="POST" action="UsuarioControlador?accion=editar">
                                        <input type="hidden" name="idUsuario" value="<%= listaGames.get(i).getId() %>">
                                        <button class="btn btn-outline-warning" type="submit">Editar&nbsp<i class="fa-sharp fa-solid fa-pen-to-square"></i></button>
                                    </form>
                                    
                                </div>
                                <div class="me-4">
                                    
                                   <button class="btn btn-outline-warning" type="button" onclick="openMediaModal(<%= listaGames.get(i).getId() %>);" data-bs-toggle="modal" data-bs-target="#mediaModal">Media <i class="fa-sharp fa-solid fa-plus"></i></button>
                                    
                                </div>
                                <div>
                                    <form class="d-flex" method="POST" action="UsuarioControlador?accion=eliminar">
                                        <input type="hidden" name="idEliminar" value="<%= listaGames.get(i).getId() %>">
                                        <button class="btn btn-outline-danger" type="submit"> Eliminar&nbsp&nbsp<i class="fa-sharp fa-solid fa-trash"></i></button>
                                    </form>
                                </div>
                            </div>
                          </div>
                        </div>
                    </div>
                <% } %>
            </div>
        </div>
      </main>
    <jsp:include page="./recursos/footer.jsp" />
    <div class="modal" tabindex="-1" role="dialog" id="mediaModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Agregar media</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form id="mediaForm" method="POST" action="MediaControlador?accion=insertar" enctype="multipart/form-data">
            <div class="modal-body">
              <div class="form-group">
                <input type="hidden" class="form-control" id="idInput" name="idVideojuego" >
              </div>
              <div class="form-group mb-4">
                <label for="nombreInput">Tipo de media:</label>
                <select name="tipo">
                    <option value="Imagen">Imagen</option>
                    <option value="Video">Video</option>
                </select>
              </div>
              <div class="form-group">
                <input type="file" class="form-control" id="precioInput" name="archivoMedia" >
              </div>
              
            </div>
            <div class="modal-footer">
              <a class="btn btn-danger" href="./listaGames.jsp">Cerrar</a>
              <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script src="./static/js/Modal.js" ></script>
    <script src="./static/js/controlVideo.js" ></script>
</body>

</html>

