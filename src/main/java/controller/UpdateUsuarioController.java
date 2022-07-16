/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import database.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;


@WebServlet(name = "UpdateUsuarioController", urlPatterns = {"/UpdateUsuarioController"})
public class UpdateUsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */          
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
          
            //acá tengo lo que ingresaron en la view.
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String mail = request.getParameter("mail");
            
            //Acá le voy a pedir a mi DAO que me busque el usuario
            UsuarioDAO usuarioDAO = new UsuarioDAO();
      
            boolean actualizado = false;
          
            //dentro de esto try/catch manejo el error de la db.
            try {
                actualizado = usuarioDAO.actualizar(Integer.valueOf(id), username, password, nombre, apellido, mail);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Acá guardo en sesión al usuario
            HttpSession session = request.getSession();
            
            if (actualizado){
                session.setAttribute("mensaje", "Actualizado");  
                Usuario usuario = null;
                try {
                    usuario = usuarioDAO.buscar(username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                //Acá guardo en sesión al usuario
                session.setAttribute("usuarioSession", usuario);
            } else {
                session.setAttribute("mensaje", "No Actualizado");  
            }
             response.sendRedirect("views/user.jsp");
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
        processRequest(request, response);
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
