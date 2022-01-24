<%@page import="com.weddingplanner.module.BookingVenues"%>
<%@page import="com.weddingplanner.daoimpl.BookingVenuesDaoimpl"%>
<%@page import="com.weddingplanner.module.BookingServices"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.BookingServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
        background-image: url("images/back1.jpg");
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
	position:absolute;
	z-index: 1;
}
nav .logo{
	font-size: 20px;
	font-weight: bold;
	letter-spacing: 1.5px; 
}
nav .logo p{
	float: left;
	color:#fff;
	text-transform: uppercase;
}
nav ul{
	float: right;
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
nav ul li .active{
	color:#c0d96f;
}
.table{
width:380px;
margin-left:140px;}
h1{
  
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
          
<%!
BookingServicesDaoimpl service = new BookingServicesDaoimpl();
List<BookingServices> myService;%>
<% int userId=(int)session.getAttribute("id");
myService=service.MyBooking(userId);
session.setAttribute("booking", myService);
%> 
<h1><b>Service</b></h1>
<form action="cancelService" method="post">
   <table class="table table-hover table-striped">
	
	<thead>
	<tr>
  		<th >S.no</th>
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
<%
int i = 0;
for (BookingServices bookService: myService ) {
i++;

%>
<tr>


<td><%=i%></td>
<td><%=bookService.getServiceName()%></td>
<%session.setAttribute("serviceBookingName", bookService.getServiceName()); %>
<td><%=bookService.getServicePackage()%></td>
<%session.setAttribute("servicePackageName", bookService.getServicePackage()); %>
 <td> <%=bookService.getEventDate()%></td>
 <%session.setAttribute("serviceEventDate", bookService.getEventDate()); %>
 <td> <%=service.findBookingDate(userId)%></td>
 <%int serviceBooking=service.findBookingServiceId(userId, bookService.getEventDate(),bookService.getServiceName()); 
session.setAttribute("serviceBooking", serviceBooking);%>
 <%String status=service.findStatus(bookService.getServiceName(),bookService.getEventDate()); %>
<td><%=status%></td>

<td><a href="cancelService?serviceBookingId=<%=serviceBooking%>">cancel</a></td>
    

          
          



</tr>
</form>    
<%
}
%>
</tbody>
          </table>
         
   
 
          
<%!
BookingVenuesDaoimpl venues = new BookingVenuesDaoimpl();
List<BookingVenues> myVenue;%>
<% 
myVenue=venues.MyBooking(userId);
session.setAttribute("booking", myService);
%>  

 <table class="table table-hover table-striped" id="allusers">
	<h1><b>Venue</b></h1>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>venue name</th>
		<th>venue package</th>
		<th>Event Date</th>
		<th>Booking date</th>
		<th>status</th>
		<th>cancel your order</th>
		
		
	</tr>
	</thead>
	
<tbody>
<%
 i = 0;
for (BookingVenues bookVenue: myVenue ) {
i++;

%>
<tr>


<td><%=i%></td>
<td><%=bookVenue.getVenueName()%></td>
<%session.setAttribute("venueBookingName", bookVenue.getVenueName()); %>
<td><%=bookVenue.getVenuePackage()%></td>
<%session.setAttribute("venueBookingPackage", bookVenue.getVenuePackage()); %>
<td> <%=bookVenue.getEventDate()%></td>
<%session.setAttribute("venueBookingEventDate", bookVenue.getEventDate()); %>
<td> <%=venues.findVenueBookingDate(userId)%></td>
<%int venueBooking=venues.findBookingVenueId(userId,bookVenue.getEventDate(),bookVenue.getVenueName()); 
session.setAttribute("venueBooking", venueBooking);%>
<%String status=venues.findStatus(bookVenue.getVenueName(),bookVenue.getEventDate()); %>
<td><%=status%></td>

<td><a href="cancelVenue?venueBookingId=<%=venueBooking%>">cancel</a></td>




</tr>

<%
}
%>
</tbody>
          </table>
           
        

</body>
</html>