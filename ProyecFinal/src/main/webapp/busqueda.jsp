<%-- 
    Document   : busqueda
    Created on : 7 mar. 2023, 3:02:49
    Author     : jonat
--%>

<%@page import="com.proyecto.service.MediaService"%>
<%@page import="com.proyecto.service.MediaServiceImpl"%>
<%@page import="com.proyecto.dominio.Media"%>
<%@page import="com.proyecto.dominio.Videojuegos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="./recursos/headerUsu.jsp" />
    <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex justify-content-center align-items-center">
            <a class="p-2 link-secondary text-white me-5" href="#" style="text-decoration: none;"><i class="fa-solid fa-desktop"></i> PC</a>
            <a class="p-2 link-secondary text-white me-5" href="#" style="text-decoration: none;"><i class="fa-brands fa-xbox"></i> Xbox</a>
            <a class="p-2 link-secondary text-white me-5" href="#" style="text-decoration: none;"><i class="fa-brands fa-playstation"></i> Playstation</a>
            <a class="p-2 link-secondary text-white" href="#" style="text-decoration: none;"><i class="fa-solid fa-gamepad"></i> Nintento</a>
        </nav>
    </div>
    <div class="container pt-4 p-3 ">
            <div class="row mb-4">
              <div class="col-md-4 mx-auto">
                <div>
                  <form class="d-flex" method="POST" action="VideojuegoControlador?accion=buscar">
                      <input class="form-control me-2 " name="busqueda" type="search" placeholder="Search" aria-label="Search">
                      <button class="btn btn-outline-secondary" type="submit">  <i class="fa-sharp fa-solid fa-magnifying-glass"></i></button>
                  </form>
                </div>
              </div>
            </div>
            
            
            <div class="row">
                <% 
                int id = 0;
                List<Videojuegos> listaGames = (List<Videojuegos>) session.getAttribute("listaBusqueda");
                List<Media> listaMedia = (List<Media>) session.getAttribute("listaMedia");
                MediaService mediaServiceImpl = new MediaServiceImpl(); 
                if(listaGames.isEmpty()){
                %>
                    <div class="col-md-4 mx-auto">
                        <div class="card card-body text-center">
                            <p class="text-danger">Sin resultados</p>
                        </div>
                    </div>
                <% } %>
                
                
                <%for(int i=0; i<listaGames.size(); i++){
                    String urlImagen = "";
                    String urlVideo = "";
                    urlImagen = mediaServiceImpl.obtenerUrlPortada(listaGames.get(i), listaMedia);
                    urlVideo = mediaServiceImpl.obtenerUrlVideo(listaGames.get(i), listaMedia);
                %>
                    <div class="col-md-4 mb-3">
                        <a style="text-decoration: none; color: white;"  href="detalleJuego.jsp?id=<%= listaGames.get(i).getId() %>&portada=<%= urlImagen %>">
                            <div class="card text-center" style="width: 100%; height: 100%;">
                                <% if(urlImagen.equals("") && urlVideo.equals("")){ %>
                                    <p class="text-center text-danger mt-3">Aun no hay media de este videojuego</p>
                                <% }else if(!urlImagen.equals("") && urlVideo.equals("")){ %>
                                    <img src="<%= urlImagen %>" class="card-img-top img-fluid" alt="#" style="height: 235px;">
                                <% }else{%>
                                    <img src="<%= urlImagen %>" class="card-img-top img-fluid" alt="#" style="height: 235px;" id="gameImage<%= i %>" onmouseover="replaceWithVideo(this, '<%= urlVideo %>');" onmouseout="replaceWithImage(this, <%= urlImagen %>);">
                                <% } %>
                                <div class="card-body d-flex justify-content-between align-items-center">
                                  <p class="card-title text-capitalize "><%= listaGames.get(i).getNombre() %></p>
                                  <h4> <%= listaGames.get(i).getPrecio() %> €</h4>
                                </div>
                            </div>
                        </a>
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
    <script src="./static/js/Modal.js" ></script>
    <script src="./static/js/controlVideo.js" ></script>
</body>

</html>

