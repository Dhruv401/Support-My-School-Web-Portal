<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
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
                            <div class=ls>

                                <a href="school_stu.jsp">Logout </a>	

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
                                    <li><a href="stu_pro_final.jsp">Home</a></li>
                                    <li><a href="vision_another_stu.jsp">Vision</a></li>
                                    <li><a href="services_another_stu.jsp">Services</a></li>
                                    <li><a href="About_us_another_stu.jsp">About Us</a></li>
                                    <li><a href="contact_us_another_stu.jsp">Contact Us</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="row-bot">
                    <div class="center-shadow"></div>
                </div>
            </header>

            <!--==============================content================================-->
            <section id="content"><div class="ic"></div>
                <div class="content-bg">
                    <div class="main">
                        <div class="container_12">
                            <div class="wrapper">
                                <article class="grid_4">

                                   <img src="ImageSavings/ImageSavings1_796464208.jpg" alt="Image Not Found" height="180px" width="160px"><br><br>
                                    <br>
                                    <%
                                        HttpSession hsp = request.getSession(true);
                                        String stu_name123 = (String) hsp.getAttribute("stu_nm");
                                    %>
                                    <h3> <%=stu_name123%></h3>
                                    <br>
                                    <a href="stu_edit_pro.jsp">Update Profile</a><br><br>


                                </article>
                                <article class="grid_8">

                                    <h50>MY PROFILE</h50><br><br><br>
                                        <%
                                            try {
                                                String Driver = "com.mysql.jdbc.Driver";
                                                String db = "schoolportal";
                                                String url = "jdbc:mysql://localhost:3306/";
                                                String user = "root";
                                                String password = "";

                                                String qry = "select * from student_edit_profile where student_name='" + stu_name123 + "' AND stu_base_id=(SELECT max(stu_base_id) from student_edit_profile where student_name='" + stu_name123 + "') ";

                                                Class.forName(Driver).newInstance();
                                                Connection con = DriverManager.getConnection(url + db, user, password);
                                                Statement st = con.createStatement();
                                                ResultSet rs = st.executeQuery(qry);
                                                while (rs.next()) {%>


                                    <label><span class="text-form"><h25> Name   </h25></span>
                                        <h26><%=rs.getString("student_name")%><br><br></h26>
                                    </label>

                                    <br>
                                    <label><span class="text-form"><h25> School Name </h25></span>
                                        <h26><%=rs.getString("student_school_id")%></h26><br><br>
                                    </label> <br>
                                    <label><span class="text-form"><h25>Date Of Birth </h25></span>
                                        <h26><%=rs.getString("birth_date")%></h26><br><br>
                                    </label> <br>
                                    <label><span class="text-form"><h25> Standard </h25></span>
                                        <h26><%=rs.getString("student_classno")%></h26><br><br>
                                    </label> <br>
                                    <label><span class="text-form"><h25>Phone no </h25></span>
                                        <h26><%=rs.getString("student_status")%></h26>
                                    </label> <br><br><br>
                                    <label><span class="text-form"><h25>Average Grade</h25></span>
                                        <h26><%=rs.getString("student_grade")%></h26>
                                    </label> <br>



                                    <%}%>

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
                                <h4>Contact Form:</h4>
                                <form id="contact-form" method="post">
                                    Please send mail on the following email address with subject SchoolPortal.<br>
                                    neilthaker@yahoo.com<br>
                                    dhruvpatel401@yahoo.in<br>
                                    We will do response accordingly.<br>
                                    Thank you for spending your precious time.<br>         

                                </form>
                            </article>
                            <article class="grid_4">
                                <h4 class="indent-bot">Link to Us:</h4>
                                <ul class="list-services border-bot img-indent-bot">
                                    <li><a href="https://www.facebook.com/" target="_blank">Facebook</a></li>
                                    <li><a class="item-1" href="http://www.twitter.com/" target="_blank">Twitter</a></li>
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