<%-- 
    Document   : listaGames
    Created on : 23 feb. 2023, 22:56:13
    Author     : jonat
--%>


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
                for(int i=0; i<listaGames.size(); i++){
                %>
                    <div class="col-md-4 mb-3">
                        <div class="card text-center" style="width: 100%; height: 100%;">
                            
                          <div class="card-body">
                              <h3 class="card-title text-capitalize"><%= listaGames.get(i).getNombre() %></h3>
                            <p> <text class="text-info">Precio:  </text>  <%= listaGames.get(i).getPrecio() %></p>
                            <p> <text class="text-info">Stock:  </text> <%= listaGames.get(i).getStock() %></p>
                 
                            <div class="d-flex justify-content-center align-items-center">
                                <div class="me-4">
                                    <form class="d-flex" method="POST" action="UsuarioControlador?accion=editar">
                                        <input type="hidden" name="idUsuario" value="<%= listaGames.get(i).getId() %>">
                                        <button class="btn btn-outline-warning" type="submit">Editar&nbsp<i class="fa-sharp fa-solid fa-pen-to-square"></i></button>
                                    </form>
                                    
                                </div>
                                <div class="me-4">
                                    
                                    <button class="btn btn-outline-warning" type="button" data-id="<%= listaGames.get(i).getId() %>" data-nombre="<%= listaGames.get(i).getNombre() %>" data-precio="<%= listaGames.get(i).getPrecio() %>" data-stock="<%= listaGames.get(i).getStock() %>" data-bs-toggle="modal" data-bs-target="#mediaModal">Media&nbsp<i class="fa-sharp fa-solid fa-pen-to-square"></i></button>
                                   
                                    
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
          <form id="mediaForm" method="POST" action="MediaControlador?accion=insertar">
            <div class="modal-body">
              <div class="form-group">
                <label for="idInput">ID:</label>
                <input type="text" class="form-control" id="idInput" name="id" readonly>
              </div>
              <div class="form-group">
                <label for="nombreInput">Nombre:</label>
                <input type="text" class="form-control" id="nombreInput" name="nombre" readonly>
              </div>
              <div class="form-group">
                <label for="precioInput">Precio:</label>
                <input type="text" class="form-control" id="precioInput" name="precio" readonly>
              </div>
              <div class="form-group">
                <label for="stockInput">Stock:</label>
                <input type="text" class="form-control" id="stockInput" name="stock" readonly>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
              <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    <script >
        function abroModal(id, nombre, precio, stock) {
            let modal = document.getElementById('mediaModal');
            let idInput = document.getElementById('idInput');
            let nombreInput = document.getElementById('nombreInput');
            let precioInput = document.getElementById('precioInput');
            let stockInput = document.getElementById('stockInput');

            idInput.value = id;
            nombreInput.value = nombre;
            precioInput.value = precio;
            stockInput.value = stock;

            modal.modal('show');
        }
    </script>
</body>

</html>

