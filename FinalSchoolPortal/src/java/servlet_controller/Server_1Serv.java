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
/**
 *
 * @author DELL
 */
public class Server_1Serv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String Driver = "com.mysql.jdbc.Driver";
            String db = "schoolportal";
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "";
            String usrname = request.getParameter("usrname");
            String pass = request.getParameter("pass");

            String qry = "select * from main_server where usrname='" + usrname + "' AND pass='" + pass + "' ";

            // out.print(usrname + "  " + pass);
            Class.forName(Driver).newInstance();
            Connection con = DriverManager.getConnection(url + db, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);

            if (rs.next()) {

                String s1 = rs.getString("usrname");
                String s2 = rs.getString("pass");

                //  out.print(s1 + "  " + s2);
                if (s1 != null && s2 != null) {

                    ResultSet rs2 = st.executeQuery("select usrname from main_server where usrname='" + usrname + "' ");
                    response.sendRedirect("Server_2.jsp");

                }
            } else {
                response.sendRedirect("Server_1.jsp");

            }
        } catch (Exception e) {
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
