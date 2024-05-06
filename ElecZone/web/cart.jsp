<%-- 
    Document   : cart
    Created on : Apr 30, 2024, 12:19:39 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <title>Document</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- cart css -->
    <link rel="stylesheet" type="text/css" href="css/cart.css">
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
    <!-- header section start -->
    <nav class="custom_menu">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Product</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">About Us</a></li>
        </ul>
    </nav>
    <!-- header section end -->


    <!--Shopping Cart start-->
    <section class="container content-section" id="shopping-cart">
  
        <h3 style="text-decoration: underline;text-align: center; margin-bottom: 7%;">Shopping Cart</h3>
 
        <table class="table table-hover table-cart">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody class="cart-items">
    
     
            </tbody>
        </table>

        <div class="cart-total"> 
           <strong class="cart-total-title">Total</strong>
           <span  class="cart-total-price" style="text-align: right;">$0</span>
        </div>
 

        <div class="btn-purchase" style="margin-top: 10%;">
           <button type="button"  class="btn btn-dark btn-purchase "><i class="fa-solid fa-cart-shopping " style="margin-right: 6%;"></i><a href="buy now.jsp" style="color: white;">BUY NOW</a></button>
        </div>

    </section> 
    <!--Shopping Cart End-->
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

    <!-- cart -->
    <script src="js/cart.js"></script>
    
</body>
</html>
