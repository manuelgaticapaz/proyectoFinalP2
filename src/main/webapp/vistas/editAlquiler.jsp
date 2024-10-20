<%-- 
    Document   : editAlquiler
    Created on : 16/10/2024, 7:23:32 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="com.modelo.Alquiler"%>
<%@page import="com.modeloDAO.AlquilerDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Alquiler</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                  // Obtener los datos del alquiler por ID desde el controlador
                  AlquilerDAO alquilerDAO = new AlquilerDAO();
                  int idAlquiler = Integer.parseInt(request.getParameter("id"));
                  Alquiler alquiler = alquilerDAO.list(idAlquiler);
                %>
                <h1>Modificar Alquiler</h1>
                
                <form action="controladorAlquiler" method="post" class="alquiler-form">
                    <!-- Campo oculto para el ID del Alquiler -->
                    <input type="hidden" name="id" value="<%= alquiler.getId() %>">

                    <!-- Campo oculto para el ID de la vivienda -->
                    <input type="hidden" name="idVivienda" value="<%= alquiler.getId() %>">

                    <!-- Campo oculto para el documento del residente -->
                    <input type="hidden" name="documentoResidente" value="<%= alquiler.getDocumentoResidente() %>">

                    <label for="txtDocumentoResidente">Documento Residente:</label>
                    <input class="form-control" type="text" name="txtDocumentoResidente" id="txtDocumentoResidente" value="<%= alquiler.getDocumentoResidente() %>" readonly><br>
                    <!-- Fecha de Inicio del Alquiler (Solo lectura) -->
                    <label for="txtFechaInicio">Fecha de Inicio:</label>
                    <input class="form-control" type="date" name="txtFechaInicio" id="txtFechaInicio" value="<%= alquiler.getFechaInicio() %>" readonly><br>

                    <!-- Fecha de Fin del Alquiler (Editable) -->
                    <label for="txtFechaFin">Fecha de Fin:</label>
                    <input class="form-control" type="date" name="txtFechaFin" id="txtFechaFin" value="<%= alquiler.getFechaFin() != null ? alquiler.getFechaFin() : "" %>"><br>

                    <!-- Botones de acción -->
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="controladorAlquiler?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>



