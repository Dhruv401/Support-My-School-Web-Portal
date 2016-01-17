/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
@WebServlet(name = "loginpageServlet", urlPatterns = {"/loginpageServlet"})
public class loginpageServlet extends HttpServlet {

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

            String Driver = "com.mysql.jdbc.Driver";
            String db = "schoolportal";
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "";
            String usrname = request.getParameter("usrname");
            String pass = request.getParameter("pass");

            String qry = "select * from main_master where usrname='" + usrname + "' AND pass='" + pass + "' ";

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

                    ResultSet rs2 = st.executeQuery("select name from main_master where usrname='" + usrname + "' ");

                    HttpSession ses = request.getSession(true);

                    while (rs2.next()) {
                        String send = rs2.getString("name");
                        ses.setAttribute("name1", send);            // setting value of name
                        
                        
                    }

                    ResultSet rs1 = st.executeQuery("select identity_sc from main_master where usrname='" + usrname + "'");
                    while (rs1.next()) {
                        String s132 = rs1.getString("identity_sc");

                        //   out.print(s132);
                        if (s132.equals("sch")) {
                            String h1="notnull";
                            HttpSession ln=request.getSession();
                            ln.setAttribute("ln12",h1 );
                            
                            response.sendRedirect("school_sch.jsp");
                            return;
                        }
                        if (s132.equals("ven")) {
                            response.sendRedirect("vendor_base.jsp");
                            return;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please insert true username , password", "Validation", JOptionPane.WARNING_MESSAGE);
                response.sendRedirect("loginpage.jsp");

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
