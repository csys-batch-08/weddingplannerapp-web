<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<script src="https://kit.fontawesome.com/ae23c8822d.js" crossorigin="anonymous"></script>

<style>
 body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
    *{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
nav{
	width: 100%;
	height: 50px;
	background-color:rgba(102, 83, 83, 0.4);
	line-height: 50px;
	padding:0px 100px;
}
nav ul{
	
}
nav ul li{
	display: inline-block;
	list-style: none;
}
nav ul li a{
	color:#fff;
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding:0px 32px;
}
nav ul li a:hover{
	color:#c0d96f;
}
 .contact-info{
 
  color: rgb(14, 10, 10);
  max-width: 500px;
  line-height: 65px;
  padding-left: 50px;
  font-size: 18px;
  margin-left:460px;
  margin-top:200px;
}

.contact-info i{
  margin-right: 20px;
  font-size: 25px;
}
</style>
</head>
<body>
   <nav>
		<ul>
           <li><a href="userProfile.jsp" >My profile</a></li>
      	   <li><a href="">about us</a></li>
		   <li><a href="">contact us</a></li>
			<li><a href="viewVenues.jsp">Venues</a></li>
			<li><a href="viewService.jsp">services</a></li>
            <li><a href="MyBooking.jsp">my Bookings</a></li>
        </ul>
    
</nav>
          
  <div class="contact-info">
    <div><i class="fas fa-map-marker-alt"></i>51,kk nagar, Chennai</div>
    <div><i class="fas fa-envelope"></i>wedplanner@gmail.com</div>
    <div><i class="fas fa-phone"></i>9791609661</div>
    <div><i class="fas fa-clock"></i>Mon - sat 8:00 AM to 9:00 PM</div>
    </div>
</body>
</html>