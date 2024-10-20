<%-- 
    Document   : listarDatosUsuario
    Created on : 19 oct 2024, 21:25:15
    Author     : Kenzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Perfil</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <h3>Datos del Usuario</h3>
                <p><strong>Email:</strong> ${email}</p>
                <p><strong>Rol:</strong> ${adminStatus != null ? adminStatus : "Usuario"}</p>
                <p><strong>Nombre:</strong> ${nombreResidente}</p>
                <p><strong>Documento:</strong> ${idResidente}</p>
                <p><strong>Edad:</strong> ${edadResidente}</p>
                <p><strong>Correo:</strong> ${correoResidente}</p>

                <h3>Datos de la Vivienda</h3>
                <p><strong>Dirección:</strong> ${direccion}</p>
                <p><strong>Tipo de Vivienda:</strong> ${tipoVivienda}</p>
                <p><strong>Número de Habitaciones:</strong> ${numHabitaciones}</p>
                <p><strong>Precio:</strong> $${precio}</p>
        </div>
    </body> 
</html>
