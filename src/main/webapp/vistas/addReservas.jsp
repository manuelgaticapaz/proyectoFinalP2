<%@page import="com.modeloDAO.ReservasDAO"%>
<%@page import="com.modeloDAO.AreasComunesDAO"%>
<%@page import="com.modelo.AreasComunes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Reserva</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Nueva Reserva</h1>
                
                <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger">
                        <%= request.getAttribute("error") %>
                    </div>
                <% } %>

                <form action="controladorReservas" method="post" class="reserva-form">
                    
                    <!-- Campo oculto para idAlquiler (obtenido de la sesión) -->
                    <%
                        Integer idAlquiler = (Integer) session.getAttribute("txtIdAlquiler");
                    %>
                    <input type="hidden" name="txtIdAlquiler" value="<%= idAlquiler %>">

                    <!-- Fecha de Inicio de la Reserva -->
                    <label for="txtFechaReservaInicio">Fecha y Hora de Inicio:</label>
                    <input class="form-control" type="datetime-local" name="txtFechaReservaInicio" id="txtFechaReservaInicio" required><br>

                    <!-- Fecha de Fin de la Reserva -->
                    <label for="txtFechaReservaFinal">Fecha y Hora de Fin:</label>
                    <input class="form-control" type="datetime-local" name="txtFechaReservaFinal" id="txtFechaReservaFinal" required><br>

                    <!-- Botón para verificar disponibilidad de áreas -->
                    <input class="btn btn-primary" type="submit" name="accion" value="Verificar Disponibilidad">
                </form>

                <% 
                // Verificar si se han recibido áreas disponibles después de la verificación
                List<AreasComunes> areasDisponibles = (List<AreasComunes>) request.getAttribute("areasDisponibles");
                if (areasDisponibles != null && !areasDisponibles.isEmpty()) {
                %>
                    <h2>Áreas Disponibles:</h2>
                    <form action="controladorReservas" method="post">
                        <!-- Campo oculto para idAlquiler -->
                        <input type="hidden" name="txtIdAlquiler" value="<%= idAlquiler %>">
                        <input type="hidden" name="txtFechaReservaInicio" value="<%= request.getParameter("txtFechaReservaInicio") %>">
                        <input type="hidden" name="txtFechaReservaFinal" value="<%= request.getParameter("txtFechaReservaFinal") %>">

                        <!-- Mostrar las áreas disponibles -->
                        <label for="txtIdArea">Seleccionar Área:</label>
                        <select class="form-control" name="txtIdArea" id="txtIdArea" required>
                            <option value="">Seleccione un área</option>
                            <% for (AreasComunes area : areasDisponibles) { %>
                                <option value="<%= area.getId() %>"><%= area.getCodigo() %> (ID: <%= area.getId() %>)</option>
                            <% } %>
                        </select><br>

                        <!-- Nombre del Responsable -->
                        <label for="txtNombreResponsable">Nombre del Responsable:</label>
                        <input class="form-control" type="text" name="txtNombreResponsable" id="txtNombreResponsable" required><br>

                        <!-- Comentario Opcional -->
                        <label for="txtComentario">Comentario (Opcional):</label>
                        <textarea class="form-control" name="txtComentario" id="txtComentario" rows="3"></textarea><br>

                        <!-- Botones de acción -->
                        <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                        <a href="controladorReservas?accion=listar" class="link-info">Regresar</a>
                    </form>
                <% } else if (request.getParameter("accion") != null) { %>
                    <!-- Mostrar mensaje si no hay áreas disponibles -->
                    <p>Intente con otras fechas.</p>
                <% } %>
            </div>
        </div>
    </body>
</html>
