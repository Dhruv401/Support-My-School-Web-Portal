/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.StuRegFormbean;
import dao.StuRegFormdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
@WebServlet(name = "stu_reg_formServlet", urlPatterns = {"/stu_reg_formServlet"})
public class stu_reg_formServlet extends HttpServlet {

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

            String student_name = request.getParameter("student_name");
            String student_email = request.getParameter("student_email");
            String student_gender = request.getParameter("student_gender");
            String student_address = request.getParameter("student_address");
            String school_name = request.getParameter("school_name");
            String student_usrname = request.getParameter("student_usrname");
            String student_pass = request.getParameter("student_pass");

            StuRegFormbean sfb = new StuRegFormbean();
            sfb.setSchool_name(school_name);
            sfb.setStudent_address(student_address);
            sfb.setStudent_email(student_email);
            sfb.setStudent_gender(student_gender);
            sfb.setStudent_name(student_name);
            sfb.setStudent_pass(student_pass);
            sfb.setStudent_usrname(student_usrname);

            String u = sfb.getStudent_usrname();
            String p = sfb.getStudent_pass();

            int j = u.length();
            int k = p.length();

            HttpSession hsp2 = request.getSession(true);
            hsp2.setAttribute("stu_nm", sfb.getStudent_name());

            if (j > 3 && k > 7) {
                StuRegFormdao sd = new StuRegFormdao();
                boolean flag = sd.studentSignup(sfb);

                if (flag) {
                    response.sendRedirect("stu_pro_final.jsp");

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter username>3 ,password>7", "Length requirement", JOptionPane.WARNING_MESSAGE);
                    response.sendRedirect("stu_reg_form.jsp");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter username>3 ,password>7", "Length requirement", JOptionPane.WARNING_MESSAGE);
                response.sendRedirect("stu_reg_form.jsp");
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
