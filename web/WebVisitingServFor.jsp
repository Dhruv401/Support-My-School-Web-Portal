<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
    <head>

    <body>
        <%
            String a1 = request.getParameter("a1");
            String b = request.getParameter("b");
            String c = request.getParameter("c");

            try {

                String Driver = "com.mysql.jdbc.Driver";
                String db = "schoolportal";
                String url = "jdbc:mysql://localhost:3306/";
                String user = "root";
                String password = "";

                Class.forName(Driver).newInstance();
                Connection con = DriverManager.getConnection(url + db, user, password);
                Statement st = con.createStatement();

                String qw = "select * from student_edit_profile where student_name='" + a1 + "' AND stu_base_id=(SELECT max(stu_base_id) from student_edit_profile where student_name='" + a1 + "' ) ";
                ResultSet rr = st.executeQuery(qw);

                String i1 = null;
                String i2 = null;
                String i5 = null;

                while (rr.next()) {
                    i1 = rr.getString("student_name");
                    i2 = rr.getString("student_school_id");
                    i5 = rr.getString("student_grade");
                }
                out.print("4");
                String q = "insert into website_send values (null,'" + i1 + "','" + c + "','" + i2 + "','" + i5 + "')";
                int h = st.executeUpdate(q);
                
                out.print("5");

                if (h > 0) {
                    response.sendRedirect(b);
                }

        %>

    </body>
</head>
</html>

<%    } catch (Exception e) {
    }

%>