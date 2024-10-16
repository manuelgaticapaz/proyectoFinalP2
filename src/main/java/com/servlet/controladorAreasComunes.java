/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.modelo.AreasComunes;
import com.modeloDAO.AreasComunesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos Gatica Paz
 */
public class controladorAreasComunes extends HttpServlet {

    String listar = "vistas/listarAreasComunes.jsp";
    String add = "vistas/addAreasComunes.jsp";
    String edit = "vistas/editAreasComunes.jsp";
    AreasComunes area = new AreasComunes();
    AreasComunesDAO dao = new AreasComunesDAO();
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
            String codigo = request.getParameter("txtCodigo");
            String tipo = request.getParameter("txtTipo");
            String ubicacion = request.getParameter("txtUbicacion");
            int capacidad = Integer.parseInt(request.getParameter("txtCapacidad"));
            String estado = request.getParameter("txtEstado");

            area.setCodigo(codigo);
            area.setTipo(tipo);
            area.setUbicacion(ubicacion);
            area.setCapacidad(capacidad);
            area.setEstado(estado);
            dao.add(area);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("id", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id=Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("txtCodigo");
            String tipo = request.getParameter("txtTipo");
            String ubicacion = request.getParameter("txtUbicacion");
            int capacidad = Integer.parseInt(request.getParameter("txtCapacidad"));
            String estado = request.getParameter("txtEstado");
            area.setId(id);
            area.setCodigo(codigo);
            area.setTipo(tipo);
            area.setUbicacion(ubicacion);
            area.setCapacidad(capacidad);
            area.setEstado(estado);
            dao.edit(area);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
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
