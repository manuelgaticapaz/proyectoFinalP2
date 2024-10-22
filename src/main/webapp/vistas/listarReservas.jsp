<%@page import="java.util.List"%>
<%@page import="com.modeloDAO.AlquilerDAO"%>
<%@page import="com.modeloDAO.ReservasDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.modelo.Reservas"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de Reservas</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <%@ include file="/vistas/header.jsp" %>
    <body>
        <div class="container">
            <h2>Historial de Reservas</h2>
            
            <!-- Botón para agregar nueva reserva -->
            <a class="btn btn-success" href="controladorReservas?accion=add">Agregar Nueva Reserva</a>
            <br><br>

            <%
                // Obtenemos el valor de txtAdmin de la sesión
                String adminStatus = (String) session.getAttribute("txtAdmin");
                if (adminStatus == null) {
                    adminStatus = "Usuario"; // Valor por defecto
                }

                // Inicializamos el DAO de Alquiler para obtener alquileres activos
                AlquilerDAO alquilerDAO = new AlquilerDAO();
                List<String> residentesConAlquilerActivo = alquilerDAO.obtenerAlquileresActivos();
                
                // Inicializamos el DAO de Reservas
                ReservasDAO dao = new ReservasDAO();
                List<Reservas> list = null;

                // Si es Administrador, mostramos más opciones
                if ("Administrador".equalsIgnoreCase(adminStatus)) {
            %>

            <!-- Mostrar opciones para el administrador -->
            <form method="GET" action="controladorReservas">
                <input type="hidden" name="accion" value="listar">
                
                <!-- Cambiamos de input text a select para mostrar la lista de alquileres activos -->
                <label for="idAlquiler">Ver historial de un alquiler específico:</label>
                <select name="idAlquiler" id="idAlquiler" class="form-control">
                    <option value="">Seleccione un alquiler</option>
                    <% 
                    if (residentesConAlquilerActivo != null && !residentesConAlquilerActivo.isEmpty()) {
                        for (String alquilerInfo : residentesConAlquilerActivo) {
                            String[] info = alquilerInfo.split("-"); // Separar el id y el documento_residente
                            String idAlquiler = info[0];
                            String documentoResidente = info[1];
                    %>
                        <option value="<%= idAlquiler %>"><%= documentoResidente %></option>
                    <% 
                        } 
                    } else { 
                    %>
                        <option value="">No hay alquileres activos disponibles</option>
                    <% } %>
                </select>

                <br><br>
                
                <button type="submit" class="btn btn-primary">Ver Historial</button>
                <a class="btn btn-success" href="controladorReservas?accion=listar">Ver Todos</a>
            </form>
            <br>

            <%
                // Obtener historial según la entrada del administrador
                String idAlquilerParam = request.getParameter("idAlquiler");
                if (idAlquilerParam != null && !idAlquilerParam.isEmpty()) {
                    // Ver historial de un alquiler específico
                    list = dao.listarPorAlquiler(Integer.parseInt(idAlquilerParam));
                } else {
                    // Ver todo el historial
                    list = dao.listar();
                }
                
            } else {
                // Si es un usuario normal, mostrar su propio historial
                Integer idAlquilerUsuario = (Integer) session.getAttribute("txtIdAlquiler"); // ID Alquiler asociado al usuario
                if (idAlquilerUsuario != null) {
                    // Como ya es un Integer, lo usamos directamente
                    list = dao.listarPorAlquiler(idAlquilerUsuario);
                } else {
                    // Mostrar un mensaje si el usuario no tiene un alquiler asociado
                    out.println("<p>No tienes reservas asociadas.</p>");
                }

            }

            // Verificamos si la lista de reservas tiene contenido
            if (list != null && !list.isEmpty()) {
            %>
                <!-- Tabla para mostrar historial de reservas -->
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">ID</th>
                            <th class="text-center">ID Área</th>
                            <th class="text-center">ID Alquiler</th>
                            <th class="text-center">Fecha Inicio</th>
                            <th class="text-center">Fecha Final</th>
                            <th class="text-center">Nombre Responsable</th>
                            <th class="text-center">Comentario</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Reservas reservacion : list) {
                        %>
                        <tr>
                            <td class="text-center"><%= reservacion.getId() %></td>
                            <td class="text-center"><%= reservacion.getIdArea() %></td>
                            <td class="text-center"><%= reservacion.getIdAlquiler() %></td>
                            <td class="text-center"><%= reservacion.getFechaReservaInicio() %></td>
                            <td class="text-center"><%= reservacion.getFechaReservaFinal() %></td>
                            <td class="text-center"><%= reservacion.getNombreResponsable() %></td>
                            <td class="text-center"><%= reservacion.getComentario() %></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            <%
                } else {
                    // Mostrar un mensaje si no hay reservas
                    out.println("<p>No hay reservas disponibles.</p>");
                }
            %>
        </div>
    </body>
</html>
