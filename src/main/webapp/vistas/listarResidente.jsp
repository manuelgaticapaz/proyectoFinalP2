<%-- 
    Document   : listarResidente
    Created on : 15/10/2024, 6:38:03 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.modelo.Residente"%>
<%@page import="java.util.List"%>
<%@page import="com.modeloDAO.ResidenteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Residentes</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <h2>Residentes</h2>
            <a class="btn btn-success" href="controladorResidente?accion=add">Agregar Nuevo Residente</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Documento</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Edad</th>
                        <th class="text-center">Correo</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Eliminar</th>
                    </tr>
                </thead>
                <%
                    ResidenteDAO dao = new ResidenteDAO();
                    List<Residente> list = dao.listar();
                    Iterator<Residente> iter = list.iterator();
                    Residente residente = null;
                    while (iter.hasNext()) {
                        residente = iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= residente.getDocumento() %></td>
                        <td class="text-center"><%= residente.getNombre() %></td>
                        <td class="text-center"><%= residente.getEdad() %></td>
                        <td class="text-center"><%= residente.getCorreo() %></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="controladorResidente?accion=editar&documento=<%= residente.getDocumento() %>">Editar</a>
                        </td>
                        <td class="text-center">
                            <a class="btn btn-danger" href="controladorResidente?accion=eliminar&documento=<%= residente.getDocumento() %>">Eliminar</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>

</html>
