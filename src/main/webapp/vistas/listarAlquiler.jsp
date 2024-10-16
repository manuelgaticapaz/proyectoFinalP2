<%-- 
    Document   : listarAlquiler
    Created on : 15/10/2024, 10:39:51 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.modelo.Alquiler"%>
<%@page import="java.util.List"%>
<%@page import="com.modeloDAO.AlquilerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alquileres</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <h2>Alquileres</h2>
            <a class="btn btn-success" href="controladorAlquiler?accion=add">Agregar Nuevo Alquiler</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">ID Vivienda</th>
                        <th class="text-center">Documento Residente</th>
                        <th class="text-center">Fecha Inicio</th>
                        <th class="text-center">Fecha Fin</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Eliminar</th>
                    </tr>
                </thead>
                <%
                    AlquilerDAO dao = new AlquilerDAO();
                    List<Alquiler> list = dao.listar();
                    Iterator<Alquiler> iter = list.iterator();
                    Alquiler alquiler = null;
                    while (iter.hasNext()) {
                        alquiler = iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= alquiler.getId() %></td>
                        <td class="text-center"><%= alquiler.getIdVivienda() %></td>
                        <td class="text-center"><%= alquiler.getDocumentoResidente() %></td>
                        <td class="text-center"><%= alquiler.getFechaInicio() %></td>
                        <td class="text-center"><%= alquiler.getFechaFin() != null ? alquiler.getFechaFin() : "Sin Fin" %></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="controladorAlquiler?accion=editar&id=<%= alquiler.getId() %>">Editar</a>
                        </td>
                        <td class="text-center">
                            <a class="btn btn-danger" href="controladorAlquiler?accion=eliminar&id=<%= alquiler.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>

