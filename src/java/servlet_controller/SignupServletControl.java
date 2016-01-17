/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.SignUPbean;
import dao.SignUPdao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SignupServletControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String usrname = request.getParameter("usrname");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String identity_sc = request.getParameter("identity_sc");

        // out.print("123456");
        //Session ss=request.setAttribute("name1", name);
        SignUPbean b = new SignUPbean();
        b.setName(name);
        b.setAddress(address);
        b.setEmail(email);
        b.setUsrname(usrname);
        b.setPass(pass);
        b.setRepass(repass);
        b.setIdentity_sc(identity_sc);

        HttpSession ses = request.getSession(true);             //sending name of school or vendor
        ses.setAttribute("name1", b.getName());

        //   out.print("456");
        String y = b.getIdentity_sc();                                      //for specific page  school or vendor
        String x = b.getUsrname();                                          // username length

        String z = b.getPass();
        String z1 = b.getRepass();
        int h = z.length();
        int i = x.length();

        if (h > 7 && i > 3) {
            if (z.equals(z1)) {                           // password check-compare

                //System.out.print("123");
                SignUPdao d = new SignUPdao();
                boolean flag = d.firstEntry(b);
                //System.out.print("456");

                //  out.print(x+flag+y);
                //  out.print("6");
                if (flag == true && y.equals("sch")) {

                    response.sendRedirect("school_sch.jsp");
                }
                if (flag == true && y.equals("ven")) {
                    response.sendRedirect("vendor_base.jsp");
                }

            } else {                                                              //pass,repass not same
                JOptionPane.showMessageDialog(null, "Enter same password and repassword", "Password compare", JOptionPane.WARNING_MESSAGE);
                response.sendRedirect("signUP.jsp");

            }

        } else {                  // password length < 7 , username>3

            JOptionPane.showMessageDialog(null, "REQUIRED : Username > 3 & password > 7", "Minimum Length", JOptionPane.WARNING_MESSAGE);
            response.sendRedirect("signUP.jsp");
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
