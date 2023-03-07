<%-- 
    Document   : perfil
    Created on : 28 feb. 2023, 15:54:05
    Author     : jonat
--%>

<%@page import="com.proyecto.service.UsuarioServiceImpl"%>
<%@page import="com.proyecto.service.UsuarioService"%>
<%@page import="com.proyecto.dominio.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="./recursos/headerUsu.jsp" />
<%
    Usuarios usuario = (Usuarios) session.getAttribute("usuario");
    UsuarioService usuarioImpl = new UsuarioServiceImpl();
%>
<div class="container py-5 team">
            <div class="row shadow p-3 mb-5 bg-body rounded">
                <div class="d-grid gap-2 col-6 mx-auto ">
                    <c:choose>
                        <c:when test="${not empty usuarios.fotobase64}">
                            <img src="<%= usuario.getImgPerfil() %>" class="img-thumbnail rounded-circle border-white">
                        </c:when>
                        <c:otherwise>
                            <img src="./static/img/logo.png"  style=" border-radius: 50%; max-width: 25px; max-height: 25px;" class="img-thumbnail rounded-circle border-danger">
                        </c:otherwise>
                    </c:choose>


                </div>

                <div class="d-grid gap-2 col-6 ">
                    <form action="AdminUsu?accion=modificar" method="POST" enctype="multipart/form-data">
                        <div class="row g-3 mt-3">
                            <div class="col">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="nombre" value="<%= usuario.getNombre() %>">
                            </div>
                            
                            <div class="col">
                                <div class="row justify-content-start">
                                    <div class="col">
                                        <label>Edad</label>
                                        <input type="number" class="form-control" style="max-width: 100px;" name="edad" value="<%= usuarioImpl.calcularEdad(usuario) %>" readonly focus>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row g-3 mt-3">
                            <div class="col">
                                <label>Apellidos</label>
                                <input type="text" class="form-control" name="nombre" value="<%= usuario.getApellidos() %>">
                            </div>
                            
                            <div class="col">
                                <div class="row justify-content-start">
                                    <div class="col">
                                        <label>Pais</label>
                                        <input type="text" class="form-control" style="max-width: 100px;" name="edad" value="<%= usuario.getPais() %>">
                                    </div>
                                </div>
                            </div>
                        </div>
                                    
                        <div class="row g-3 mt-3">
                            <div class="col">
                                <label>Email</label>
                                <input type="email" class="form-control" name="nombre" value="<%= usuario.getApellidos() %>">
                            </div>
                            
                            <div class="col">
                                <label>Nombre de Usuario</label>
                                <input type="text" class="form-control" name="nombre" value="<%= usuario.getApellidos() %>">
                            </div>
                        </div>
                        
                        <div class="row g-3 mt-3 d-flex align-items-center">
                            <div class="col">
                                <label>Contraseña</label>
                                <input type="password" id="contrasena" class="form-control" name="nombre" value="<%= usuario.getClave() %>"> 
                            </div>
                            
                            <div class="col pt-4">
                               
                                <i class="fa-solid fa-eye btn btn-dark" onclick="mostrarContrasena()"></i>
                               
                            </div>
                        </div>
                        
                        <input class="form-control my-5" name="imagen" type="file" id="formFile">
                        <input type="hidden" value="<%= usuario.getFechaNacimiento() %>"> 
                        <div class="mb-3 row w-100 fs-4">
                            <button type="submit" class="btn btn-primary">Editar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</main>
<jsp:include page="./recursos/footer.jsp" /> 
</body>
<script src="./static/js/mostrarClave.js">
  
</script>

</html>