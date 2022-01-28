<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cancelVenue</title>
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
 Your Wallet Amount:${cancelVenue}<br>
   20% of amount is deducted
    After refund Wallet balance:${cancelRefundVenue }
          <h2>${cancelled}</h2>
    <button><a href="viewVenues.jsp">Back</a></button>
 </div>        
          
</body>
</html>