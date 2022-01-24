<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venue update</title>
<style>
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:500px;
    margin:auto;
    margin-top:30px;
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

 

</style>
</head>
<body>
<form action="update" method="post" class="login-box">
<label>venue name:</label>
    <input type="text" name="venueName"><br>
    <label>Venue vendor name:</label>
    <input type="text" name="venueVendorName" values=""><br>
    <label>contact number:</label>
    <input type="number" name="contactNumber"> <br>
    <label>Venue Image:</label>
    <input type="file" name="venueImage"><br>
    <label>venue package:</label>
    <input type="number" name="venuePackage"><br><br>
    <input type="submit" value="Update">
   </form>

</body>
</html>