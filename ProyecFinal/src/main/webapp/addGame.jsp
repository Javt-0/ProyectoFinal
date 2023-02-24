<%-- 
    Document   : addGame
    Created on : 23 feb. 2023, 21:29:45
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="./recursos/headerAdmin.jsp" />
 <div class="container pt-5">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header">Registrate</div>
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
                    %> 
                    
                  <form method="POST" action="VideojuegoControlador?accion=add">
                    
                    <!--Primer campo-->
                    <div class="mb-3 row">
                      <label class="col-md-4 col-form-label text-md-end">Nombre del juego</label>
                      <div class="col-md-6">
                        <input type="text" name="nombre" class="form-control" autofocus>
                        <!--input type="text" name="usuario" class="form-control" autofocus-->
                      </div>
                    </div>
                    
                    <!--Segundo campo-->
                    <div class="mb-3 row">
                      <label class="col-md-4 col-form-label text-md-end">Precio</label>
                      <div class="col-md-6">
                        <input type="text" name="precio" class="form-control" autofocus>
                        <!--input type="text" name="usuario" class="form-control" autofocus-->
                      </div>
                    </div>
                    

                    <!--Tercer campo-->
                    <div class="mb-3 row">
                      <label class="col-md-4 col-form-label text-md-end">Stock</label>
                      <div class="col-md-6">
                        <input type="number" name="stock" class="form-control" autofocus>
                        <!--input type="text" name="usuario" class="form-control" autofocus-->
                      </div>
                    </div>

                    <!--Cuarto campo-->
                    <div class="mb-3 row">
                      <label class="col-md-4 col-form-label text-md-end">Descripcion</label>
                      <div class="col-md-6">
                        <input type="text" name="descripcion" class="form-control" autofocus>
                        <!--input type="text" name="usuario" class="form-control" autofocus-->
                      </div>
                    </div>

                    <div class="mb-3 row">
                      <div class="col-md-6 offset-md-4">
                        <button type="submit" class="btn btn-primary">Añadir</button>
                      </div>
                    </div>

                    <div class="row">
                      <div class="col-md-6 offset-md-4">
                        
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