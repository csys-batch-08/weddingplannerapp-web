<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>show service</title>
<link rel="stylesheet" href="style1.css">

</head>
<style>
body {
	background-image: url("assets/images/b3.jpg");
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



	<table>
		<caption></caption>
		<tbody>
			<tr>
				<th id="tableHead"></th>
				<c:set var="count" value="1" />
				<c:forEach items="${serviceShow}" var="servicelist">
					<td>
						<table id="service">
							<caption></caption>
							<tbody>
								<tr>
									<th id="tableHead"></th>
									<td><a
										href="ChooseServiceServlet?serviceName=${servicelist.serviceName }"><img
											src="assets/images/${servicelist.serviceImages}" alt="hall"
											height="250px" width="280px"></a> <span>${servicelist.serviceName}<br></span>
										<span>package:${servicelist.servicePackage}</span></td>
								</tr>
							</tbody>
						</table>
					</td>
					<c:choose>
						<c:when test="${count==3}">
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