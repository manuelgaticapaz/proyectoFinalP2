<%-- 
    Document   : addVivienda
    Created on : 15/10/2024, 10:22:33 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Vivienda</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Vivienda</h1>
                <form action="controladorVivienda" method="post" class="vivienda-form">
                    <label for="txtDireccion">Dirección:</label>
                    <input class="form-control" type="text" name="txtDireccion" id="txtDireccion" required><br>

                    <label for="txtTipo">Tipo:</label>
                    <input class="form-control" type="text" name="txtTipo" id="txtTipo" required><br>

                    <label for="txtNumHabitaciones">Número de Habitaciones:</label>
                    <input class="form-control" type="number" name="txtNumHabitaciones" id="txtNumHabitaciones" required><br>

                    <label for="txtPrecio">Precio:</label>
                    <input class="form-control" type="number" step="0.01" name="txtPrecio" id="txtPrecio" required><br>

                    <label for="chkDisponibilidad">Disponibilidad:</label>
                    <input type="checkbox" name="chkDisponibilidad" id="chkDisponibilidad" value="true"><br>

                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="controladorVivienda?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>

