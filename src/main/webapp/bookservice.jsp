<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book service</title>
<link rel="stylesheet" href="style.css">
<script src="https://kit.fontawesome.com/ae23c8822d.js" crossorigin="anonymous"></script>

<style>
  body
    {
        background-image: url("images/back1.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:350px;
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
<form action="addToService" class="login-box">
		
		
		
    <h1>Book service</h1>
          <label>service Name:</label>
            <input type="text" id="name" class="text" name="venuename" value="<%=session.getAttribute("serviceName")%>"  placeholder="" required>
            <label>service Package:</label>
            <input type="text" id="venuePackage" class="text" name="venuepackage" value="<%=session.getAttribute("servicePackage")%>"  placeholder="" required>
            <label>Advance amount:</label>
           <input type="text" id="advancePackage" class="text" name="advancepackageService" value="<%=session.getAttribute("advanceServiceAmount")%>"  placeholder="" required>

             <label>Event date</label>
            <input type="date"  name="date" id="datefield" required><br><br>
            <input type="submit" value="Book">
            </form>
</body>
<script type="text/javascript">
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
if(dd<10){
  dd='0'+dd
} 
if(mm<10){
  mm='0'+mm
} 
today = yyyy+'-'+mm+'-'+dd;
document.getElementById("datefield").setAttribute("min", today);
</script>
</html>