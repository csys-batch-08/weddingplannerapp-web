<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venue</title>
</head>
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
<body>
<div class="set">
<% String booked=(String) session.getAttribute("unavailable");%>
          <h2><%=booked%></h2>
          <% session.removeAttribute("unavailable"); %>
            <button><a href=viewVenues.jsp>Back</a></button>
            </div>
</body>
</html>