<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
 <style>
    body
    {
        background-image: url("images/wedding4.jpg");
        background-size: cover;
    }
    nav a{
        float:right;            
        text-decoration: none;
        color:white;
        padding-right: 17px;
        font-size: 17px;
        margin-top: 10px;
    }
    </style>
</head>
<body>
    <nav>
     <a href="login.jsp">Logout</a>
        <a href="viewVenuesServlet">Venues</a>
        <a href="ViewServiceServlet">Services</a>
        <a href="rechargewallet.jsp">Wallet</a>
        <a href="AboutUs.jsp">About us</a>
        <a href="">Contact us</a>
        <a href="UserProfileServlet">My Profile</a>
       
        <a href="MyBookingServlet">My booking</a>
        
    </nav>
</body>
</html>