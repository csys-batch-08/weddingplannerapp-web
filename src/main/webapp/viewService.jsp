<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>service</title>
<link rel="stylesheet" href="style1.css">


<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}
form input {
	margin-left: -52px;
	padding: 7px;
	border: none;
	border: 1px solid gray;
	border-radius: 6px;
	outline: none;
}

img {
	height: 250px;
	width: 280px;
	overflow: hidden;
	margin-top: 40px;
	display: block;
	border-radius: 20px;
}

span {
	position: relative;
	top: 360px;
	left: 50px;
}

table td {
	padding: 30px 10px;
	font-weight: bold;
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
		<form action="filterPrice" method="post">
		<label for="byPrice"></label>
			<input type="text" name="byPrice" class="search" id="byPrice">
			<button class="button">search</button>
		</form>

	</nav>
	<table>
		<caption></caption>
		<tbody>
			<tr>
				<th id="tableHead"></th>

				<c:set var="count" value="1" />
				<c:forEach items="${viewServices}" var="services">

					<td>
						<table>
							<caption></caption>
							<tbody>

								<tr>
									<th id="tableHead"></th>
									<td><a
										href="ShowServiceServlet?serviceType=${services.serviceType}"><img
											src="assets/images/${services.serviceTypeImage}" alt="hall"
											height="250px" width="280px"></a><br>
									${services.serviceType}</td>

									

								</tr>

							</tbody>
						</table>

					</td>
					<c:choose>
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