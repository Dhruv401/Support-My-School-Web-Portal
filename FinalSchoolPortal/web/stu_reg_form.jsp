<!DOCTYPE html>
<html lang="en">
    <head>
        <script>
            function validateForm()
            {
                var x = document.forms["signup"]["student_name"].value;
                if (x == null || x == "")
                {
                    alert("Student Name must be filled out");
                    return false;
                }
            }
        </script>

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

                                <a href="school_stu.jsp">Login </a>	


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
                                    <li><a href="stu_reg_form.jsp">Home</a></li>
                                    <li><a href="vision_stu.jsp">Vision</a></li>
                                    <li><a href="services_stu.jsp">Services</a></li>
                                    <li><a href="About_us_stu.jsp">About Us</a></li>
                                    <li><a href="contact_us_stu.jsp">Contact Us</a></li>
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
            <section id="content"><div class="ic">More Website Templates @ TemplateMonster.com. December10, 2011!</div>
                <div class="content-bg">
                    <div class="main">
                        <div class="container_12">
                            <div class="wrapper">
                                <article class="grid_4">



                                </article>
                                <article class="grid_8">

                                    <h1>Registration for Students</h1><br><br><br><br><br><br>
                                    <form method="post" name="signup" action="stu_reg_formServlet" id="contact-form2" onsubmit="return validateForm()">
                                        <fieldset>
                                            <label><span class="text-form">Student Name:</span>
                                                <input name="student_name" type="text" size="45px" required="required"/>
                                            </label> 


                                            <label><span class="text-form">Gender   :</span>
                                                <select name="student_gender" >
                                                    <option  value="male">male</option>
                                                    <option value="female">female</option> 
                                                </select> 
                                            </label> 
                                            <label><span class="text-form">Email:</span>
                                                <input name="student_email" type="email" size="45px" required="required"/>
                                            </label>  



                                            </label> 
                                            <label><span class="text-form">School Name:</span>
                                                <input name="school_name" type="text" size="45px" required="required"/>
                                            </label>  


                                            <div class="wrapper">
                                                <div class="text-form">Address :</div>
                                                <div class="extra-wrap">
                                                    <textarea name="student_address" style="width:260px; height:100px; " required="required"></textarea>
                                                </div><br>    
                                                <label><span class="text-form">Username   :</span>
                                                    <input name="student_usrname" type="text" size="45px" required="required"/>
                                                </label> 
                                                <label><span class="text-form">Password   :</span>
                                                    <input name="student_pass" type="password" size="45px" required="required"/>
                                                </label>    

                                                <br>
                                                <label> <span class="text-form">
                                                        <input type="submit" name="submit" value="Submit" />
                                                    </span>
                                                    <input type="submit" name="cancel" value="Cancel"/>
                                                </label>  		
                                        </fieldset>

                                    </form>




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



