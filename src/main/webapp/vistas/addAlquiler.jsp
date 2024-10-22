
<%@page import="com.modeloDAO.AlquilerDAO"%>
<%@page import="com.modelo.Residente"%>
<%@page import="com.modelo.Residente"%>
<%@page import="com.modeloDAO.ResidenteDAO"%>
<%@page import="com.modelo.Vivienda"%>
<%@page import="java.util.List"%>
<%@page import="com.modeloDAO.ViviendaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Alquiler</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Nuevo Alquiler</h1>
                
                <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger">
                        <%= request.getAttribute("error") %>
                    </div>
                <% } %>

                <form action="controladorAlquiler" method="post" class="alquiler-form">
                    
                    <!-- Selección de Vivienda -->
                    <label for="txtIdVivienda">Seleccionar Vivienda Disponible:</label>
                    <select class="form-control" name="txtIdVivienda" id="txtIdVivienda" required>
                        <option value="">Seleccione una vivienda</option>
                        <%
                            ViviendaDAO viviendaDAO = new ViviendaDAO();
                            AlquilerDAO alquilerDAO = new AlquilerDAO();

                            // Obtener lista de viviendas disponibles o recién registradas
                            List<Integer> viviendasDisponiblesORecientes = alquilerDAO.obtenerViviendasDisponiblesORecientes();

                            // Obtener todas las viviendas
                            List<Vivienda> viviendas = viviendaDAO.listar();

                            // Filtrar y mostrar solo las viviendas disponibles o recién registradas
                            for (Vivienda vivienda : viviendas) {
                                if (vivienda.isDisponibilidad() && viviendasDisponiblesORecientes.contains(vivienda.getId())) {
                        %>
                                    <option value="<%= vivienda.getId() %>">
                                        <%= vivienda.getDireccion() %> (ID: <%= vivienda.getId() %>)
                                    </option>
                        <%
                                }
                            }
                        %>
                    </select><br>

                    <!-- Selección de Residente -->
                    <label for="txtDocumentoResidente">Seleccionar Residente:</label>
                    <select class="form-control" name="txtDocumentoResidente" id="txtDocumentoResidente" required>
                        <option value="">Seleccione un residente</option>
                        <%
                            ResidenteDAO residenteDAO = new ResidenteDAO();
                            AlquilerDAO resalquilerDAO = new AlquilerDAO();

                            // Obtener lista de residentes con alquiler activo
                            List<String> residentesConAlquilerActivo = alquilerDAO.obtenerAlquileresActivos();

                            // Obtener todos los residentes
                            List<Residente> residentes = residenteDAO.listar();

                            // Filtrar y mostrar solo los residentes sin alquiler activo
                            for (Residente residente : residentes) {
                                if (!residentesConAlquilerActivo.contains(residente.getDocumento())) {
                        %>
                                    <option value="<%= residente.getDocumento() %>">
                                        <%= residente.getNombre() %> (Documento: <%= residente.getDocumento() %>)
                                    </option>
                        <%
                                }
                            }
                        %>
                    </select><br>

                    <!-- Fecha de Inicio del Alquiler -->
                    <label for="txtFechaInicio">Fecha de Inicio:</label>
                    <input class="form-control" type="date" name="txtFechaInicio" id="txtFechaInicio" required><br>

                    <!-- Fecha de Fin del Alquiler (Opcional) -->
                    <label for="txtFechaFin">Fecha de Fin (Opcional):</label>
                    <input class="form-control" type="date" name="txtFechaFin" id="txtFechaFin"><br>

                    <!-- Campos ocultos para enviar datos sin mostrar nombre y dirección -->
                    <input type="hidden" name="txtIdVivienda" value="<%= request.getParameter("txtIdVivienda") %>">
                    <input type="hidden" name="txtDocumentoResidente" value="<%= request.getParameter("txtDocumentoResidente") %>">

                    <!-- Botones de acción -->
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="controladorAlquiler?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>



