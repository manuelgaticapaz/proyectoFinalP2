<%-- 
    Document   : home
    Created on : 1/09/2024, 7:55:13 p. m.
    Author     : Manuel Gatica Paz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*" %>
<% 
    // Configuración de la base de datos
    String url = "jdbc:mysql://localhost:3306/mydb";
    String user = "root"; // Cambia según tu configuración
    String password = ""; // Cambia según tu configuración

    // Obtener datos del formulario
    String email = request.getParameter("email");
    String inputPassword = request.getParameter("password");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Cargar el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establecer la conexión
        conn = DriverManager.getConnection(url, user, password);

        // Consulta para obtener la contraseña hasheada y el estado del usuario
        String sql = "SELECT usr_password, usr_activo FROM usr_usuarios WHERE usr_email = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            // Obtener la contraseña hasheada y el estado
            String hashedPassword = rs.getString("usr_password");
            boolean active = rs.getBoolean("usr_activo");

            // Verificar la contraseña
            boolean passwordMatches = inputPassword.equals(hashedPassword);

            if (passwordMatches && active) {
                // Autenticación exitosa
                response.sendRedirect("home.jsp");
            } else {
                // Contraseña incorrecta o cuenta inactiva
                out.println("Credenciales incorrectas o cuenta inactiva.");
            }
        } else {
            // Usuario no encontrado
            out.println("No se encontró el usuario.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error en la conexión con la base de datos: " + e.getMessage());
    } finally {
        // Cerrar recursos
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <header>
	<nav class="navigation">
		<a href="#">Mi Vivienda</a>
		<a href="#">Reservar</a>
        <a href="#">Estado de Cuenta (<%= "user"%>)</a>
		<a href="index.html">Salir</a>
        </nav>	
    </header>
    <body>
        <h2></h2>
    </body>
</html>

