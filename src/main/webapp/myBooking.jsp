<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>My Booking</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


<style>

table{
		margin-right:400px;
		width: 30%;
	}
	 body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
    *{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
nav{
	width: 100%;
	height: 50px;
	background-color:rgba(102, 83, 83, 0.4);
	line-height: 50px;
	padding:0px 100px;
}
nav ul{
	
}
nav ul li{
	display: inline-block;
	list-style: none;
}
nav ul li a{
	color:#fff;
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding:0px 32px;
}
nav ul li a:hover{
	color:#c0d96f;
}
.table{
width:880px;
margin-left:250px;}
h1
{
	margin-left: 650px;
}
.button{
 padding:7px 50px;
 border-radius:4px;
 background-color:rgba(140, 160, 184, 0.5);
 border:1px solid violet;
 cursor:pointer;
 display:inline-flex;
 
}
button a{
    text-decoration:none;
    color:black;
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
          


<h1>Service</h1>


   <table class="table table-hover table-striped">
   <caption></caption>
	
	<thead>
	<tr>
  		
		<th id="heading1">service name</th>
		<th id="heading2">service package</th>
		<th id="heading3">Event Date</th>
		<th id="heading4">Booking date</th>
		<th id="heading5">status</th>
		<th id="heading6">cancel order</th>
		
		
	</tr>
	</thead>
	
<tbody>


<c:forEach items="${booking}" var="serviceBooking">

<tr>


<td>${serviceBooking.serviceName}</td>

<td>${serviceBooking.servicePackage}</td>


 <td><fmt:parseDate value="${serviceBooking.eventDate}" pattern="yyyy-MM-dd" var="eventDate" type="date"/>
  <fmt:formatDate pattern="dd-MM-yyyy" value="${eventDate}"/></td>
 
 <td><fmt:parseDate value="${bookingDate}" pattern="yyyy-MM-dd" var="serviceBookingDate" type="date"/>
  <fmt:formatDate pattern="dd-MM-yyyy" value="${serviceBookingDate}"/></td>
 <td><jsp:useBean id="statusService" class="com.weddingplanner.daoimpl.BookingServicesDaoimpl"/>
${statusService.findStatus(serviceBooking.serviceName,serviceBooking.eventDate) }
</td>
<jsp:useBean id="serviceBookingIdFind" class="com.weddingplanner.daoimpl.BookingServicesDaoimpl"/>

<td><a href="cancelService?serviceBookingId=${serviceBookingIdFind.findBookingServiceId(serviceBooking.userId,serviceBooking.eventDate,serviceBooking.serviceName)}"><button class="button">cancel</button></a></td>
    

      
 </tr>
  </c:forEach>     

</tbody>
          </table>
         
   
 
          


 <table class="table table-hover table-striped" id="allusers">
 <caption></caption>
	<h1><b>Venue</b></h1>
	<thead>
	<tr>
  		
		<th id="heading1">venue name</th>
		<th id="heading1">venue package</th>
		<th id="heading1">Event Date</th>
		<th id="heading1">Booking date</th>
		
		<th id="heading1">status</th>
		<th id="heading1">cancel your order</th>
		
		
	</tr>
	</thead>
	
<tbody>
<c:forEach items="${bookingVenue}" var="myBookingVenue">

<tr>
<td>${myBookingVenue.venueName}</td>
<td>${myBookingVenue.venuePackage}</td>

<td><fmt:parseDate value="${myBookingVenue.eventDate}" pattern="yyyy-MM-dd" var="venueEventDate" type="date"/>
  <fmt:formatDate pattern="dd-MM-yyyy" value="${venueEventDate}"/></td>

 <td><fmt:parseDate value="${venueBookingDate}" pattern="yyyy-MM-dd" var="venueBookingDateShow" type="date"/>
  <fmt:formatDate pattern="dd-MM-yyyy" value="${venueBookingDateShow}"/></td>
<td><jsp:useBean id="statusVenue" class="com.weddingplanner.daoimpl.BookingVenuesDaoimpl"/>
${statusVenue.findStatus(myBookingVenue.venueName,myBookingVenue.eventDate) }
</td>


<td><a href="cancelVenue?venueBookingId=${venueBookingId}"><button  class="button">cancel</button></a></td>




</tr>
</c:forEach>


</tbody>
          </table>
 

     

</body>
</html>