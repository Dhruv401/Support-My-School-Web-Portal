

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">


    <head> 
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
        <script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
        <script src="js/cufon-yui.js" type="text/javascript"></script>
        <script src="js/cufon-replace.js" type="text/javascript"></script>
        <script src="js/NewsGoth_400.font.js" type="text/javascript"></script>
        <script src="js/NewsGoth_700.font.js" type="text/javascript"></script>
        <script src="js/NewsGoth_Lt_BT_italic_400.font.js" type="text/javascript"></script>
        <script src="js/Vegur_400.font.js" type="text/javascript"></script> 
        <script src="js/FF-cash.js" type="text/javascript"></script>
        <script src="js/jquery.featureCarousel.js" type="text/javascript"></script>     
        <script type="text/javascript">
            $(document).ready(function() {
                $("#carousel").featureCarousel({
                    autoPlay: 7000,
                    trackerIndividual: false,
                    trackerSummation: false,
                    topPadding: 50,
                    smallFeatureWidth: .9,
                    smallFeatureHeight: .9,
                    sidePadding: 0,
                    smallFeatureOffset: 0
                });
            });
        </script>
        <!--[if lt IE 7]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
                <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
    </div>
        <![endif]-->
        <!--[if lt IE 9]>
                    <script type="text/javascript" src="js/html5.js"></script>
            <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
            <![endif]-->
    </head>
    <body id="page1">
        <div class="extra">

            <!--==============================header=================================-->
            <header>
                <div class="row-top">
                    <div class="main">
                        <div class="wrapper">
                            <h1><a href="">School Portal</a></h1>
                            <div class="ls"> 
                                <a href="Server_1.jsp">Logout</a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="menu-row">
                    <div class="menu-bg">
                        <div class="main">
                            <nav class="indent-left">
                                <ul class="menu wrapper">
                                    <li class="active">
                                    <li><a href="Server_2.jsp">Home</a></li>

                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="row-bot">
                    <div class="center-shadow">
                        <div class="carousel-container">

                        </div>
                    </div>
                </div>
            </header>
            <!--==============================content================================-->
            <section id="content"><div class="ic"></div>
                <div class="content-bg">
                    <div class="main">
                        <div class="container_12">
                            <div class="wrapper">
                                <article class="grid_4">
                                    <br><br><br>
                                    <br><br><br>
                                    <a href="Server_2.jsp">Schools</a><br><br><br>
                                    <a href="Server_4.jsp">Vendors</a><br><br><br>
                                    <a href="Server_3.jsp">Students</a><br><br><br>

                                </article>
                                <article class="grid_8">

                                    <article class="grid_07">
                                        <h3>Students</h3>
                                        <%
                                            try {
                                                String Driver = "com.mysql.jdbc.Driver";
                                                String db = "schoolportal";
                                                String url = "jdbc:mysql://localhost:3306/";
                                                String user = "root";
                                                String password = "";

                                                Class.forName(Driver).newInstance();
                                                Connection con = DriverManager.getConnection(url + db, user, password);
                                                Statement st = con.createStatement();
                                                String qry1 = "select * from student_base";

                                                ResultSet rs = st.executeQuery(qry1);

                                                while (rs.next()) {
                                        %>
                                        <a href="Server_3.jsp?name=<%=rs.getString("student_name")%>">
                                            <%=rs.getString("student_name")%><br><br><br>
                                            <%
                                                }
                                            %></a> 

                                    </article>
                                    <article class="grid_77"><br><br>
                                        <h50>Description</h50><br><br>
                                            <%
                                                String let = request.getParameter("name");
                                                String qr25 = "select * from student_edit_profile where student_name='" + let + "' AND stu_base_id=(SELECT max(stu_base_id) from student_edit_profile where student_name='" + let + "' )   ";

                                                ResultSet rs25 = st.executeQuery(qr25);
                                                while (rs25.next()) {
                                            %>
                                        Name:  <%=rs25.getString("student_name")%><br><br><br>
                                        School name: <%=rs25.getString("student_school_id")%><br><br><br>
                                        Birth date: <%=rs25.getString("birth_date")%><br><br><br>
                                        Contact no: <%=rs25.getString("student_status")%><br><br><br>
<a href="Server_3Serv?name=<%=rs25.getString("student_name")%>  ">Delete This Entry</a>


                                        <%}%>
                                    </article>
                                </article>
                            </div>
                        </div>
                    </div>
                    <div class="block"></div>
                </div>
            </section>
        </div>
        <!--==============================footer=================================-->
        <footer>
            <div class="padding">
                <div class="main">
                    <div class="container_12">
                        <div class="wrapper">
                            <article class="grid_8">
                                <form id="contact-form" method="post">


                                </form>
                            </article>
                            <article class="grid_4">
                                <ul class="list-services border-bot img-indent-bot">
                                </ul>
                                <!-- {%FOOTER_LINK} -->
                            </article>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>

<%
    } catch (Exception e) {

    }
%>