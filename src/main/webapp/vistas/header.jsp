<%-- 
    Document   : header
    Created on : 7 oct 2024, 16:20:32
    Author     : Kenzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <nav class="navigation">
            <%
                Boolean esAdmin = false;
                String mail = (String) request.getAttribute("txtEmail");
                String admin = (String) request.getAttribute("txtAdmin");
                if ("Administrador".equals(admin)) {
                    esAdmin = true;
            %>
                <a href="controlador?accion=listar">Usuarios</a>
                <a href="#">Arrendantes</a>
                <a href="#">Viviendas</a>
                <a href="#">Alquiler</a>
                <a href="#">Amenidades</a>
            <%
                }
            %>
            
                <a href="#">Mi Vivienda</a>
                <a href="#">Reservar</a>
                <a href="#">Estado de Cuenta (<%= mail %>)</a>
                <a href="index.jsp">Salir</a>
            </nav>
                <input type="hidden" name="txtMail" value="<%= mail %>">
                <input type="hidden" name="txtAdmin" value="<%= esAdmin %>">
            
        </header>
    </body>
</html>
