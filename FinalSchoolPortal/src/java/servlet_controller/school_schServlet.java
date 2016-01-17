/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_controller;

import bean.School_schB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "school_schServlet", urlPatterns = {"/school_schServlet"})
public class school_schServlet extends HttpServlet {

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

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url + db, username, password);
            Statement st = con.createStatement();

            HttpSession hse = request.getSession();
            String io = (String) hse.getAttribute("fi");

            String im = "select * from for_image where school_image='" + io + "' AND img_id=(SELECT max(img_id) from for_image where school_image='" + io + "')  ";
            ResultSet rs = st.executeQuery(im);

            String f1;
            String f2 ;
            while (rs.next()) {
                String gh = rs.getString("school_image");
                f1 = "ImageSavings" + gh;
                System.out.println("000000000000000" + f1 + "000000000000000000000000000000");
                f2 = "ImageSavings/" + f1;
                System.out.println(f2);
                
                School_schB ss1=new School_schB();
                ss1.setF22(f2);
                
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
