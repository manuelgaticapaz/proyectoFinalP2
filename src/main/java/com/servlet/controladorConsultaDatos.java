package com.servlet;
import com.conexion.conexionDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/consultarDatos")
public class controladorConsultaDatos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            String email = (String) session.getAttribute("txtEmail");
            String adminStatus = (String) session.getAttribute("txtAdmin");
            if (adminStatus == null) {
                adminStatus = "Usuario";  // Asigna un valor por defecto si no es administrador
            }
            request.setAttribute("adminStatus", adminStatus);

            Integer idAlquiler = (Integer) session.getAttribute("txtIdAlquiler");
            Integer idVivienda = (Integer) session.getAttribute("txtIdVivienda");
            Long idResidente = (Long) session.getAttribute("txtIdResidente");

            // Verificar si todos los atributos están presentes en la sesión
            if (idAlquiler == null || idVivienda == null || idResidente == null) {
                // Si alguno de los atributos es nulo, redirigir a una página de error o manejar el error
                response.sendRedirect("/error.jsp");
                return;
            }

            try (Connection con = new conexionDB().getConexionMysql()) {
                if (con == null) {
                    throw new SQLException("Unable to connect to the database.");
                }

                // Obtener más detalles de la vivienda
                String queryVivienda = "SELECT direccion, tipo, num_habitaciones, precio FROM vivienda WHERE id = ?";
                PreparedStatement pstVivienda = con.prepareStatement(queryVivienda);
                pstVivienda.setInt(1, idVivienda);

                ResultSet rsVivienda = pstVivienda.executeQuery();
                if (rsVivienda.next()) {
                    String direccion = rsVivienda.getString("direccion");
                    String tipoVivienda = rsVivienda.getString("tipo");
                    int numHabitaciones = rsVivienda.getInt("num_habitaciones");
                    double precio = rsVivienda.getDouble("precio");

                    // Consultar datos adicionales del residente
                    String queryResidente = "SELECT nombre, edad, correo FROM residente WHERE documento = ?";
                    PreparedStatement pstResidente = con.prepareStatement(queryResidente);
                    pstResidente.setLong(1, idResidente);

                    ResultSet rsResidente = pstResidente.executeQuery();
                    if (rsResidente.next()) {
                        String nombreResidente = rsResidente.getString("nombre");
                        int edadResidente = rsResidente.getInt("edad");
                        String correoResidente = rsResidente.getString("correo");

                        // Enviar los datos al JSP a través de request.setAttribute
                        request.setAttribute("email", email);
                        request.setAttribute("adminStatus", adminStatus);
                        request.setAttribute("nombreResidente", nombreResidente);
                        request.setAttribute("idResidente", idResidente);
                        request.setAttribute("edadResidente", edadResidente);
                        request.setAttribute("correoResidente", correoResidente);
                        request.setAttribute("direccion", direccion);
                        request.setAttribute("tipoVivienda", tipoVivienda);
                        request.setAttribute("numHabitaciones", numHabitaciones);
                        request.setAttribute("precio", precio);

                        // Redirigir al JSP (listarDatosUsuario.jsp)
                        request.getRequestDispatcher("/vistas/listarDatosUsuario.jsp").forward(request, response);
                    } else {
                        // Si no se encuentran datos del residente, redirigir a una página de error
                        request.setAttribute("errorMsg", "No se encontraron datos del residente.");
                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                } else {
                    // Si no se encuentran datos de la vivienda, redirigir a una página de error
                    request.setAttribute("errorMsg", "No se encontraron datos de la vivienda.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                throw new ServletException("Error SQL: " + ex.getMessage(), ex);
            }
        } else {
            // Si no hay sesión, redirigir al login o a la página de inicio
            response.sendRedirect("/home.jsp");
        }
    }
}
