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
        background-image: url("assets/images/adminImage.jpg");
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
     <label for="serviceName">Service name</label>
     <input type="text" name="serviceName"  id="serviceName" pattern="[A-Za-z ]{3,}" value="${serviceNameView}" required>
     <label for="servicePackage">Service Package</label>
     <input type="number" name="servicePackage"   min="10000" max="100000" id="servicePackage" value="${servicePackageView}" required>
     <label for="serviceImage">service Image</label>
     <input type="file" name="serviceImage" id="serviceImage" required>
     <label for="type">service type</label>  
     <input type="text" name="type"  id="type" pattern="[A-Za-z ]{3,}" value="${serviceTypeView}" required>
     <label for="description">service Description:</label>
     <input type="text" name="description"  id="description" pattern="[A-Za-z ]{3,}" value="${serviceDescriptionView}" required>
     <label for="serviceTypeImage">sevice type image</label>
     <input type="file" name="serviceTypeImage" id="serviceTypeImage" required><br><br><br>
     <a href="viewServicesAdmin.jsp"><button class="button">Back</button></a>
     <button type="submit" class="button">Update</button>
     </form>
</body>
</html>