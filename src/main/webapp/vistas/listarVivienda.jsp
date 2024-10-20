<%-- 
    Document   : listarVivienda
    Created on : 15/10/2024, 10:16:10 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.modelo.Vivienda"%>
<%@page import="java.util.List"%>
<%@page import="com.modeloDAO.ViviendaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viviendas</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <h2>Viviendas</h2>
            <a class="btn btn-success" href="controladorVivienda?accion=add">Agregar Nueva Vivienda</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Dirección</th>
                        <th class="text-center">Tipo</th>
                        <th class="text-center">Número de Habitaciones</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Disponibilidad</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Eliminar</th>
                    </tr>
                </thead>
                <%
                    ViviendaDAO dao = new ViviendaDAO();
                    List<Vivienda> list = dao.listar();
                    Iterator<Vivienda> iter = list.iterator();
                    Vivienda vivienda = null;
                    while (iter.hasNext()) {
                        vivienda = iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= vivienda.getId() %></td>
                        <td class="text-center"><%= vivienda.getDireccion() %></td>
                        <td class="text-center"><%= vivienda.getTipo() %></td>
                        <td class="text-center"><%= vivienda.getNumHabitaciones() %></td>
                        <td class="text-center"><%= vivienda.getPrecio() %></td>
                        <td class="text-center">
                            <input type="checkbox" <%= vivienda.isDisponibilidad() ? "checked" : "" %> disabled>
                        </td>

                        <td class="text-center">
                            <a class="btn btn-warning" href="controladorVivienda?accion=editar&id=<%= vivienda.getId() %>">Editar</a>

                        </td>
                        <td class="text-center">
                            <a class="btn btn-danger" href="controladorVivienda?accion=eliminar&id=<%= vivienda.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>

