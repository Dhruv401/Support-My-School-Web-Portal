/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bean.VenComposebean;
import java.sql.Connection;
import java.sql.Statement;
import utill.DbConnection;

/**
 *
 * @author DELL
 */
public class VenComposedao {
    Connection con=null;
    Statement st=null;
    
    public boolean composeDetail(VenComposebean vbc){
        
        DbConnection dbc=new DbConnection();
        con=dbc.getConnection();
        boolean flag=false;
        
        if(con!=null)
        {
            try{
                st=con.createStatement();
                String qry="insert into vendor_compose values(null,'"+vbc.getVendor_name()+"','"+vbc.getVendor_msg_name()+"','"+vbc.getProduct_detail()+"','"+vbc.getDuration_period()+"','"+vbc.getSchool_name()+"','"+vbc.getOffer_detail()+"','"+vbc.getPercentage_profit()+"','"+vbc.getExtra_detail()+"')";
                int i=st.executeUpdate(qry);
                if(i>0)
                {
                    flag=true;
                }
                else
                {
                    flag=false;
                }
            }
            catch(Exception e){}
            }
        return flag;
        
    }
    
}
