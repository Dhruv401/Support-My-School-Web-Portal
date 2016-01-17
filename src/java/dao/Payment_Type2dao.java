/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Payment_Type2bean;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class Payment_Type2dao {

    Connection con = null;
    Statement st = null;

    public boolean moneyCard( Payment_Type2bean pt2) {
        DbConnection dvb = new DbConnection();
        con = dvb.getConnection();

        boolean f = false;
        try {
            st = (Statement) con.createStatement();
                
            String h="insert into payment_bycard values('"+pt2.getUser_name()+"','"+pt2.getUser_email()+"','"+pt2.getUser_type()+"','"+pt2.getUser_verificationcode()+"','"+pt2.getUser_address()+"') ";
            int l = st.executeUpdate(h);
            if (l > 0) {
                f = true;
            } else {
                f = false;
            }
        } catch (Exception e) {
        }

        return f;
    }

}
