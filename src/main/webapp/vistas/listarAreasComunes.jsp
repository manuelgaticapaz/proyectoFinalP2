<%-- 
    Document   : listarAreasComunes
    Created on : 15/10/2024, 6:36:00 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.modelo.AreasComunes"%>
<%@page import="java.util.List"%>
<%@page import="com.modeloDAO.AreasComunesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Areas Comunes</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
<body>
    <div class="container">
        <h2>Áreas Comunes</h2>
        <a class="btn btn-success" href="controladorAreasComunes?accion=add">Agregar Nueva Área</a>
        <br>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">Código</th>
                    <th class="text-center">Tipo</th>
                    <th class="text-center">Ubicación</th>
                    <th class="text-center">Capacidad</th>
                    <th class="text-center">Estado</th>
                    <th class="text-center">Editar</th>
                    <th class="text-center">Eliminar</th>
                </tr>
            </thead>
            <%
                AreasComunesDAO dao = new AreasComunesDAO();
                List<AreasComunes> list = dao.listar();
                Iterator<AreasComunes> iter = list.iterator();
                AreasComunes area = null;
                while (iter.hasNext()) {
                    area = iter.next();
            %>
            <tbody>
                <tr>
                    <td class="text-center"><%= area.getId() %></td>
                    <td class="text-center"><%= area.getCodigo() %></td>
                    <td class="text-center"><%= area.getTipo() %></td>
                    <td class="text-center"><%= area.getUbicacion() %></td>
                    <td class="text-center"><%= area.getCapacidad() %></td>
                    <td class="text-center"><%= area.getEstado() %></td>
                    <td class="text-center">
                        <a class="btn btn-warning" href="controladorAreasComunes?accion=editar&id=<%= area.getId() %>">Editar</a>
                    </td>
                    <td class="text-center">
                        <a class="btn btn-danger" href="controladorAreasComunes?accion=eliminar&id=<%= area.getId() %>">Eliminar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>

</html>
