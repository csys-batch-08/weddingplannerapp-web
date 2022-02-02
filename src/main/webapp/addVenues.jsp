<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Venues</title>
<style>
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:850px;
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

<form action="insert" method="post" class="login-box">
<h1>venue details</h1>
<label>venue name:</label>
<input type="text" name="venueName" pattern="[a-zA-Z]{3,}" required><br>
<label>venue area:</label>
<input type="text" name="venueArea" pattern="[a-zA-Z]{3,}" required><br>
<label>venue city:</label>
<input type="text" name="city" pattern="[a-zA-Z]{3,}" required><br>
<label>venue type:</label>
<input type="text" name="venueType" pattern="[a-zA-Z]{3,}" required><br>
<label>venue vendor name:</label>
<input type="text" name="vendorName" pattern="[a-zA-Z]{3,}" required><br>
<label>contact number:</label>
<input type="text" name="contactNumber" pattern="[6-9][0-9]{9}" required><br>
<label>venue Package:</label>
<input type="text" name="venuePackage" pattern="[0-9]+" required><br>
<label>availability:</label>
<input type="text" name="availability" pattern="[a-zA-Z]{3,}" required><br>
<label>venue Image:</label>
<input type="file" name="image" required><br><br>
<a href="viewVenueAdmin.jsp"><button class="button">Back</button></a>
		<button type="submit" class="button">Add</button>

</form>
</body>
</html>