<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>bookvenue</title>

<style>
 body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:550px;
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
 background-color:rgba(131, 72, 143, 0.5);
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


   
<form action="book" method="post"  class="login-box" >
         <h1>Book Venue</h1>
          <label>venue Name:</label>
            <input type="text" id="name" class="text" name="venuename" value="${venuename}"  placeholder="" required>
            <label>No.of.guest:</label>
            <input type="text" id="number" class="text" name="noOfGuest" placeholder="" pattern="[0-9]+"  required>
            <label>venue Package:</label>
            <input type="text" id="venuePackage" class="text" name="venuepackage" value="${venuepackage}"  placeholder="" required>
            <label>Advance Amount:</label>
            <input type="text" id="advancePackage" class="text" name="advancepackage" value="${advanceAmount}"  placeholder="" required>
            <label>Event date</label>
            <input type="date"  name="eventDate" id="datefield" required><br><br>
           
            <a href="viewVenues.jsp"><button class="button">Back</button></a>
             <button type="submit" class="button">Book</button>
           
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
var todayMax = new Date();
var dd = todayMax.getDate()+30;
var mm = todayMax.getMonth()+1; 
var yyyy = todayMax.getFullYear();
if(dd<10){
  dd='0'+dd
} 
if(mm<10){
  mm='0'+mm
} 
todayMax = yyyy+'-'+mm+'-'+dd;
document.getElementById("datefield").setAttribute("max", todayMax);
</script>

</html>