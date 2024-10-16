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
                    //HttpSession session = request.getSession(false); // Obtener la sesión existente
                    String email = (session != null) ? (String) session.getAttribute("txtEmail") : null;
                    String admin = (session != null) ? (String) session.getAttribute("txtAdmin") : null;

                    // Mostrar enlaces de navegación según el rol de usuario
                    if ("Administrador".equals(admin)) {
                %>
                    <a href="controlador?accion=listar">Usuarios</a>
                    <a href="controladorResidente?accion=listar">Residentes</a>
                    <a href="controladorVivienda?accion=listar">Viviendas</a>
                    <a href="controladorAlquiler?accion=listar">Alquiler</a>
                    <a href="controladorAreasComunes?accion=listar">Amenidades</a>
                <%
                    }
                %>
                <a href="home.jsp" style="font-weight: bold; color: red;  padding: 5px; border-radius: 5px;">Inicio</a>
                <a href="#">Mi Vivienda</a>
                <a href="#">Reservar</a>
                <a href="#">Estado de Cuenta (<%= email != null ? email : "invitado" %>)</a>
                <a href="index.jsp">Salir</a>
            </nav>
        </header>

    </body>
</html>
