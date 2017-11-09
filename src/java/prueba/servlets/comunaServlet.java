/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prueba.modelo.Comunas;
import prueba.modelo.ComunasHelper;

/**
 *
 * @author CETECOM
 */
public class comunaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet comunaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet comunaServlet at " + request.getContextPath() + "</h1>");
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

        request.setCharacterEncoding("UTF-8");
        String provinciaIdStr = request.getParameter("q");

        try {
            int provinciaId = Integer.parseInt(provinciaIdStr);
            ComunasHelper comunasHelper = new ComunasHelper();
            List<Comunas> listaProvincias = comunasHelper.getAllByProvinciaId(provinciaId);
            // envío el select directamente al objeto Ajax XMLHttpRequest
            try (PrintWriter out = response.getWriter();) {
                out.println("<select name=\"comuna\" id=\"comuna\">");
                out.println("   <option value=\"\" selected>Seleccione</option>");
                for (Comunas comuna : listaProvincias) {
                    out.println("   <option value=\"" + comuna.getComunaId() + "\">" + comuna.getComunaNombre() + "</option>");
                }
                out.print("</select>");
            } catch (IOException ex) {
                Logger.getLogger(provinciaServlet.class.getName()).log(Level.SEVERE, "Error en printWriter...{0}", ex.toString());
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(provinciaServlet.class.getName()).log(Level.SEVERE, "id de region erroneo: {0}", ex.toString());
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
