<%-- 
    Document   : headerUsu
    Created on : 21 feb. 2023, 22:30:55
    Author     : jonat
--%>
<%@page import="com.proyecto.dominio.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Roboto:400,700&display=swap" rel="stylesheet">
    <!-- Bootstrap -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" 
        crossorigin="anonymous">
    </script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.2/darkly/bootstrap.min.css" 
        integrity="sha512-8RiGzgobZQmqqqJYja5KJzl9RHkThtwqP1wkqvcbbbHNeMXJjTaBOR+6OeuoxHhuDN5h/VlgVEjD7mJu6KNQXA=="
        crossorigin="anonymous" 
        referrerpolicy="no-referrer" 
    />
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

     <!-- contenidos estaticos -->
    <link rel="stylesheet" href="./static/css/index.css">
    <link rel="stylesheet" href="./lb/icon/css/all.min.css">

    <%
    String rutaAbsoluta = request.getRequestURI();
    if (rutaAbsoluta.equals("/ProyectoFinal/") || rutaAbsoluta.equals("/ProyectoFinal/index.jsp")) {
    %>
        <script defer src="./static/js/bienvenida.js"></script>
    <%
    }
    %>

    <title>App Videojuegos</title>
</head>

<body>
    <div>
        
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark backg">
        <div class="container-fluid">
            <a class="navbar-brand font-weight-bold" href="./homeUser.jsp">
                <img class="mr-2" src="./static/img/logo.png" />
                App
            </a>
            <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="d-flex justify-content-between w-100">
                    <ul class="navbar-nav">
                        <%
                        Usuarios usuario = (Usuarios) session.getAttribute("usuario");
                        if (usuario.getNombreUsuario() != null) {
                        %>
                          <li class="nav-item ms-4">
                            <a class="nav-link" href="./carrito.jsp">Mi Carrito&nbsp&nbsp&nbsp<i class="fa-solid fa-cart-shopping"></i></a>
                          </li>
                          
                          <li class="nav-item ms-4">
                            <a class="nav-link text-danger" href="./recursos/destroy.jsp">Cerrar Sesion&nbsp&nbsp<i class="fa-sharp fa-solid fa-power-off"></i></a>
                          </li>
                        <%
                        } else {
                        %>
                          <li class="nav-item ms-4">
                            <a class="nav-link" href="./registrar.jsp">Registrarse</a>
                          </li>
                          <li class="nav-item ms-4">
                            <a class="nav-link" href="./login.jsp">Login&nbsp&nbsp<i class="fa fa-right-to-bracket"></i></a>
                          </li>
                        <%
                        }
                        %>
                        </ul>
                        <%
                        if (usuario.getNombreUsuario() != null) {
                        %>
                          <div class="p-2">
                            <a href="./perfil.jsp" style="text-decoration: none;"> <img src="<%= usuario.getImgPerfil() %>" class="rounded-circle" style=" border-radius: 50%; max-width: 90px; max-height: 90px;"> &nbsp&nbsp<%= usuario.getEmail() %></a> 
                          </div>
                        <%
                        }
                        %>
                </div>
            </div>
            
        </div>
    </nav>

      <main class="">
