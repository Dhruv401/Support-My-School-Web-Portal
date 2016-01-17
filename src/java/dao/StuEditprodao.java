/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.StuEditprobean;
import java.sql.*;
import javax.swing.JOptionPane;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class StuEditprodao {

    Connection con = null;
    Statement st = null;

    public boolean stuUpdate(StuEditprobean stpb) {

        DbConnection db = new DbConnection();
        con = db.getConnection();

        boolean f = false;
        if (con != null) {
            try {
                int p=stpb.getStudent_status().length();
               //  out.print(p);
                if(p>7)   {            
                
                st = con.createStatement();
                String qry="insert into student_edit_profile values(null,'" + stpb.getStudent_name() + "','" + stpb.getStudent_school_id() + "','" + stpb.getBirth_date()+ "','" + stpb.getStudent_classno() + "','" + stpb.getStudent_status() + "','" + stpb.getStudent_grade() + "') ";                
                int i = st.executeUpdate(qry);
                if (i > 0) {
                    System.out.println("Data is inserted");
                    f = true;
                } else {
                    System.out.println("Data is not inserted");
                    f= false;
                }
                }
                
                 else{
                    
                    JOptionPane.showMessageDialog(null, "Phone no minimum length > 7", "Phone no: ", JOptionPane.WARNING_MESSAGE);
                    f=false;
// response.sendRedirect("stu_edit_pro.jsp");
                }

            } catch (Exception e) {
            }
        }
        return f;

    }

   

}
