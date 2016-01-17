/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.PaymentType1bean;
import java.sql.Connection;
import java.sql.Statement;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class PaymentType1dao {

    Connection con = null;
    Statement st = null;

    public boolean money1(PaymentType1bean dt) {
        DbConnection dbb = new DbConnection();
        con = dbb.getConnection();
        boolean flag = false;
        
        
        if (con != null) {
            try {
                st=con.createStatement();
                String qw = "insert into payment_cashondelivery values('" + dt.getUser_email() + "','" + dt.getUser_phone() + "','" + dt.getUser_verificationcode() + "','" + dt.getUser_address() + "')";
                int g = st.executeUpdate(qw);
                if (g > 0) {
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
