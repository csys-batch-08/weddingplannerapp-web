<%@page import="com.weddingplanner.module.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>recharge wallet</title>
<style type="text/css">
 body
    {
        background-image: url("images/back1.jpg");
        background-size: cover;
    }
   form{
    color:black;
    font-size: 15px;
    border-radius: 5px;
    margin : 70px 490px;
    padding: 10px 30px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(195, 160, 202, 0.589);
    
}
.text
{
    width: 100%;
    margin:5px 0;  
    border-bottom: 1.5px  solid black;
    background: transparent;
    padding-top:7px;
    border-radius:9px;
}
.button{
        	padding:10.5px 123px;
        	border: 1px solid #f5f58cc5;
        	background-color:rgba(135, 70, 148, 0.589);
        	border-radius:4px;
        	color: black;
        	cursor: pointer; 	
        }
 button:hover{
 opacity:0.5;
 }



   
 
</style>
</head>
<body>
<% int user = (int) session.getAttribute("id");%>
<nav>
     <a href="viewVenues.jsp">Venues</a>
        <a href="viewService.jsp">Services</a>
        <a href="">About us</a>
        <a href="">Contact us</a>
        <a href="login.jsp">Logout</a>
       
        <a href="myBooking.jsp">My booking</a>
        
    </nav>

<div class="form1">
<div class="form2">
<form action="rechargewallet" method="post">
       <h2>Recharge Your Wallet..</h2><br>


         <label for="emailid">Email address</label><br>
         <input type="email" class="text" name="email"  pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
                 
         <label for="cardnumber">Card Number</label><br>
         <input type="text" class="text" name="cardnumber" pattern ="[1-9]{16}" required><br><br>
                 
         <label for="cvv">CVV</label><br>
         <input type="text" class="text" name="cvv" pattern="[1-9]{3}" required><br><br>
         
         <label for="Amount">Amount</label><br>
         <input type="text" class="text" name="amount" pattern="[1-9][0-9]+" maxlength="5" required><br><br>
          
         <button class="button">Recharge Wallet</button>
    </form>
    </div>
    </div>


</body>
</html>