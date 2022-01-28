
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
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
    background-color: rgba(148, 170, 196, 0.5);
    

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

	
	<table>
		<tbody>
			<tr>
			 <c:out  value="${chooseService}" />
				<td><img src="images/${chooseService.serviceImages}"
					alt="hall"></td>

				<td><h1>${chooseService.serviceName}</h1> <br> <span> 
						<i class="fas fa-rupee-sign"></i>${chooseService.servicePackage}</span><br>
				<br>
				<br> <span class="desc">${chooseService.serviceDescription}</span><br>
				<br>
				<br> <span> For booking click here:
						<button class="button1">
							<a href="bookservice.jsp">book</a>
						</button>
				</span> 
  </span> <br>
				<br> <span>give ratings:
						<button class="button1">
							<a href="ratings.jsp">Rating</a>
						</button>
						<br>
					<br>
				</span> 
 

 <span class="stars-outer">${rate}</span></td>
			

			</tr>
			</tr>
		</tbody>

	</table>
	<table class="rating-box">
	<tbody>
	    <tr>
				<td><span>Ratings and Review of our customer</span></td>
			</tr>
			 <c:forEach items="${review}" var="showReview">
			
           
			<tr>
               <td>
                <div class="customer">
                <div class="name">
                <jsp:useBean id="userName" class="com.weddingplanner.daoimpl.UserDaoimpl"/>
           ${userName.findUserName(showReview.userId) }

                
					&nbsp;&nbsp;&nbsp;
					
					<div class="stars-outer">
						${showReview.rating}
					</div>
					</div><br>
					 ${showReview.review}</div></td>
				
			</tr>
			</c:forEach>
			
	</tbody>
	
	</table>

</body>


</html>