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
import java.sql.ResultSet;
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
public class msg_descrptionServlet extends HttpServlet {

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
            Connection con = null;
            Statement st = null;

            out.print("1");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolportal", "root", "");
            st = con.createStatement();

            out.print("2");
            String id = request.getParameter("id");

            String q2 = "select * from vendor_compose where ven_id='" + id + "'   ";

            String d1 = null;
            String d2 = null;
            String d3 = null;
            String d4 = null;
            String d5 = null;
            String d6 = null;
            String d7 = null;

            ResultSet rr = st.executeQuery(q2);

            out.print("3");
            while (rr.next()) {

                d1 = rr.getString("vendor_name");
                d2 = rr.getString("school_name");
                d3 = rr.getString("vendor_msg_name");
                d4 = rr.getString("product_detail");
                d5 = rr.getString("duration_period");
                d6 = rr.getString("offer_detail");
                d7 = rr.getString("percentage_profit");

                out.print("4");
            }

            String q = "insert into accept_msg values(null,'" + d1 + "','" + d2 + "','" + d3 + "','" + d4 + "','" + d5 + "','" + d6 + "','" + d7 + "') ";

            out.print("5");
            int g = st.executeUpdate(q);

            if (g > 0) {

                response.sendRedirect("coll_req.jsp");

                JOptionPane.showMessageDialog(null, "Message successully Accepted", "Acceptance", JOptionPane.WARNING_MESSAGE);

            } else {

            }

                   // condition
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
