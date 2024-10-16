<%-- 
    Document   : editResidente
    Created on : 15/10/2024, 7:00:32 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="com.modelo.Residente"%>
<%@page import="com.modeloDAO.ResidenteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Residente</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                  ResidenteDAO dao = new ResidenteDAO();
                  String documento = (String) request.getAttribute("documento");
                  Residente residente = dao.list(documento);
                %>
                <h1>Modificar Residente</h1>
                <form action="controladorResidente">
                    <label for="txtDocumento">Documento:</label>
                    <input class="form-control" type="text" name="txtDocumento" id="txtDocumento" value="<%= residente.getDocumento() %>" readonly><br>

                    <label for="txtNombre">Nombre:</label>
                    <input class="form-control" type="text" name="txtNombre" id="txtNombre" value="<%= residente.getNombre() %>" required><br>

                    <label for="txtEdad">Edad:</label>
                    <input class="form-control" type="number" name="txtEdad" id="txtEdad" value="<%= residente.getEdad() %>" required><br>

                    <label for="txtCorreo">Correo:</label>
                    <input class="form-control" type="email" name="txtCorreo" id="txtCorreo" value="<%= residente.getCorreo() %>" required><br>


                    <input type="hidden" name="documento" value="<%= residente.getDocumento() %>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="controladorResidente?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>



</html>
