/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Editing_for_venServlet extends HttpServlet {

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
        try {

            String vendor_name = request.getParameter("vendor_name");
            String shop_name = request.getParameter("shop_name");
            String vendor_website = request.getParameter("vendor_website");
            String vendor_phone = request.getParameter("vendor_phone");
            String vendor_description = request.getParameter("vendor_description");
            String vendor_type = request.getParameter("vendor_type");

            //   out.print(ven_image+"123");
            Connection con = null;
            Statement st = null;

            String url = "jdbc:mysql://localhost:3306/schoolportal";
            String usrname = "root";
            String pass = "";
            String Driver = "com.mysql.jdbc.Driver";

            Class.forName(Driver);
            con = DriverManager.getConnection(url, usrname, pass);

            int ev=vendor_description.length();
            if (con != null) {
                st = con.createStatement();
                out.print("5");
                if(ev>10){

                String query = "insert into vendor_master values(null,'" + vendor_name + "','" + shop_name + "','" + vendor_website + "','" + vendor_phone + "','" + vendor_type + "','" + vendor_description + "')";
                Integer I = st.executeUpdate(query);
                out.print("3");
                if (I > 0) {
                    out.print("4");
                    response.sendRedirect("vendor_base.jsp");
                    JOptionPane.showMessageDialog(null, "Profile Updated", "Updation", JOptionPane.WARNING_MESSAGE);
                }
                }
                else{
                    response.sendRedirect("Editing_for_ven.jsp");
                    JOptionPane.showMessageDialog(null, "Enter basic description.", "Least Description", JOptionPane.WARNING_MESSAGE);
                    
                }
            }
        } catch (Exception e) {

        } finally {
            out.close();
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
