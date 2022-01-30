
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
           <li><a href="userProfile.jsp" >My profile</a></li>
      	   <li><a href="">about us</a></li>
		   <li><a href="">contact us</a></li>
			<li><a href="viewVenues.jsp">Venues</a></li>
			<li><a href="viewService.jsp">services</a></li>
            <li><a href="MyBooking.jsp">my Bookings</a></li>
        </ul>
    
</nav>
          


<h1>Service</h1>


   <table class="table table-hover table-striped">
	
	<thead>
	<tr>
  		
		<th>service name</th>
		<th>service package</th>
		<th>Event Date</th>
		<th>Booking date</th>
		<th>status</th>
		<th>cancel order</th>
		
		
	</tr>
	</thead>
	<br><br>
<tbody>



<tr>
<c:forEach items="${booking}" var="serviceBooking">


<td>${serviceBooking.serviceName}</td>

<td>${serviceBooking.servicePackage}</td>

 <td>${serviceBooking.eventDate}</td>
 <td>${bookingDate}</td>
 <td><jsp:useBean id="statusService" class="com.weddingplanner.daoimpl.BookingServicesDaoimpl"/>
${statusService.findStatus(serviceBooking.serviceName,serviceBooking.eventDate) }
</td>
<jsp:useBean id="serviceBookingIdFind" class="com.weddingplanner.daoimpl.BookingServicesDaoimpl"/>

<td><button class="button"><a href="cancelService?serviceBookingId=${serviceBookingIdFind.findBookingServiceId(serviceBooking.userId,serviceBooking.eventDate,serviceBooking.serviceName)}">cancel</a></button></td>
    

          
 </tr>
   
</c:forEach>
</tbody>
          </table>
         
   
 
          


 <table class="table table-hover table-striped" id="allusers">
	<h1><b>Venue</b></h1>
	<thead>
	<tr>
  		
		<th>venue name</th>
		<th>venue package</th>
		<th>Event Date</th>
		<th>Booking date</th>
		
		<th>status</th>
		<th>cancel your order</th>
		
		
	</tr>
	</thead>
	
<tbody>
<c:forEach items="${bookingVenue}" var="myBookingVenue">

<tr>
<td>${myBookingVenue.venueName}</td>
<td>${myBookingVenue.venuePackage}</td>
<td>${myBookingVenue.eventDate}</td>
<td>${venueBookingDate }</td>
<td><jsp:useBean id="statusVenue" class="com.weddingplanner.daoimpl.BookingVenuesDaoimpl"/>
${statusVenue.findStatus(myBookingVenue.venueName,myBookingVenue.eventDate) }
</td>


<td><button class="button"><a href="cancelVenue?venueBookingId=${venueBookingId}">cancel</a></button></td>




</tr>
</c:forEach>


</tbody>
          </table>
           
        

</body>
</html>