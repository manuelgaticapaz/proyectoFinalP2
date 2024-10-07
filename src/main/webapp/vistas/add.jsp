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
    <body>
      
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Usuario</h1>
                <form action="Controlador">
                    Mail: <br>
                    <input class="form-control" type="text" name="txtMail"><br>
                    Contraseña: <br>
                    <input class="form-control" type="text" name="txtContrasenia"><br>
                    Administrador: <br>
                    <input class="form-check-input" type="checkbox" name="chkAdministrador" value="true" id="chkAdministrador">
                    Activo: <br>
                    <input class="form-check-input" type="checkbox" name="chkActivo" value="true" id="chkActivo">
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a  href="Controlador?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
