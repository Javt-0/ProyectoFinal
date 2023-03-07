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
                    urlImagen = mediaServiceImpl.obtenerUrlPortada(listaGames.get(i), listaMedia);
                    urlVideo = mediaServiceImpl.obtenerUrlVideo(listaGames.get(i), listaMedia);
                %>
                    <div class="col-md-4 mb-3">
                        
                        <div class="card text-center" style="width: 100%; height: 100%;">
                            <% if(urlImagen.equals("") && urlVideo.equals("")){ %>
                                <p class="text-center text-danger mt-3">Aun no hay media de este videojuego</p>
                            <% }else if(!urlImagen.equals("") && urlVideo.equals("")){ %>
                                <img src="<%= urlImagen %>" class="card-img-top img-fluid" alt="#" style="height: 235px;">
                            <% }else{%>
                                <img src="<%= urlImagen %>" class="card-img-top img-fluid" alt="#" style="height: 235px;" id="gameImage<%= i %>" onmouseover="replaceWithVideo(this, '<%= urlVideo %>');" onmouseout="replaceWithImage(this, <%= urlImagen %>);">

             
                            <% } %>
                          <div class="card-body">
                              <h3 class="card-title text-capitalize"><%= listaGames.get(i).getNombre() %></h3>
                            <p> <text class="text-info">Precio:  </text>  <%= listaGames.get(i).getPrecio() %> €</p>
                            <p> <text class="text-info">Stock:  </text> <%= listaGames.get(i).getStock() %></p>
                 
                            <div class="d-flex justify-content-center align-items-center">
                                <div class="me-4">
                                    <button class="btn btn-outline-warning" type="button" onclick="openEditModal(<%= listaGames.get(i).getId() %>, '<%= listaGames.get(i).getNombre() %>', <%= listaGames.get(i).getPrecio() %>, <%= listaGames.get(i).getStock() %>, '<%= listaGames.get(i).getDescripcion() %>');" data-bs-toggle="modal" data-bs-target="#editarGameModal">Editar <i class="fa-solid fa-pen-to-square"></i></button>

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
      
        
      <script>
        var originalImage;
        
        
        function replaceWithVideo(imgElement, videoUrl) {
          // Crear un nuevo elemento video
          var videoElement = document.createElement('video');
          videoElement.src = videoUrl;
          videoElement.autoplay = true;
          videoElement.loop = true;
          //videoElement.id = 'video';
          // Guardar una referencia a la imagen original
          originalImage = imgElement;

          // Reemplazar la imagen con el video
          imgElement.parentNode.replaceChild(videoElement, imgElement);
        }

        function replaceWithImage(videoElement, imgUrl) {
          // Crear un nuevo elemento imagen
          var imgElement = document.createElement('img');
          imgElement.src = imgUrl;
          imgElement.classList.add('card-img-top', 'img-fluid');
          imgElement.alt = '#';
          imgElement.style.height = '235px';

          // Reemplazar el video con la imagen original
          videoElement.parentNode.replaceChild(imgElement, videoElement);
        }
      </script>
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
                <input type="text" class="form-control" id="idInput" name="idVideojuego" >
              </div>
              <div class="form-group mb-4">
                <label for="nombreInput">Tipo de media:</label>
                <select name="tipo" onchange="checkInputType(this)">
                    <option value="Portada">Portada</option>
                    <option value="Imagen">Imagen</option>
                    <option value="Video">Video</option>
                    <option value="Iframe">Iframe</option>
                </select>
              </div>
              <div class="form-group">
                <input type="file" class="form-control" id="precioInput" name="archivoMedia" required autocomplete="precioInput">
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
    
    <div class="modal" tabindex="-1" role="dialog" id="editarGameModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Editar Videojuego</h5>
          </div>
          <form method="POST" action="VideojuegoControlador?accion=editar">
            <div class="modal-body mb-4">
              <div class="form-group">
                <label for="nombreInput">ID</label>
               
                <input type="text" class="form-control" id="idGame" name="idVideojuego"  readonly>
              </div>
                
              <div class="form-group mb-4">
                <label for="nombreInput">Nombre del juego</label>
                <input id="nombre" type="text" name="nombre" class="form-control" autofocus>
              </div>
                
              <div class="form-group mb-4">
                <label for="nombreInput">Precio</label>
                <input id="precio" type="text" name="precio" class="form-control" autofocus>
              </div>
                
              <div class="form-group mb-4">
                <label for="nombreInput">Stock</label>
                <input id="stock" type="number" name="stock" class="form-control" autofocus>
              </div>
                
                <label class="mb-3" for="nombreInput">Descripcion:</label>
              <div class="form-group mb-4">
                <textarea id="descripcion" name="descripcion" style="width: 450px; height: 200px;"></textarea>
              </div>
                
                <div class="form-group mb-4">
                    <label>Elige en que plataformas esta disponible:</label><br>
                    <input type="checkbox" name="plataforma" value="1">
                    <label>PC</label><br>
                    
                    <input type="checkbox" name="plataforma" value="2">
                    <label>Xbox</label><br><!-- comment -->
                    
                    <input type="checkbox" name="plataforma" value="3">
                    <label>Playstation</label><br><!-- comment -->
                    
                    <input type="checkbox" name="plataforma" value="4">
                    <label>Nintento</label><br>
                    
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
    <script>
        function checkInputType(selectElement) {
            var inputElement = selectElement.parentNode.parentNode.querySelector('input[name="archivoMedia"]');
            if (selectElement.value === "Iframe") {
              inputElement.type = "text";
            } else {
              inputElement.type = "file";
            }
          }
    </script>
    <script>
        function openEditModal(id, nombre, precio, stock, descripcion) {
            console.log('Se hizo clic en el botón con ID ' + id);
            let modal = document.getElementById('editarGameModal');
            let idInput = document.getElementById('idGame');
            let nom = document.getElementById('nombre');
            let prec = document.getElementById('precio');
            let stck = document.getElementById('stock');
            let descrp = document.getElementById('descripcion');
            nom.value = nombre;
            prec.value = precio;
            stck.value = stock;
            descrp.value = descripcion;
            idInput.value = id;
            modal.showModal();
        }
    </script>
    <script src="./static/js/Modal.js" ></script>
    <script src="./static/js/controlVideo.js" ></script>
</body>

</html>

