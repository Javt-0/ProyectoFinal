<%-- 
    Document   : login
    Created on : 21 feb. 2023, 20:57:39
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <script defer src="/static/js/bienvenida.js"></script>
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
            <a class="navbar-brand font-weight-bold" href="./homeAdmin.jsp">
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
                          
                        <li class="nav-item ms-4">
                          <a class="nav-link" href="./registrar.jsp">Registrarse&nbsp&nbsp<i class="fa-sharp fa-solid fa-align-left"></i></a>
                        </li>
                        <li class="nav-item ms-4">
                          <a class="nav-link" href="./login.jsp">Login&nbsp&nbsp<i class="fa fa-right-to-bracket"></i></a>
                        </li>

                    </ul>
                        
                </div>
            </div>
            
        </div>
    </nav>

      <main class="">

    <div class="container pt-5">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header">Login</div>
            <div class="card-body">
               <%     
                String error = (String) session.getAttribute("error");
                if (error != null) {
                %>
                    <p class="text-danger">
                      <%= error %>
                    </p>
                <%
                }
                error  = null;
                %> 
              <form  method="POST" action="UsuarioControlador?accion=logear">
                <!--Primer campo-->
                <div class="mb-3 row">
                  <label class="col-md-4 col-form-label text-md-end">Nombre de Usuario</label>
                  <div class="col-md-6">
                    <input type="text" name="usuario" class="form-control" autofocus>
                    <!--input type="text" name="usuario" class="form-control" autofocus-->
                  </div>
                </div>
                
                <!--Segundo campo-->
                <div class="mb-3 row">
                  <label class="col-md-4 col-form-label text-md-end">Contraseña</label>
                  <div class="col-md-6">
                    <input type="password" name="clave" class="form-control" autofocus>
                    <!--input type="password" name="clave" class="form-control"  autofocus-->
                  </div>
                </div>
    
                <div class="mb-3 row">
                  <div class="col-md-6 offset-md-4">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-6 offset-md-4">
                    <p class="text-light">
                      ¿No tienes cuenta? <a class="text-primary" href="./registrar.jsp">Registrate</a>
                    </p>
                  </div>
                </div>
                
              </form>
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <jsp:include page="./recursos/footer.jsp" />
</body>
</html>
