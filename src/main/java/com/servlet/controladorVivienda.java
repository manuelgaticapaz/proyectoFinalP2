package com.servlet;

import com.modelo.Vivienda;
import com.modeloDAO.ViviendaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controladorVivienda extends HttpServlet {

    String listar = "vistas/listarVivienda.jsp";
    String add = "vistas/addVivienda.jsp";
    String edit = "vistas/editVivienda.jsp";
    Vivienda vivienda = new Vivienda();
    ViviendaDAO dao = new ViviendaDAO();
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
            String direccion = request.getParameter("txtDireccion");
            String tipo = request.getParameter("txtTipo");
            int numHabitaciones = Integer.parseInt(request.getParameter("txtNumHabitaciones"));
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            boolean disponibilidad = Boolean.parseBoolean(request.getParameter("chkDisponibilidad"));

            vivienda.setDireccion(direccion);
            vivienda.setTipo(tipo);
            vivienda.setNumHabitaciones(numHabitaciones);
            vivienda.setPrecio(precio);
            vivienda.setDisponibilidad(disponibilidad);
            dao.add(vivienda);

            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idVivienda", id);
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String direccion = request.getParameter("txtDireccion");
            String tipo = request.getParameter("txtTipo");
            int numHabitaciones = Integer.parseInt(request.getParameter("txtNumHabitaciones"));
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            boolean disponibilidad = Boolean.parseBoolean(request.getParameter("chkDisponibilidad"));

            vivienda.setId(id);
            vivienda.setDireccion(direccion);
            vivienda.setTipo(tipo);
            vivienda.setNumHabitaciones(numHabitaciones);
            vivienda.setPrecio(precio);
            vivienda.setDisponibilidad(disponibilidad);
            dao.edit(vivienda);
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
