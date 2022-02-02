<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>service</title>
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
<form action="updateService" method="post" class="login-box">
     <label>Service name</label>
     <input type="text" name="serviceName" required>
     <label>Service Package</label>
     <input type="number" name="servicePackage" required>
     <label>service Image</label>
     <input type="file" name="serviceImage" required>
     <label>service type</label>  
     <input type="text" name="type" required>
     <label>service Description:</label>
      <input type="text" name="description" required>
     
     <label>sevice type image</label>
     <input type="file" name="serviceTypeImage" required><br><br><br>
 <a href="viewServicesAdmin.jsp"><button class="button">Back</button></a>
<button type="submit" class="button">Update</button>
     
</form>
</body>
</html>