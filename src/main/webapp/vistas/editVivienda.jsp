<%-- 
    Document   : editVivienda
    Created on : 15/10/2024, 10:29:43 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="com.modelo.Vivienda"%>
<%@page import="com.modeloDAO.ViviendaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Vivienda</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                  ViviendaDAO dao = new ViviendaDAO();
                  int id = (Integer) request.getAttribute("idVivienda");
                  Vivienda vivienda = dao.list(id);
                %>
                <h1>Modificar Vivienda</h1>
                <form action="controladorVivienda">
                    <label for="txtId">ID:</label>
                    <input class="form-control" type="text" name="txtId" id="txtId" value="<%= vivienda.getId() %>" readonly><br>

                    <label for="txtDireccion">Dirección:</label>
                    <input class="form-control" type="text" name="txtDireccion" id="txtDireccion" value="<%= vivienda.getDireccion() %>" required><br>

                    <label for="txtTipo">Tipo:</label>
                    <input class="form-control" type="text" name="txtTipo" id="txtTipo" value="<%= vivienda.getTipo() %>" required><br>

                    <label for="txtNumHabitaciones">Número de Habitaciones:</label>
                    <input class="form-control" type="number" name="txtNumHabitaciones" id="txtNumHabitaciones" value="<%= vivienda.getNumHabitaciones() %>" required><br>

                    <label for="txtPrecio">Precio:</label>
                    <input class="form-control" type="number" step="0.01" name="txtPrecio" id="txtPrecio" value="<%= vivienda.getPrecio() %>" required><br>

                    <label for="chkDisponibilidad">Disponibilidad:</label>
                    <input type="checkbox" name="chkDisponibilidad" id="chkDisponibilidad" value="true" <%= vivienda.isDisponibilidad() ? "checked" : "" %>><br>

                    <input type="hidden" name="id" value="<%= vivienda.getId() %>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="controladorVivienda?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>

