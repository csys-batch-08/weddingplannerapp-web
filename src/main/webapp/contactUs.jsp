<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<script src="https://kit.fontawesome.com/ae23c8822d.js"
	crossorigin="anonymous"></script>

<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}

* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

nav {
	width: 100%;
	height: 50px;
	background-color: rgba(102, 83, 83, 0.4);
	line-height: 50px;
	padding: 0px 100px;
}

nav ul {
	
}

nav ul li {
	display: inline-block;
	list-style: none;
}

nav ul li a {
	color: #fff;
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding: 0px 32px;
}

nav ul li a:hover {
	color: #c0d96f;
}

.contact-info {
	color: rgb(14, 10, 10);
	max-width: 500px;
	line-height: 65px;
	padding-left: 50px;
	font-size: 18px;
	margin-left: 460px;
	margin-top: 200px;
}

.contact-info i {
	margin-right: 20px;
	font-size: 25px;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="ViewVenuesServlet">Venues</a></li>
			<li><a href="ViewServiceServlet">Services</a></li>
			<li><a href="aboutUs.jsp">About us</a></li>
			<li><a href="contactUs">Contact us</a></li>
			<li><a href="UserProfileServlet">My Profile</a></li>
			<li><a href="MyBookingServlet">My booking</a></li>
		</ul>

	</nav>

	<div class="contact-info">
		<div>
			<em class="fas fa-map-marker-alt"></em>51,kk nagar, Chennai
		</div>
		<div>
			<em class="fas fa-envelope"></em>wedplanner@gmail.com
		</div>
		<div>
			<em class="fas fa-phone"></em>9791609661
		</div>
		<div>
			<em class="fas fa-clock"></em>Mon - sat 8:00 AM to 9:00 PM
		</div>
	</div>
</body>
</html>