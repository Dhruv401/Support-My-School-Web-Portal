/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UploadDao {

    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String password = "";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, userName, password);
        System.out.println("CONNECTION IS  ::  " + conn);
        return conn;
    }

    public void uploadInsert(File file) throws Exception {
        // getData();
        String id = "1";
        System.out.println("FILE IS " + file);
        String fileName = file.getName();
        FileInputStream fis = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = getConnection();
        File file1 = new File(id + ".jpg");
        fis = new FileInputStream(file);

        pstmt = conn
                .prepareStatement("insert into empfile_insert (id,filename,filebody) values(?,?,?)");
        System.out.println("PS " + pstmt);
        pstmt.setString(1, id);
        pstmt.setString(2, fileName);
        pstmt.setBinaryStream(3, fis, (int) file.length());
        pstmt.executeUpdate();
        // images/

    }

}
