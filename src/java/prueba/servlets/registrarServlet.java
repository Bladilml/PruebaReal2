/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.servlets;

import dej4501.srvs.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import prueba.modelo.Usuarios;
import prueba.modelo.UsuariosHelper;

/**
 *
 * @author CETECOM
 */
public class registrarServlet extends HttpServlet {

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

        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String perfil = "user";

        List<String> listaMensajes = new ArrayList<>();

        if (Validate.validarNotEmpty(username)) {
            UsuariosHelper userService = new UsuariosHelper();
            // Encripto la contraseña
            BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
            String encryptedPass = passEncoder.encode(password);

            Usuarios newUser = new Usuarios(username, encryptedPass, perfil);
            boolean resultado = userService.crearUsuario(newUser);
            
            if (!resultado) {
                listaMensajes.add("Usuario no pudo ser agregado con éxito!");
            } else {
                listaMensajes.add("Usuario fue agregado con éxito!");
            }
           
        } else {
            listaMensajes.add("Nombre de usuario incorrecto!");
        }

        request.setAttribute("listaMensajes", listaMensajes);
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
