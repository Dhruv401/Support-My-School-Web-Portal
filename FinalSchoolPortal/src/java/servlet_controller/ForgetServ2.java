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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ForgetServ2 extends HttpServlet {

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

            String email = request.getParameter("email");

            Connection con = null;
            Statement st = null;

            String url = "jdbc:mysql://localhost:3306/schoolportal";
            String usrname = "root";
            String pass = "";
            String Driver = "com.mysql.jdbc.Driver";

            Class.forName(Driver);
            con = DriverManager.getConnection(url, usrname, pass);

            if (con != null) {
                st = con.createStatement();

                String query = "insert into pass_recover2 values(null,'" + email + "')";
                Integer I = st.executeUpdate(query);
                out.print("0");

                String dd = "select * from student_base where student_email='" + email + "' ";
                ResultSet rs = st.executeQuery(dd);
                out.print("1");
                while (rs.next()) {
                    String na = rs.getString("student_name");   // name
                    String password = rs.getString("student_pass");
                    String na2 = email;                  // email id

                    // USE MAIL FUNCTION TO SEND MAIL TO USER WHO HAD FORGOTTEN PASSWORD.
                    // Recipient's email ID needs to be mentioned.
                    String to = na2;

                    // Sender's email ID needs to be mentioned
                    String from = "neilthaker@yahoo.com";

                    // Assuming you are sending email from localhost
                    String host = "localhost";

                    // Get system properties
                    Properties properties = System.getProperties();

                    // Setup mail server
                    properties.setProperty("mail.smtp.host", host);

                    // Get the default Session object.
                    Session session = Session.getDefaultInstance(properties);

                    try {
                        // Create a default MimeMessage object.
                        MimeMessage message = new MimeMessage(session);

                        // Set From: header field of the header.
                        message.setFrom(new InternetAddress(from));

                        // Set To: header field of the header.
                        message.addRecipient(Message.RecipientType.TO,
                                new InternetAddress(to));

                        // Set Subject: header field
                        message.setSubject("Forget Password Recovery");

                        // Now set the actual message
                        message.setText("Name : " + na + "  password : " + password);

                        // Send message
                        Transport.send(message);
                        System.out.println("Sent message successfully....");
                    } catch (Exception mex) {
                        mex.printStackTrace();
                    }

                }

                if (I > 0) {
                    response.sendRedirect("school_stu.jsp");
                }
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
