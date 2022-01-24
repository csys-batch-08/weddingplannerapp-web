<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>balance</title>
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
 <% String booked=(String) session.getAttribute("lowBalance");%>
          <h2><%=booked%></h2>
          <% session.removeAttribute("lowBalance"); %>
         <button><a href=rechargewallet.jsp>rechargeYourWallet</a></button>
   </div>       

</body>
</html>