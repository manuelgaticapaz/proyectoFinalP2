package com.servlet;

import com.modelo.Residente;
import com.modeloDAO.ResidenteDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controladorResidente extends HttpServlet {

    String listar = "vistas/listarResidente.jsp";
    String add = "vistas/addResidente.jsp";
    String edit = "vistas/editResidente.jsp";
    Residente residente = new Residente();
    ResidenteDAO dao = new ResidenteDAO();
    String documento;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String documento = request.getParameter("txtDocumento");
            String nombre = request.getParameter("txtNombre");
            int edad = Integer.parseInt(request.getParameter("txtEdad"));
            String correo = request.getParameter("txtCorreo");
            residente.setDocumento(documento);
            residente.setNombre(nombre);
            residente.setEdad(edad);
            residente.setCorreo(correo);
            dao.add(residente);
            
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            documento = request.getParameter("documento");
            request.setAttribute("documento", documento);
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            String documento = request.getParameter("documento");
            String nombre = request.getParameter("txtNombre");
            int edad = Integer.parseInt(request.getParameter("txtEdad"));
            String correo = request.getParameter("txtCorreo");
            residente.setDocumento(documento);
            residente.setNombre(nombre);
            residente.setEdad(edad);
            residente.setCorreo(correo);
            dao.edit(residente);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            documento = request.getParameter("documento");
            dao.eliminar(documento);
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
