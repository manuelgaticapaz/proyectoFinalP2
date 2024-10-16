
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
       
    }

    
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
