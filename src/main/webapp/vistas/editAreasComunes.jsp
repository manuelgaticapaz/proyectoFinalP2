<%-- 
    Document   : editAreasComunes
    Created on : 15/10/2024, 9:33:35 p. m.
    Author     : Marcos Gatica Paz
--%>

<%@page import="com.modelo.AreasComunes"%>
<%@page import="com.modeloDAO.AreasComunesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Amenidad</title>
    <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                  AreasComunesDAO dao = new AreasComunesDAO();
                  int id = Integer.parseInt((String) request.getAttribute("id"));
                  AreasComunes area = dao.list(id);
                %>
                <h1>Modificar Área Común</h1>
                <form action="controladorAreasComunes">
                    <label for="txtCodigo">Código:</label>
                    <input class="form-control" type="text" name="txtCodigo" id="txtCodigo" value="<%= area.getCodigo() %>" required><br>

                    <label for="txtTipo">Tipo:</label>
                    <select class="form-control" name="txtTipo" id="txtTipo" required>
                        <option value="piscina" <%= area.getTipo().equals("Piscina") ? "selected" : "" %>>Piscina</option>
                        <option value="gimnasio" <%= area.getTipo().equals("Gimnasio") ? "selected" : "" %>>Gimnasio</option>
                        <option value="sala" <%= area.getTipo().equals("Sala") ? "selected" : "" %>>Sala</option>
                        <option value="parrilla" <%= area.getTipo().equals("Parrilla") ? "selected" : "" %>>Parrilla</option>
                        <option value="sauna" <%= area.getTipo().equals("Sauna") ? "selected" : "" %>>Sauna</option>
                    </select><br>

                    <label for="txtUbicacion">Ubicación:</label>
                    <input class="form-control" type="text" name="txtUbicacion" id="txtUbicacion" value="<%= area.getUbicacion() %>" required><br>

                    <label for="txtCapacidad">Capacidad:</label>
                    <input class="form-control" type="number" name="txtCapacidad" id="txtCapacidad" value="<%= area.getCapacidad() %>" required><br>

                    <label for="txtEstado">Estado:</label>
                    <select class="form-control" name="txtEstado" id="txtEstado" required>
                        <option value="disponible" <%= area.getEstado().equals("Disponible") ? "selected" : "" %>>Disponible</option>
                        <option value="mantenimiento" <%= area.getEstado().equals("Mantenimiento") ? "selected" : "" %>>En Mantenimiento</option>
                    </select><br>

                    <input type="hidden" name="id" value="<%= area.getId() %>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="controladorAreasComunes?accion=listar" class="link-info">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
