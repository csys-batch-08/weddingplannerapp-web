<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>venues</title>
<link rel="stylesheet" href="style1.css">
<script src="https://kit.fontawesome.com/ae23c8822d.js"
	crossorigin="anonymous"></script>
<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}

.search {
	padding: 7px;
}

.button {
	padding: 6px 9px;
	border-radius: 4px;
}

button a {
	text-decoration: none;
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
		<form action="filterCity" method="post">
		<label for="search"></label>
		<input type="text" name="search" class="search" id="search">
		<button class="button">search</button>
		</form>
    </nav>
	<c:forEach items="${showVenue}" var="venue">
		<div class="venue">
			<div class="for-inline">
				<div class="image-container">
					<a href="ChooseVenueServlet?venueName=${venue.venueName}"> <img
						src="assets/images/${venue.venueImages }" alt="hall" height="200px"
						width="350px"></a>
					<div class="title">
						<h2>${venue.venueName}</h2>
					</div>
					<div class="pre">
					 <pre><em class="fas fa-map-marker-alt"></em> ${venue.venueCity}         <em class="fas fa-hotel"></em> ${venue.venueType} </pre>
						
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<script>
		
	</script>
</body>
</html>