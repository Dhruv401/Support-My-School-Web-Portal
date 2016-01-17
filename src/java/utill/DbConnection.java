/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    Connection con = null;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolportal", "root", "");

        } catch (Exception e) {
}
        return con;
    }
}
