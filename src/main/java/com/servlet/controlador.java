/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.modelo.Usuario;
import com.modeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kenzy
 */
public class controlador extends HttpServlet {
    
    

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Usuario p=new Usuario();
    
    UsuarioDAO dao=new UsuarioDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        } if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String mail=request.getParameter("txtMail");
            String contrasenia=request.getParameter("txtContrasenia");
            String admin = request.getParameter("chkAdmin");
            Boolean esAdmin = (admin != null && admin.equals("true"));
            String activo = request.getParameter("chkActivo");
            Boolean esActivo = (activo != null && activo.equals("true"));
            p.setMail(mail);
            p.setContrasenia(contrasenia);
            p.setEsAdmin(esAdmin);
            p.setEsActivo(esActivo);
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idUser",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String mail=request.getParameter("txtMail");
            String contrasenia=request.getParameter("txtContrasenia");
            String admin = request.getParameter("chkAdmin");
            Boolean esAdmin = (admin != null && admin.equals("true"));
            String activo = request.getParameter("chkActivo");
            Boolean esActivo = (activo != null && activo.equals("true"));
            p.setId(id);
//            p.setMail(mail);
            p.setContrasenia(contrasenia);
            p.setEsAdmin(esAdmin);
            p.setEsActivo(esActivo);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
            String mail = request.getParameter("txtMail");
            String admin = request.getParameter("txtAdmin"); // Esto será un string que representa un boolean

            // Puedes convertirlo a booleano si es necesario
            boolean esAdmin = Boolean.parseBoolean(admin);

            
            // Establecemos los atributos para el header
            request.setAttribute("txtEmail", mail);
            request.setAttribute("txtAdmin", esAdmin);

            // Redirigimos a home.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/listar.jsp");
            dispatcher.forward(request, response);

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
