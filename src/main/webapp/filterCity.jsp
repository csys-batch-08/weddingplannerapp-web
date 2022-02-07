<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>venueCity</title>
<link rel="stylesheet" href="style1.css">
<script src="https://kit.fontawesome.com/ae23c8822d.js"
	crossorigin="anonymous"></script>
<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}

nav a {
	float: center;
	text-decoration: none;
	color: black;
	background-colour: white;
	padding-right: 17px;
	font-size: 17px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="ViewVenuesServlet">Venues</a></li>
			<li><a href="ViewServiceServlet">Services</a></li>
			<li><a href="aboutUs.jsp">About us</a></li>
			<li><a href="contactUs.jsp">Contact us</a></li>
			<li><a href="UserProfileServlet">My Profile</a></li>
			<li><a href="MyBookingServlet">My booking</a></li>
		</ul>
	</nav>
	<c:set var="i" value="0" />
	<c:forEach items="${searchCity}" var="filterVenueCity">
		<c:set var="i" value="${i+1}" />


		<div class="venue">
			<div class="for-inline">
				<div class="image-container">
					<a href="ChooseVenueServlet?venueName=${filterVenueCity.venueName}">
					<img src="assets/images/${filterVenueCity.venueImages}" alt="hall" height="200px" width="350px"></a>
					<div class="title">
						<h2>venue name:${filterVenueCity.venueName }</h2>
					</div>
					  <pre><em class="fas fa-map-marker-alt"></em> ${filterVenueCity.venueCity}         <em class="fas fa-hotel"></em> ${filterVenueCity.venueType} </pre>
					
					
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>