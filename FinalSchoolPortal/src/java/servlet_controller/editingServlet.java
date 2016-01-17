/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.EditingBean;
import dao.Editingdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
@WebServlet(name = "editingServlet", urlPatterns = {"/editingServlet"})
public class editingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String school_website = request.getParameter("school_website");
        String school_phone = request.getParameter("school_phone");
        String school_address = request.getParameter("school_address");
        String school_status = request.getParameter("school_status");
        String school_medium = request.getParameter("school_medium");
        String school_name = request.getParameter("school_name");
       
        EditingBean eb = new EditingBean();

        eb.setSchool_name(school_name);
        eb.setSchool_address(school_address);
        eb.setSchool_medium(school_medium);
        eb.setSchool_phone(school_phone);
        eb.setSchool_status(school_status);
        eb.setSchool_website(school_website);
      
        Editingdao dd = new Editingdao();
        boolean flag = dd.schEdit(eb);
        out.print("7" + flag);

        out.print("1");
        if (flag) {
            out.print("2");
            response.sendRedirect("school_sch.jsp");
            JOptionPane.showMessageDialog(null, "Profile updated successfully", "Updation", JOptionPane.WARNING_MESSAGE);
            
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
