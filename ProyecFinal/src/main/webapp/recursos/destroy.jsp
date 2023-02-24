<%-- 
    Document   : destroy
    Created on : 22 feb. 2023, 12:01:35
    Author     : jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(false);
    
    sesion.invalidate();
    
    response.sendRedirect("../index.jsp");
%>
