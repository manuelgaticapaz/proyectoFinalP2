<%-- 
    Document   : addAreasComunes
    Created on : 15/10/2024, 9:00:03 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Amenidad</title><link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Área Común</h1>
                <form action="controladorAreasComunes" method="post" class="areascomunes-form">
                    <label for="txtCodigo">Código:</label>
                    <input class="form-control" type="text" name="txtCodigo" id="txtCodigo" required><br>

                    <label for="txtTipo">Tipo:</label>
                    <select class="form-control" name="txtTipo" id="txtTipo" required>
                        <option value="piscina">Piscina</option>
                        <option value="gimnasio">Gimnasio</option>
                        <option value="sala">Sala</option>
                        <option value="parrilla">Parrilla</option>
                        <option value="sauna">Sauna</option>
                    </select><br>

                    <label for="txtUbicacion">Ubicación:</label>
                    <input class="form-control" type="text" name="txtUbicacion" id="txtUbicacion" required><br>

                    <label for="txtCapacidad">Capacidad:</label>
                    <input class="form-control" type="number" name="txtCapacidad" id="txtCapacidad" required><br>

                    <label for="txtEstado">Estado:</label>
                    <select class="form-control" name="txtEstado" id="txtEstado" required>
                        <option value="disponible">Disponible</option>
                        <option value="mantenimiento">En Mantenimiento</option>
                    </select><br>

                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="controladorAreasComunes?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>

</html>
