package com.servlet;

import com.modelo.AreasComunes;
import com.modelo.Reservas;
import com.modeloDAO.ReservasDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class controladorReservas extends HttpServlet {

    String listar = "vistas/listarReservas.jsp";
    String add = "vistas/addReservas.jsp";
    String edit = "vistas/editReservas.jsp";
    Reservas reservas = new Reservas();
    ReservasDAO dao = new ReservasDAO();
    int id;

    // Método privado para obtener fechas como Timestamp
    private Timestamp obtenerFecha(HttpServletRequest request, String parametro) {
        String fechaStr = request.getParameter(parametro);
        return fechaStr != null && !fechaStr.isEmpty() 
                ? Timestamp.valueOf(fechaStr.replace("T", " ") + ":00") 
                : null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String acceso = "";
            String action = request.getParameter("accion");

            if (action.equalsIgnoreCase("listar")) {
            String txtAdmin = (String) request.getSession().getAttribute("txtAdmin");
            String idAlquilerParam = request.getParameter("idAlquiler");
            List<Reservas> lista = new ArrayList<>();

            if ("Administrador".equalsIgnoreCase(txtAdmin)) {
                if (idAlquilerParam != null && !idAlquilerParam.isEmpty()) {
                    int idAlquiler = Integer.parseInt(idAlquilerParam);
                    lista = dao.listarPorAlquiler(idAlquiler);
                } else {
                    lista = dao.listar();
                }
            } else {
                String idAlquilerUsuario = (String) request.getSession().getAttribute("idAlquiler");
                if (idAlquilerUsuario != null) {
                    int idAlquiler = Integer.parseInt(idAlquilerUsuario);
                    lista = dao.listarPorAlquiler(idAlquiler);
                }
            }

            request.setAttribute("reservas", lista);
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            int idArea = Integer.parseInt(request.getParameter("txtIdArea"));
            int idAlquiler = Integer.parseInt(request.getParameter("txtIdAlquiler"));
            Timestamp fechaReservaInicio = obtenerFecha(request, "txtFechaReservaInicio");
            Timestamp fechaReservaFinal = obtenerFecha(request, "txtFechaReservaFinal");
            String nombreResponsable = request.getParameter("txtNombreResponsable");
            String comentario = request.getParameter("txtComentario");

            reservas.setIdArea(idArea);
            reservas.setIdAlquiler(idAlquiler);
            reservas.setFechaReservaInicio(fechaReservaInicio);
            reservas.setFechaReservaFinal(fechaReservaFinal);
            reservas.setNombreResponsable(nombreResponsable);
            reservas.setComentario(comentario);
            dao.add(reservas);

            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idReservacion", id);
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            int idArea = Integer.parseInt(request.getParameter("idArea"));
            int idAlquiler = Integer.parseInt(request.getParameter("idAlquiler"));
            Timestamp fechaReservaInicio = obtenerFecha(request, "txtFechaReservaInicio");
            Timestamp fechaReservaFinal = obtenerFecha(request, "txtFechaReservaFinal");
            String nombreResponsable = request.getParameter("nombreResponsable");
            String comentario = request.getParameter("comentario");

            reservas.setId(id);
            reservas.setIdArea(idArea);
            reservas.setIdAlquiler(idAlquiler);
            reservas.setFechaReservaInicio(fechaReservaInicio);
            reservas.setFechaReservaFinal(fechaReservaFinal);
            reservas.setNombreResponsable(nombreResponsable);
            reservas.setComentario(comentario);
            dao.edit(reservas);

            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            acceso = listar;
        } else if ("Verificar Disponibilidad".equalsIgnoreCase(action)) {
            Timestamp fechaReservaInicio = obtenerFecha(request, "txtFechaReservaInicio");
            Timestamp fechaReservaFinal = obtenerFecha(request, "txtFechaReservaFinal");

            ReservasDAO reservasDAO = new ReservasDAO();
            List<AreasComunes> areasDisponibles = reservasDAO.obtenerAreasDisponibles(fechaReservaInicio, fechaReservaFinal);

            // Pasar la lista de áreas disponibles y las fechas al JSP
            request.setAttribute("areasDisponibles", areasDisponibles);
            request.setAttribute("txtFechaReservaInicio", request.getParameter("txtFechaReservaInicio"));
            request.setAttribute("txtFechaReservaFinal", request.getParameter("txtFechaReservaFinal"));

            RequestDispatcher dispatcher = request.getRequestDispatcher("vistas/addReservas.jsp");
            dispatcher.forward(request, response);
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
