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
import prueba.modelo.Provincias;
import prueba.modelo.ProvinciasHelper;

/**
 *
 * @author CETECOM
 */
public class provinciaServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String regionIdStr=request.getParameter("q");
        
        try {
            int regionId = Integer.parseInt(regionIdStr);
            ProvinciasHelper provinciasHelper = new ProvinciasHelper();
            List<Provincias> listaProvincias = provinciasHelper.getAllByRegionId(regionId);
            // envío el select directamente al objeto Ajax XMLHttpRequest
            try (PrintWriter out = response.getWriter();){
                out.println("<select name=\"provincia\" id=\"provincia\" onchange=\"buscarComuna();\">");
                out.println("   <option value=\"\" selected>Seleccione</option>");
                for (Provincias prov : listaProvincias) {
                    out.println("   <option value=\""+prov.getProvinciaId()+"\">"+prov.getProvinciaNombre()+"</option>");
                }
                out.print("</select>");
            } catch (IOException ex){
                Logger.getLogger(provinciaServlet.class.getName()).log(Level.SEVERE, "Error en printWriter...{0}", ex.toString());
            }
        } catch (NumberFormatException ex){
            Logger.getLogger(provinciaServlet.class.getName()).log(Level.SEVERE, "id de region erroneo: {0}", ex.toString());
        }
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
