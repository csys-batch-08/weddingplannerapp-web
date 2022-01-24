<%@page import="com.weddingplanner.daoimpl.UserDaoimpl"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.module.Ratings"%>
<%@page import="com.weddingplanner.daoimpl.RatingsDaoimpl"%>

<%@page import="com.weddingplanner.module.Services"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book service</title>
<link rel="stylesheet" href="style1.css">
<script src="https://kit.fontawesome.com/ae23c8822d.js"
	crossorigin="anonymous"></script>
<link href="https://use.fontawesome.com/realse/v5.0.8/css/all.css"
	rel="Stylesheet">
<style>
img {
	margin-top: 100px;
	margin-left: 30px;
	width: 400px;
	height: 400px;
}

body {
	background-image: url("images/b3.jpg");
	background-size: cover;
}

span {
	position: relative;
	top: 30px;
	left: 20px;
	font-weight: bold;
}

table td {
	padding: 20px 25px;
}

button a {
	text-decoration: none;
}

.button1 {
	padding: 4px 7px;
	border-radius: 4px;
}

.stars-outer {
	position: relative;
	display: inline-block;
}

.stars-outer::before {
	content: "\f005 ";
	font-family: "Font Awesome 5 Free";
	font-weight: 900;
	color: yellow;
}
.customer{
  
    margin:auto;
  
    border-radius:6px ;
    background-color: rgba(95, 166, 211, 0.5);
    

}
.name{
    color:#838b8b;
    font-weight:bold;
}
.rating-box{
     margin-top:5px;
}
</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="userProfile.jsp">My profile</a></li>
			<li><a href="">about us</a></li>
			<li><a href="">contact us</a></li>
			<li><a href="viewVenues.jsp">Venues</a></li>
			<li><a href="viewService.jsp">services</a></li>
			<li><a href="MyBooking.jsp">my Bookings</a></li>
		</ul>


	</nav>

	<%!ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
	UserDaoimpl user = new UserDaoimpl();%>
	<%
	String serviceName = request.getParameter("serviceName");
	session.setAttribute("serviceName", serviceName);

	Services service = serviceDaoImpl.allService(serviceName);
	int serviceId = serviceDaoImpl.findServiceId(serviceName);
	double servicePackage = serviceDaoImpl.findPackage(serviceId);
	int advanceServiceAmount = (int) (servicePackage * 1 / 2);
	session.setAttribute("serviceId", serviceId);
	session.setAttribute("servicePackage", servicePackage);
	session.setAttribute("advanceServiceAmount", advanceServiceAmount);
	%>

	<table>
		<tbody>
			<tr>
				<td><img src="images/<%=service.getServiceImages()%>"
					alt="hall"></td>

				<td><h1>
						<%=service.getServiceName()%></h1> <br> <span> <i
						class="fas fa-rupee-sign"></i><%=service.getServicePackage()%></span><br>
				<br>
				<br> <span class="desc"><%=service.getServiceDescription()%></span><br>
				<br>
				<br> <span> For booking click here:
						<button class="button">
							<a href="bookservice.jsp">book</a>
						</button>
				</span> <%
 session.setAttribute("serviceName", service.getServiceName());
 %> </span> <br>
				<br> <span>give ratings:
						<button class="button1">
							<a href="ratings.jsp">Rating</a>
						</button>
						<br>
					<br>
				</span> <%
 RatingsDaoimpl ratings = new RatingsDaoimpl();
 Ratings rating = new Ratings();
 List<Ratings> review = ratings.showReview(serviceName);
 rating.getServiceName();
 double rate = ratings.fetchRating(serviceName);
 ratings.showReview(rating.getServiceName());
 %> <span class="stars-outer"><%=rate%></span></td>
			

			</tr>
			</tr>
		</tbody>

	</table>
	<table class="rating-box">
	<tbody>
	    <tr>
				<td><span>Ratings and Review of our customer</span></td>
			</tr>
			<%
			for (Ratings giverating : review) {
			%>
           
			<tr>
               <td>
                <div class="customer">
                <div class="name">
					<%
					String name = user.findUserName(giverating.getUserId());
					%> <%=name%>&nbsp;&nbsp;&nbsp;
					
					<div class="stars-outer">
						<%=giverating.getRating()%>
					</div>
					</div><br>
					 <%=giverating.getReview()%></div></td>
				
			</tr>
			
			<%
			}
			%>
	</tbody>
	
	</table>

</body>


</html>