<%-- 
    Document   : homeAdmin
    Created on : 23 feb. 2023, 0:22:17
    Author     : jonat
--%>

<%@page import="com.proyecto.service.UsuarioServiceImpl"%>
<%@page import="com.proyecto.dominio.Usuarios"%>
<%@page import="com.proyecto.service.UsuarioService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                List<Usuarios> listaUsuarios = (List<Usuarios>) session.getAttribute("listaUsu");
                UsuarioService usuario = new UsuarioServiceImpl();
                for(int i=1; i<listaUsuarios.size(); i++){
                %>
                    <div class="col-md-4 mb-3">
                        <div class="card text-center" style="width: 100%; height: 100%;">
                            <img src="<%= listaUsuarios.get(i).getImgPerfil()  %>" class="mt-3 mx-auto card-img-top img-fluid rounded-circle" alt="#" style=" border-radius: 50%; max-width: 150px; max-height: 150px;">
                            
                          <div class="card-body">
                            <h3 class="card-title text-capitalize"><%= listaUsuarios.get(i).getNombre() %> <%= listaUsuarios.get(i).getApellidos() %></h3>
                            <p> <text class="text-info">Correo Electronico:  </text>  <%= listaUsuarios.get(i).getEmail() %></p>
                            <p> <text class="text-info">Nombre de Usuario:  </text> <%= listaUsuarios.get(i).getNombreUsuario() %></p>
                            <p> <text class="text-info">Pais:  </text> <%= listaUsuarios.get(i).getPais() %></p>
                            <p> <text class="text-info">Edad:  </text> <%= usuario.calcularEdad(listaUsuarios.get(i)) %></p>
                            <div class="d-flex justify-content-center align-items-center">
                                <div class="me-4">
                                    <form class="d-flex" method="POST" action="UsuarioControlador?accion=editar">
                                        <input type="hidden" name="idUsuario" value="<%= listaUsuarios.get(i).getId() %>">
                                        <button class="btn btn-outline-warning" type="submit"> Editar Usuario&nbsp&nbsp<i class="fa-sharp fa-solid fa-pen-to-square"></i></button>
                                    </form>
                                    
                                </div>
                                <div>
                                    <form class="d-flex" method="POST" action="UsuarioControlador?accion=eliminar">
                                        <input type="hidden" name="idEliminar" value="<%= listaUsuarios.get(i).getId() %>">
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
</body>
</html>
