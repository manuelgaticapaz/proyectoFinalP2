/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.conexion.conexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos Gatica Paz
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("doPost method called");

        try {
            // Procesa la solicitud
            processRequest(request, response);
            conexionDB conexion = new conexionDB();
            Connection con = null;

            boolean existeUsuario = false;
            boolean esAdmin = false;
            String admin = "";

            // Recupera datos del formulario
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            // Usando MySQL
            con = conexion.getConexionMysql();
            if (con == null) {
                throw new SQLException("No se pudo obtener la conexión a la base de datos.");
            }

            // Cambié la consulta para usar 'usr_activo = 1'
            String consulta = "SELECT * FROM usr_ususarios WHERE usr_email = ? AND usr_contraseña = ? AND usr_activo = 1";

            PreparedStatement pst = con.prepareStatement(consulta);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            // Solo entra al bucle si existen resultados
            while (rs.next()) {
                existeUsuario = true;
                // Asumiendo que el campo usr_es_admin es de tipo boolean o tinyint
                esAdmin = rs.getBoolean("usr_es_admin");

                // Si es admin, asignamos "Administrador" al atributo admin
                if (esAdmin) {
                    admin = "Administrador";
                }
            }

            // Procesamos el resultado
            if (existeUsuario) {
                request.setAttribute("txtEmail", email);
                request.setAttribute("txtAdmin", admin); // asignamos admin como String (o vacío si no es admin)
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }

        } catch (SQLException Ex) {
            logger.log(Level.SEVERE, "Ocurrió una excepción en SQL:", Ex);
            // Opcional: Puedes redirigir a una página de error o mostrar un mensaje
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
