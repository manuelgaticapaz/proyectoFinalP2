<%-- 
    Document   : home
    Created on : 1/09/2024, 7:55:13 p. m.
    Author     : Manuel Gatica Paz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <header>
                        <%
                    if (request.getAttribute("txtAdmin") == "Administrador"){
                    %>
        <nav class = "navigation">
                <a class="btn btn-success btn-lg" href="controlador?accion=listar">Usuarios</a>
                <a href="#">Viviendas</a>
                <a href="#">Amenidades</a>
        </nav>
                    <%
                    }
                %>
	<nav class="navigation">
                <a href="#">Mi Vivienda</a>
		<a href="#">Reservar</a>
                <a href="#">Estado de Cuenta (<%= request.getAttribute("txtEmail")%>)</a>
		<a href="index.jsp">Salir</a>
        </nav>	
    </header>
    <body>
        <h2></h2>
    </body>
</html>

