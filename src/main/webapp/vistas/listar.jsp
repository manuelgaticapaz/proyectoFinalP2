<%-- 
    Document   : listar
    Created on : 4 oct 2024, 20:05:11
    Author     : Kenzy
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Usuario"%>
<%@page import="com.modeloDAO.UsuarioDAO"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <div class="container">
            <h2>Usuarios</h2>
            <a class="btn btn-success" href="Controlador?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">MAIL</th>
                        <th class="text-center">PASS</th>
                        <th class="text-center">ADMINISTRADOR</th>
                        <th class="text-center">ACTIVO</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Eliminar</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao=new UsuarioDAO();
                    List<Usuario>list=dao.listar();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario usr=null;
                    while(iter.hasNext()){
                        usr=iter.next();
                    
                %>

                <tbody>
                    <tr>
                        <td class="text-center"><%= usr.getId()%></td>
                        <td class="text-center"><%= usr.getMail()%></td>
                        <td class="text-center"><%= usr.getContrasenia()%></td>
                        <td class="text-center"><%= usr.getEsAdmin()%></td>
                        <td class="text-center"><%= usr.getEsActivo()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= usr.getId()%>">Editar</a>
                        </td>
                         <td class="text-center">
                            <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= usr.getId()%>">Eliminar</a>
                        </td>                       
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
