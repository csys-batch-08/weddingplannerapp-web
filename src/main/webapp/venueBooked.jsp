<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>booked</title>
<style>
body{
    
     background-image: url("images/b3.jpg");
        background-size: cover;
    }
    .set{
    text-align:center;
    font-size:30px;
    margin-top:250px;
    font-weight:bold;
    }
    
    
    .button{
		padding: 4px 7px;
		border-radius: 4px;
	}	
	button a{
	text-decoration:none;
	}   
</style>
</head>
<body>

    <div class="set">
     Your Wallet Amount:${venueBalance}<br>
    Amount deducted:${advanceAmount}<br>
    After deduction Wallet balance:${venuePayBalance}
    <h2>${booked}</h2>
    
   
          <a href=home.jsp><button class="button">  Back</button></a>
        </div>  

</body>
</html>