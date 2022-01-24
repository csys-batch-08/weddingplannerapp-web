<%@page import="com.weddingplanner.daoimpl.BookingVenuesDaoimpl"%>
<%@page import="com.weddingplanner.module.BookingVenues"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bookings</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <style>
#allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        }
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
</style>
</head>
<body>
<% BookingVenuesDaoimpl bookingdao = new BookingVenuesDaoimpl();
   List<BookingVenues> venueList = new ArrayList<BookingVenues>();
   venueList = bookingdao.allBookings();
%>
<table class="table table-hover table-striped">
	<h1><b>All Venue Booking List</b></h1>
	<thead>
	<tr>
  		<th >S.no</th>
  		<th>User Id</th>
		<th>Venue name</th>
		<th>No Of Guest</th>
		<th>Venue Package</th>
		<th>Event Date</th>
		<th>Booking Date</th>
		<th>Status</th>
	</tr>
	</thead>
	<br><br>
<tbody>
<%
int i = 0;
for (BookingVenues bookvenues: venueList ) {
i++;

%>
<tr>


<td><%=i%></td>
<td><%=bookvenues.getUser_id() %>
<td><%=bookvenues.getVenueName()%></td>
<td><%=bookvenues.getNoOfGuest()%></td>
<td> <%=bookvenues.getVenuePackage()%></td>
<td> <%=bookvenues.getEventDate()%></td>
<td><%=bookvenues.getBookingDate() %></td>
<td><%=bookvenues.getStatus() %></td>

</tr>

<%
}
%>
</tbody>
          </table>

    


</body>
</html>