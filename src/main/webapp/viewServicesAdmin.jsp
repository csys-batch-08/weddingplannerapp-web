
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View all services</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background-image: url("images/adminImage.jpg");
	background-size: cover;
}

table {
	margin-left: 10px;
	background-color: rgba(172, 209, 231, 0.5);
	border-radius: 13px;
	padding: 50px;
}

#allusers table, th, tr, td {
	border-collapse: collapse;
	padding: 10px;
	border: none;
}



.set {
	margin-top: 10px;
	text-align: center;
}

nav {
	margin-top: 0%;
	width: 100%;
	height: 50px;
	background-color: rgba(245, 240, 240, 0.4);
	font-weight: bold;
	line-height: 50px;
	padding: 0px 100px;
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

h1 {
	margin-left: 520px;
}

.button {
	margin-left: 350px;
}
</style>
</head>
<body>
	<nav>

		<ul>
			<li><a href="viewVenueAdminServlet">View venues</a></li>
			<li><a href="ViewServiceAdminServlet">View services</a></li>
			<li><a href="ViewUserAdminServlet">view users</a></li>
			<li><a href="ViewVenueBookingServlet">view venue Booking</a></li>
			<li><a href="ViewServiceBookingServlet">view service Booking</a></li>

		</ul>
	</nav>
	<h1>
			<strong>All Service List</strong>
		</h1>
    <a href="addServices.jsp" style="text-decoration: none"><button
			type="button" class="button">Add Service</button></a>
	
	<table>
		<caption></caption>
		
		<thead>
			<tr>
				<th id="heading">s.no</th>
				<th id="head1">service name</th>
				<th id="head2">service Package</th>
				<th id="head3">Availability</th>
				<th id="head3">service type</th>
				<th id="head3">description</th>
				<th id="head">Action</th>
				<th id="head">Action</th>
			</tr>
		</thead>
		<br>
		<br>
		<tbody>
			<c:forEach items="${serviceListAdmin}" var="serviceAdmin">
				<c:set var="i" value="${i+1}" />
				<tr>
					<td>${i}</td>
					<td>${serviceAdmin.serviceName}</td>
					<td>${serviceAdmin.servicePackage}</td>
					<td>${serviceAdmin.availability}</td>
					<td>${serviceAdmin.serviceType}</td>
					<td>${serviceAdmin.serviceDescription}</td>
					<td><a
						href="GetServiceUpdate?serviceIdShow=${serviceAdmin.serviceId}&serviceNameShow=${serviceAdmin.serviceName}&servicePackageShow=${serviceAdmin.servicePackage}&serviceTypeShow=${serviceAdmin.serviceType}&serviceDescriptionShow=${serviceAdmin.serviceDescription}"
						style="text-decoration: none"><button>Update</button></a></td>
						<td><a href="InactiveServiceServlet?serviceIdAdmin=${serviceAdmin.serviceId}" style="text-decoration: none"><button>inactive</button></a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	





</body>
</html>