<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service booked</title>
</head>
<style>
 body
    {
        background-image: url("images/back1.jpg");
        background-size: cover;
    }
    nav a{
        float:center;
        text-decoration: none;
        color:black;
        background-colour:white;
        padding-right: 17px;
        font-size: 17px;
        margin-top: 10px;
    }
     .set{
    text-align:center;
    font-size:30px;
    margin-top:250px;
    }
    .button{
		padding: 4px 7px;
		border-radius: 4px;
	}	   
	button a{
	text-decoration:none;
	}
    
</style>
<body>

   
    <div class="set">
     Your Wallet Amount:<%=session.getAttribute("userWalletBalance") %><br>
    Amount deducted:<%=session.getAttribute("servicePackage") %><br>
    After deduction Wallet balance:<%=session.getAttribute("servicePayBalance") %>
 <% String booked=(String) session.getAttribute("servicebooked");%>
          <h2><%=booked%></h2>
          <% session.removeAttribute("servicebooked"); %>
          <button class="button"> <a href=index.jsp> Back</a></button>
          
    </div>     
</body>
</html>