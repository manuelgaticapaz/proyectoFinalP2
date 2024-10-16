<%-- 
    Document   : addResidente
    Created on : 15/10/2024, 7:04:59 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Residente</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Residente</h1>
                <form action="controladorResidente" method="post" class="residente-form">
                    <label for="txtDocumento">Documento:</label>
                    <input class="form-control" type="text" name="txtDocumento" id="txtDocumento" required><br>

                    <label for="txtNombre">Nombre:</label>
                    <input class="form-control" type="text" name="txtNombre" id="txtNombre" required><br>

                    <label for="txtEdad">Edad:</label>
                    <input class="form-control" type="number" name="txtEdad" id="txtEdad" required><br>

                    <label for="txtCorreo">Correo:</label>
                    <input class="form-control" type="email" name="txtCorreo" id="txtCorreo" required><br>

                    

                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="controladorResidente?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>

</html>
