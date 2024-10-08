<%-- 
    Document   : add
    Created on : 7 oct 2024, 11:56:13
    Author     : Kenzy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Usuario</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
      
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Usuario</h1>
                <form action="controlador" class="user-form">
                    <label for="txtMail">Mail:</label>
                    <input class="form-control" type="email" name="txtMail" id="txtMail" required><br>

                    <label for="txtContrasenia">Contraseña:</label>
                    <input class="form-control" type="password" name="txtContrasenia" id="txtContrasenia" required><br>

                    <label>Administrador:</label>
                    <input class="form-check-input" type="checkbox" name="chkAdmin" value="true" id="chkAdmin"><br>

                    <label>Activo:</label>
                    <input class="form-check-input" type="checkbox" name="chkActivo" value="true" id="chkActivo"><br>

                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="controlador?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
