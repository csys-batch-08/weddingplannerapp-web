<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>home</title>

<style>
body {
	background-image: url("assets/images/wedding4.jpg");
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
	background-color: rgba(223, 206, 222, 0.4);
	
	line-height: 50px;
	padding:0px 100px;
	position:fixed;
	z-index: 1;
}
nav .logo{
	font-size: 20px;
	font-weight: bold;
	letter-spacing: 1.5px; 
}
nav .logo p{
	float: left;
	color:#fff;
	text-transform: uppercase;
}
nav ul{
	float: right;
	
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
	padding:0px 22px;
}
nav ul li a:hover{
	color:#c0d96f;
}
nav ul li .active{
	color:#c0d96f;
}
.image img{
	width: 100%;
	height: 0px auto;
	opacity: 0.80;
}
</style>
</head>
<body>
	<nav>
	   <div class="logo">
			<p>WeddingPlanner</p>
		</div>
		<ul>
		
		<li><a href="ViewVenuesServlet">Venues</a></li>
		<li><a href="ViewServiceServlet">Services</a></li>
		<li><a href="rechargeWallet.jsp">Wallet</a></li>
		<li><a href="aboutUs.jsp">About us</a></li> 
		<li><a href="contactUs.jsp">Contact us</a></li> 
		<li><a href="UserProfileServlet">My Profile</a></li> 
		<li><a href="MyBookingServlet">My bookings</a></li>
		</ul>
	</nav>
</body>
</html>