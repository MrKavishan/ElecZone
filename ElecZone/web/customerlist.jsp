<%-- 
    Document   : customerlist
    Created on : Apr 27, 2024, 5:58:48 PM
    Author     : User
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"/>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Poppins' >
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                font-family: 'Poppins';
                font-size: 22px;
                overflow: hidden;
            }
            .table{
                width:100%;
                
            }
            .table_header{
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 20px;
                background-color: #fff8bd;
            }
            .table_header p{
                color: #000;
            }
            button{
                outline: none;
                border: none;
                border-radius: 5px;
                cursor: pointer;
               
            }
            .add_new{
                padding: 10px 20px;
                color: #000;
                background-color: #ffaa00;
            }
            .input_place{
                padding: 10px 20px;
                margin: 0px 10px;
                outline: none;
                border: 1px solid #ffaa00;
                border-radius: 6px;
                color: #ffaa00;
            }
            ::placeholder{
                color: #ffaa00;
            }
            .table_section{
                height: 650px;
                overflow: auto;
            }
            table{
                width: 100%;
                table-layout: fixed;
                min-width: 1000px;
                border-collapse: collapse;
            }
            thead th{
                position: sticky;
                top: 0;
                background-color: #fffccc;
                color: #2b210f;
                font-size: 15px;
            }
            th,td{
                border-bottom: 1px solid white;
                padding: 10px 20px;
                word-break: break-all;
                text-align: center;
            }
            tr:hover td{
                color: #ffaa00;
                cursor: pointer;
                background-color: #fffccc;
            }
            a{
                padding: 10px;
                color: #ffffff;
                outline: none;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            td a:nth-child(1){
                background-color: #ffaa00;
            }
            td a:nth-child(2){
                background-color: red;
            }
            ::-webkit-scrollbar{
                height: 5px;
                width: 5px;
            }
        </style>
    </head>
    <body>
        
        <div class="table">
            <div class="table_header">
                <p>Customer Details</p>
                <div>
                    <input class="input_place" placeholder="customer"/>
                    <a href="NewCustomerServlet" ><button class="add_new">Add new</button></a>
                </div>
            </div>
            <div class="table_section">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Mobile</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customerlist}" >
                            <tr>
                                <td><c:out value="${customer.id}"/></td>
                                <td><c:out value="${customer.name}"/></td> 
                                <td><c:out value="${customer.email}"/></td>
                                <td><c:out value="${customer.password}"/></td>
                                <td><c:out value="${customer.mobile}"/></td>
                                <td>
                                    <a href="/ElecZone/EditCustomerServlet?id=<c:out value="${customer.id}"/>"><i class="fa-solid fa-pen-to-square"></i></a> &nbsp;&nbsp;
                                    <a href="/ElecZone/DeleteCustomerServlet?id=<c:out value="${customer.id}"/>"><i class="fa-solid fa-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
        
        <%--
        <h1>Customer DataBase</h1>
        <br><br>
        <a href="NewCustomerServlet" >New Customer</a>
        <br><br>
        <table >
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Mobile</th>
                <th>Action</th>
                
            </tr>
            
            <c:forEach var="customer" items="${customerlist}" >
                <tr>
                    <td><c:out value="${customer.id}"/></td>
                    <td><c:out value="${customer.name}"/></td> 
                    <td><c:out value="${customer.email}"/></td>
                    <td><c:out value="${customer.password}"/></td>
                    <td><c:out value="${customer.mobile}"/></td>
                    <td>
                        <a href="/ElecZone/EditCustomerServlet?id=<c:out value="${customer.id}"/>">update</a> &nbsp;&nbsp;
                        <a href="/ElecZone/DeleteCustomerServlet?id=<c:out value="${customer.id}"/>">delete</a>
                    </td>
                </tr>
            </c:forEach> 
           
        </table>
        --%>
        
    </body>
</html>
