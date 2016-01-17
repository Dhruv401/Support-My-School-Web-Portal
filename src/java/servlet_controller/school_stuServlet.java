/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "school_stuServlet", urlPatterns = {"/school_stuServlet"})
public class school_stuServlet extends HttpServlet {

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

            String url = "jdbc:mysql://localhost:3306/";
            String db = "schoolportal";
            String username = "root";
            String password = "";
            String driver = "com.mysql.jdbc.Driver";

            String student_usrname = request.getParameter("student_usrname");
            String student_pass = request.getParameter("student_pass");

            //out.print(student_usrname);
            //out.print(student_pass);
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url + db, username, password);
            //   System.out.print("1");
            Statement st = con.createStatement();
            String query = "select * from  student_base where student_usrname='" + student_usrname + "' AND student_pass='" + student_pass + "'";
            //    System.out.print("2");

            ResultSet rd = st.executeQuery("select student_name from student_base where student_usrname='" + student_usrname + "'  ");

            HttpSession hsp = request.getSession(true);
            while (rd.next()) {
                String ins = rd.getString("student_name");
                hsp.setAttribute("stu_nm", ins);
            }

            ResultSet rs = st.executeQuery(query);

            //   System.out.print("13456");
            if (rs.next() == true) {
                // System.out.print("777");
                String s1 = rs.getString("student_usrname");
                String s2 = rs.getString("student_pass");

                if (s1.equals(student_usrname) && s2.equals(student_pass)) {

                    response.sendRedirect("stu_pro_final.jsp");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter valid username,password", "Login", JOptionPane.WARNING_MESSAGE);
                response.sendRedirect("school_stu.jsp");
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
