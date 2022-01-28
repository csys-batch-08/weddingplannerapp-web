
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
<style>                                           
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:600px;
    margin:auto;
    margin-top:3px;
    background-color:rgba(195, 160, 202, 0.589);
    border-radius:15px;
    
}
h1{
    text-align:center;
    padding-top:-15px;
}
form{
    padding:30px 20px;
    width:300px;
    margin-left:30px;
    text-align:center;
}
form label{
    display:flex;
    margin-top:30px;
    font-size:18px;
    margin-left:30px;
   
}
form input{
    width:300px;
    padding:7px;
    border:none;
    border:1px solid gray;
    border-radius: 6px;
    outline:none;
}
.button{
 padding:7px 50px;
 border-radius:4px;
 background-color:violet;
 border:1px solid violet;
 cursor:pointer;
 display:inline-flex;
 
}
button a{
    text-decoration:none;
    color:black;
}
            

                                         
       
</style>
</head>
<body>
<form action="insertServices" method="post" class="login-box">
<label>service name:</label>
<input type="text" name="serviceName" pattern="[a-zA-Z]{3,}" required><br>
<label>service package:</label>
<input type="text" name="servicePackage" pattern="[0-9]+" required><br>
<label>service image:</label>
<input type="file" name="image" required><br>
<label>service type:</label>
<input type="text" name="type" pattern="[a-zA-Z]{3,}" required><br><br>
<label>service description:</label>
<input type="text" name="description" pattern="[a-zA-Z]{3,}" required>
<label>service Type image:</label>
<input type="file" name="serviceTypeImage"><br><br>
<button class="button"><a href="viewServicesAdmin.jsp">Back</a></button>
<button type="submit" class="button">Add</button>
</form>
</body>
</html>


