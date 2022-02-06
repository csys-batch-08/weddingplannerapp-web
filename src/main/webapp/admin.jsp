<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>admin</title>
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background-image: url("images/admin.jpg");
	background-size: cover;
}

nav {
	width: 100%;
	height: 50px;
	background-color: rgba(245, 240, 240, 0.4);
	font-weight: bold;
	line-height: 50px;
	padding: 0px 100px;
	position: fixed;
	z-index: 1;
}

nav .logo {
	font-size: 20px;
	font-weight: bold;
	letter-spacing: 1.5px;
}

nav .logo p {
	float: left;
	color: #fff;
	text-transform: uppercase;
}

nav ul {
	float: right;
}

nav ul li {
	display: inline-block;
	list-style: none;
}

nav ul li a {
	color: rgb(20, 16, 16);
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding: 0px 32px;
}

nav ul li a:hover {
	color: #dbe2c2;
}

nav ul li .active {
	color: #c0d96f;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="ViewVenueAdminServlet">View venues</a></li>
			<li><a href="ViewServiceAdminServlet">View services</a></li>
			<li><a href="ViewUserAdminServlet">view users</a></li>
			<li><a href="ViewVenueBookingServlet">view venue Booking</a></li>
			<li><a href="ViewServiceBookingServlet">view service Booking</a></li>
		</ul>
	</nav>
</body>
</html>