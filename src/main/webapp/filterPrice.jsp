<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>searchByprice</title>
<style>
body {
	background-image: url("images/back1.jpg");
	background-size: 1400px 653px;
}

img {
	height: 250px;
	width: 280px;
	overflow: hidden;
	margin-top: 60px;
	margin-left: 50px;
	border-radius: 20px;
}

span {
	position: relative;
	top: 30px;
	left: 60px;
}

table td {
	padding: 20px 25px;
}

.button {
	padding: 6px 9px;
	border-radius: 4px;
}

button a {
	text-decoration: none;
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
	color: #fff;
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding: 0px 32px;
}

nav ul li a:hover {
	color: #c0d96f;
}

nav ul li .active {
	color: #c0d96f;
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
	<table>
		<caption></caption>
		<tbody>
			<tr>
				<c:set var="count" value="1" />
				<c:forEach items="${servicePrice}" var="servicePriceList">
					<th id="table">
						<table id="service">
							<caption></caption>
							<tbody>

								<tr>
									<th id="table"></th>
									<td><a
										href="service1.jsp?serviceName=${servicePriceList.serviceName}"><img
											src="images/${servicePriceList.serviceImages }" alt="hall"
											height="250px" width="280px"></a><br> service
										name:${servicePriceList.serviceName} <br>service
										package:${servicePriceList.servicePackage}</td>
								</tr>

							</tbody>
						</table> <c:choose>
							<c:when test="${count==4}">
								<c:set var="count" value="1" />

							</c:when>
							<c:otherwise>
								<c:set var="count" value="${count+1}" />
							</c:otherwise>
						</c:choose>
				</c:forEach>

			</tr>
		</tbody>
	</table>

</body>
</html>