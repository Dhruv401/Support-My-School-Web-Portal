/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.StuEditprobean;
import dao.StuEditprodao;
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
@WebServlet(name = "stu_edit_proServlet", urlPatterns = {"/stu_edit_proServlet"})
public class stu_edit_proServlet extends HttpServlet {

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
            String birth_date = request.getParameter("birth_date");
            String student_school_id = request.getParameter("student_school_id");
            String student_classno = request.getParameter("student_classno");
            String student_status = request.getParameter("student_status");
            String student_grade = request.getParameter("student_grade");
           
            StuEditprobean stpb = new StuEditprobean();

            stpb.setBirth_date(birth_date);
            stpb.setStudent_name(student_name);
            stpb.setStudent_classno(student_classno);
            stpb.setStudent_grade(student_grade);
            stpb.setStudent_school_id(student_school_id);
            stpb.setStudent_status(student_status);
         
            StuEditprodao std = new StuEditprodao();
            boolean f = std.stuUpdate(stpb);

            if (f == true) {
                
                response.sendRedirect("stu_pro_final.jsp");
                JOptionPane.showMessageDialog(null, "Profile Updated", "Updation", JOptionPane.WARNING_MESSAGE);
               
            }
            else{
                 response.sendRedirect("stu_edit_pro.jsp");
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
