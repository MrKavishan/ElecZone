<%-- 
    Document   : ContactForm
    Created on : Apr 28, 2024, 1:25:56 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Contact Form</title>
    </head>
    <body>
        <div class="form-heading">
            <h1>Talk to us</h1>
        </div>
        <form>      
            <input name="name" type="text" class="feedback-input" placeholder="Name" />   
            <input name="email" type="text" class="feedback-input" placeholder="Email" />
            <textarea name="text" class="feedback-input" placeholder="Comment"></textarea>
            <input type="submit" value="SUBMIT"/>
        </form>
    </body>
</html>
