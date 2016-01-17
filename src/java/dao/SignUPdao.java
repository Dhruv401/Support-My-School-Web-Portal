/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.SignUPbean;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class SignUPdao {

    Connection con=null;
    Statement st=null;
    
     public boolean firstEntry(SignUPbean b)
     {
         DbConnection db=new DbConnection();
         con=db.getConnection();
         
         int a=b.getAddress().length();
         boolean flag=false;
         if(con!=null)
         {
           
             try {
             st=con.createStatement();
             String qry="insert into main_master values(null,'"+b.getName()+"','"+b.getAddress()+"','"+b.getEmail()+"','"+b.getUsrname()+"','"+b.getPass()+"','"+b.getRepass()+"','"+b.getIdentity_sc()+"')";
             
             int i=st.executeUpdate(qry);
             if(i>0)
             { 
                 System.out.println("Data is inserted");
                 flag=true;
             }
             else
             { 
                 System.out.println("Data is not inserted");
                 flag=false;
             }
             } catch (SQLException ex) {
             }
             
         }
        return flag;
     }
}
