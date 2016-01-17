/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.VenComposebean;
import dao.VenComposedao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ven_composeServlet", urlPatterns = {"/ven_composeServlet"})
public class ven_composeServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        String vendor_name = request.getParameter("vendor_name");
        String vendor_msg_name = request.getParameter("vendor_msg_name");
        String product_detail = request.getParameter("product_detail");
        String duration_period = request.getParameter("duration_period");
        String school_name = request.getParameter("school_name");
        String offer_detail = request.getParameter("offer_detail");
        String percentage_profit = request.getParameter("percentage_profit");        
        String extra_detail = request.getParameter("extra_detail");
        
        VenComposebean vbc = new VenComposebean();
        
        vbc.setVendor_name(vendor_name);
        vbc.setDuration_period(duration_period);
        vbc.setExtra_detail(extra_detail);
        vbc.setOffer_detail(offer_detail);
        vbc.setPercentage_profit(percentage_profit);
        vbc.setProduct_detail(product_detail);
        vbc.setSchool_name(school_name);
        vbc.setVendor_msg_name(vendor_msg_name);
        
        VenComposedao vs = new VenComposedao();
        boolean flag = vs.composeDetail(vbc);
        
        if (flag == true) {
            
            JOptionPane.showMessageDialog(null, "Your message successfully sent.", "Message Sending", JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("ven_coll.jsp");
            return;
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
