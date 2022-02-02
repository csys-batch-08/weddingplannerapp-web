<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>service</title>
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
      ${unavailable}
    
            <a href=viewService.jsp><button>Back</button></a>
        </div>  

</body>
</html>