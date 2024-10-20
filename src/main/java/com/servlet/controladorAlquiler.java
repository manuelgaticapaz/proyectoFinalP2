package com.servlet;

import com.modelo.Alquiler;
import com.modeloDAO.AlquilerDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controladorAlquiler extends HttpServlet {

    String listar = "vistas/listarAlquiler.jsp";
    String add = "vistas/addAlquiler.jsp";
    String edit = "vistas/editAlquiler.jsp";
    Alquiler alquiler = new Alquiler();
    AlquilerDAO dao = new AlquilerDAO();
    int id;

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
            int idVivienda = Integer.parseInt(request.getParameter("txtIdVivienda"));
            String documentoResidente = request.getParameter("txtDocumentoResidente");
            Date fechaInicio = Date.valueOf(request.getParameter("txtFechaInicio"));
            Date fechaFin = request.getParameter("txtFechaFin").isEmpty() ? null : Date.valueOf(request.getParameter("txtFechaFin"));

            alquiler.setIdVivienda(idVivienda);
            alquiler.setDocumentoResidente(documentoResidente);
            alquiler.setFechaInicio(fechaInicio);
            alquiler.setFechaFin(fechaFin);
            dao.add(alquiler);

            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idAlquiler", id);
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            
            // Recuperar los valores del formulario para los campos de vivienda y residente
            int idVivienda = Integer.parseInt(request.getParameter("idVivienda"));
            String documentoResidente = request.getParameter("documentoResidente");
            Date fechaInicio = Date.valueOf(request.getParameter("txtFechaInicio"));
            Date fechaFin = request.getParameter("txtFechaFin").isEmpty() ? null : Date.valueOf(request.getParameter("txtFechaFin"));

            // Establecer los valores en el objeto alquiler
            alquiler.setId(id);
            alquiler.setIdVivienda(idVivienda);
            alquiler.setDocumentoResidente(documentoResidente);
            alquiler.setFechaInicio(fechaInicio);
            alquiler.setFechaFin(fechaFin);
            
            // Llamar a la función de actualización
            dao.edit(alquiler);

            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            acceso = listar;
        }

        // Redirigir a la vista correspondiente
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
