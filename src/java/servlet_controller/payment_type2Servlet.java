/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.Payment_Type2bean;
import dao.Payment_Type2dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author DELL
 */
@WebServlet(name = "payment_type2Servlet", urlPatterns = {"/payment_type2Servlet"})
public class payment_type2Servlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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

    String user_name=request.getParameter("user_name");
    String user_email=request.getParameter("user_email");
    String user_type=request.getParameter("user_type");
    String user_verificationcode=request.getParameter("user_verificationcode");
    String user_address=request.getParameter("user_address");
   
    Payment_Type2bean pt2=new Payment_Type2bean();
    pt2.setUser_address(user_address);
    pt2.setUser_email(user_email);
    pt2.setUser_name(user_name);
    pt2.setUser_type(user_type);
    pt2.setUser_verificationcode(user_verificationcode);
    
    Payment_Type2dao pd2=new Payment_Type2dao();
    boolean f=pd2.moneyCard(pt2);
    
    if(f)
               {
         response.sendRedirect("success_comp.jsp");
    }
               
        }
        catch(Exception e){}
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
