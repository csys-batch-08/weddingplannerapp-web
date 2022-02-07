<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Venue update</title>
<style>
body
    {
        background-image: url("assets/images/adminImage.jpg");
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
<form action="update" method="post" class="login-box" id="updateVenue">
<label for="venueNameShow">venue name:</label>
    <input type="text" name="venueNameShow" id="venueNameShow" value="${venueNameView}" pattern="[A-Za-z ]{3,}"><br>
    <label for="venueVendorName">Venue vendor name:</label>
    <input type="text" name="venueVendorNameShow" id="venueVendorName" value="${venueVendorNameView}" pattern="[A-Za-z ]{3,}"><br>
    <label for="contactNumber">contact number:</label>
    <input type="text" name="contactNumberShow" id="contactNumber" value="${contactNumberView}" pattern="[6-9][0-9]{9}"> <br>
    <label for="venueImage">Venue Image:</label>
    <input type="file" name="venueImage" id="venueImage" value="${venueImageView}"><br>
    <label for="venueType">venue type:</label>
    <input type="text" name="venueType" id="venueType" value="${venueTypeView}" pattern="[A-Za-z ]{3,}" required><br>
    <label for="venuePackage">venue package:</label>
    <input type="number" name="venuePackage" id="venuePackage" min="10000" max="100000" value="${venuePackageView}"><br><br>
    <label for="venueDescription">venue description:</label>
    <input type="text" name="venueDescription" id="venueDescription"  value="${venueDescriptionShow}" pattern="[A-Za-z ]{3,}"> required><br>
    <a href="viewVenueAdmin.jsp"><button class="button">Back</button></a>
    <button type="submit" class="button">Update</button>
  </form>
</body>
</html>