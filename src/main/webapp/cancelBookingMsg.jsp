<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cancelVenue</title>
<style>
body{
    
     background-image: url("images/back1.jpg");
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
    Your Wallet Amount:<%=session.getAttribute("cancelVenue") %><br>
   20% of amount is deducted
    After refund Wallet balance:<%=session.getAttribute("cancelRefundVenue") %>
<% String una=(String) session.getAttribute("cancelled");%>
          <h2><%=una%></h2>
          <% session.removeAttribute("cancelled"); %>
          <button><a href="viewVenues.jsp">Back</a></button>
 </div>        
          
</body>
</html>