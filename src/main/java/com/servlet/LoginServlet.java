package com.servlet;

import com.conexion.conexionDB;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for handling user login.
 */
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Processing login request...");

        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");

        try (Connection con = new conexionDB().getConexionMysql()) {
            if (con == null) {
                throw new SQLException("Unable to connect to the database.");
            }

            String query = "SELECT usr_es_admin FROM usr_ususarios WHERE usr_email = ? AND usr_contraseña = ? AND usr_activo = 1";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, email);
                pst.setString(2, password);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        boolean isAdmin = rs.getBoolean("usr_es_admin");
                        // Establecemos los atributos para el header
                        request.setAttribute("txtEmail", email);
                        request.setAttribute("txtAdmin", isAdmin ? "Administrador" : "");
                        
                        // Redirigimos a home.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        request.getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "SQL error occurred:", ex);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for user login.";
    }
}
