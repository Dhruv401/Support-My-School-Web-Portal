/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.StuRegFormbean;
import java.sql.Connection;
import java.sql.Statement;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class StuRegFormdao {

    Connection con = null;
    Statement st = null;

    public boolean studentSignup(StuRegFormbean sfb) {
        DbConnection db = new DbConnection();
        con = db.getConnection();
        boolean flag = false;

        if (con != null) {
            try {
                st = con.createStatement();
                String qu = "insert into student_base values(null,'" + sfb.getStudent_name() + "','" + sfb.getStudent_email() + "','" + sfb.getSchool_name() + "','" + sfb.getStudent_gender() + "','" + sfb.getStudent_address() + "','" + sfb.getStudent_usrname() + "','" + sfb.getStudent_pass() + "')";
                int j = st.executeUpdate(qu);
                if (j > 0) {

                    flag = true;

                } else {
                    flag = false;
                }
            } catch (Exception e) {
            }
        }
        return flag;

    }

}
