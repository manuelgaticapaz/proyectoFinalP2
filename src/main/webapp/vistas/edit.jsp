<%-- 
    Document   : edit
    Created on : 7 oct 2024, 13:47:44
    Author     : Kenzy
--%>

<%@page import="com.modelo.Usuario"%>
<%@page import="com.modeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
        <link  rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              UsuarioDAO dao=new UsuarioDAO();
              int id=Integer.parseInt((String)request.getAttribute("idUser"));
              Usuario p=(Usuario)dao.list(id);
          %>
            <h1>Modificar Usuario</h1>
            <form action="controlador">
                <label for="txtMail">Mail:</label>
                <input class="form-control" type="email" name="txtMail" id="txtMail" value="<%= p.getMail()%>"><br>
                <label for="txtContrasenia">Contraseña:</label>
                <input class="form-control" type="password" name="txtContrasenia" id="txtContrasenia"  value="<%= p.getContrasenia()%>"><br>
                <label>Administrador:</label>
                <input class="form-check-input" type="checkbox" name="chkAdmin" id="chkAdmin" value="true" <% if (p.getEsAdmin()) out.print("checked"); %> ><br>
                <label>Activo:</label>
                <input class="form-check-input" type="checkbox" name="chkActivo" id="chkActivo" value="true" <% if (p.getEsActivo()) out.print("checked"); %> ><br>
                <input type="hidden" name="txtid" value="<%= p.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="controlador?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
