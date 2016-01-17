/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.EditingBean;
import java.sql.Connection;
import java.sql.Statement;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class Editingdao {

    Connection con = null;
    Statement st = null;

    public boolean schEdit(EditingBean eb) {
        DbConnection db = new DbConnection();
        con = db.getConnection();

        boolean flag = false;
        if (con != null) {
            try {
                st = con.createStatement();
                String qry = "insert into school_master values(null,'" + eb.getSchool_name() + "','" + eb.getSchool_website() + "','" + eb.getSchool_phone() + "','" + eb.getSchool_address() + "','" + eb.getSchool_status() + "','" + eb.getSchool_medium() + "') ";

                int i = st.executeUpdate(qry);
                if (i > 0) {
                    System.out.println("Data is inserted");
                    flag = true;
                } else {
                    System.out.println("Data is not inserted");
                    flag = false;
                }

            } catch (Exception e) {
            }
        }
        return flag;
    }

}
