

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>recharge wallet</title>
<style type="text/css">
 body
    {
        background-image: url("images/b3.jpg");
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
    background-color: rgba(140, 160, 184, 0.5);
    
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
        	background-color:rgba(80, 93, 109, 0.5);;
        	border-radius:4px;
        	color: black;
        	cursor: pointer; 	
        }
 button:hover{
 opacity:0.5;
 }
 
    *{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
nav{
	width: 100%;
	height: 50px;
	background-color:rgba(102, 83, 83, 0.4);
	line-height: 50px;
	padding:0px 100px;
}
nav ul{
	float: right;
}
nav ul li{
	display: inline-block;
	list-style: none;
}
nav ul li a{
	color:#fff;
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding:0px 32px;
}
nav ul li a:hover{
	color:#c0d96f;
}
 

   
 
</style>
</head>
<body>

<nav>
		<ul>
        <li><a href="ViewVenuesServlet">Venues</a></li>
        <li><a href="ViewServiceServlet">Services</a></li>
        <li><a href="aboutUs.jsp">About us</a></li>
        <li><a href="contactUs">Contact us</a></li>
        <li><a href="UserProfileServlet">My Profile</a></li>
        <li><a href="MyBookingServlet">My booking</a></li>
        </ul>
    
</nav>

<div class="form1">
<div class="form2">
<form action="rechargewallet" method="post">
       <h2>Recharge Your Wallet</h2><br>


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