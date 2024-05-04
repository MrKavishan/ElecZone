<%-- 
    Document   : ContactUs
    Created on : Apr 28, 2024, 10:53:11 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
      
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <title>Contact Us</title>
        
        <!--css-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
        
        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Open+Sans:400,700&display=swap&subset=latin-ext" rel="stylesheet">
        <style>
            body{
                box-sizing: border-box;
                margin: 0;
                padding: 0;
                background: #0f0c29;  /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #24243e, #302b63, #0f0c29);  /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #24243e, #302b63, #0f0c29); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
        </style>
    </head>
    <body>
        <!--header section start-->
        <nav class="custom_menu">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Product</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">About Us</a></li>
            </ul>
        </nav>
        <!--header section end-->
        <!--contact section start-->
        <div class="contact_section layout_padding">
         <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="contact_taital" style="font-size: 90px">Get In Touch</h1>
                    <p class="contact_text" style="font-size: 20px;font-style: italic;text-align: left">
                        You've got some Q's and we've tons and tons of A's. Ask us about an order, a product, what you should name your puppy...anything we can help with! Don't be shy - we promise we're really nice.
                    </p>
                </div>
                <div class="col-md-6">
                    <div class="contact_main">
                        <div class="contact_bt" style="text-align: center;justify-content: center;margin-top: 150px;margin-left: 200px;margin-right: 200px;border-radius: 50px;font-size: 30px;background-color: red">
                            <a href="ContactForm.jsp">Let's talk</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <br><br><br>
        <div>
            <p style='font-size: 80px;margin-left: 50px'>We're here</p>
            <br>
        </div>
        <div class="map_main">
            <div class="map-responsive">
               <iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&amp;q=Eiffel+Tower+Paris+France" width="600" height="400" frameborder="0" style="border:0; width: 100%;" allowfullscreen=""></iframe>
            </div>
        </div>
        <!--contact section end-->
        <!-- footer section start -->
        <div id="footer"></div>
            <div class="footer_section layout_padding">
                <div class="container">
                    <div class="footer_text"> Your Hub for Cutting-Edge Electronics!"<br>
                            Where the place that your dream come true.
                    </div>
                    <div class="footer_logo">
                        <a href="index.html"><img src="images/logo.png" /></a>
                    </div>
                    <div class="input_bt">
                        <input type="text" class="mail_bt" placeholder="Your Email" name="Your Email"/>
                        <span class="subscribe_bt" id="basic-addon2"><a href="#">Contact Us</a></span>
                    </div>
                    <div class="footer_menu">
                        <ul>
                        </ul>
                    </div>
                    <div class="location_main">
                        Hot Line Number : <a href="#">+94 11 233 1200</a>
                    </div>
                </div>
            </div>
        
        <!-- footer section end -->
        <!-- Java script files-->
        <script src="js/custom.js"></script>
    </body>
</html>
