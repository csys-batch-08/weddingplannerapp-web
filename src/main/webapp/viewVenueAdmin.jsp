
<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.*"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Venues</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
*{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
table{
        margin-left:200px;
        background-color:rgba(172, 209, 231, 0.5);
        border-radius: 13px;
        padding: 50px;

}
#allusers table,th,tr,td{
       
        border-collapse: collapse;
        padding: 10px;
        border:none;
        }
 button{
 text decoration:none;
 text-align:center;
 float:center;
 margin-left:200px;
 
 }
 .set{
 margin-top:10px;
 text-align:center;
 }
 
 nav{
 margin-top:0%;
	width: 100%;
	height: 50px;
	background-color: rgba(245, 240, 240, 0.4);
	font-weight:bold;
	line-height: 50px;
	padding:0px 100px;
	
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
	color:rgb(20, 16, 16);
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding:0px 32px;
}
nav ul li a:hover{
	color:#dbe2c2;
}
nav ul li .active{
	color:#c0d96f;
} 
h1{

margin-left:520px;
 } 
 .button{
      margin-left:350px;   
 
 }
  
</style>
</head>
<body>
<nav>
    	
        <ul>
         <li><a href="viewVenueAdmin.jsp">View venues</a></li>
         <li><a href="viewServicesAdmin.jsp">View services</a></li>
         <li><a href="viewUser.jsp">view users</a></li>
         <li><a href="ViewAllBookings.jsp">view venue Booking</a></li>
         <li><a href="ViewServiceBooking.jsp">view service Booking</a></li>
        </ul>
        </nav>
  
<div class="view"> 
<table >
	<h1>VenueList</h1>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>Venue name</th>
		<th>Venue Area</th>
		<th>Venue City</th>
		<th>Venue Vendor name</th>
		<th>Contact number</th>
		<th>Venue Type</th>
		<th>Availabilty</th>
		<th>Venue Package</th>
	</tr>
	</thead>
	<br><br>
	<tbody>
<c:forEach items="${venueListAdmin}" var="venueAdmin">

<tr>
<td>${venueAdmin.venueName}</td>
<td>${venueAdmin.venueArea}</td>
<td>${venueAdmin.venueCity}</td>
<td>${venueAdmin.venueVendorName}</td>
<td>${venueAdmin.contactNumber}</td>
<td>${venueAdmin.venueType}</td>
<td>${venueAdmin.availability}</td>
<td>${venueAdmin.venuePackage}</td>
</tr>
</c:forEach>

</tbody>
          </table><br>
<button type="button" class="button"><a href="venues.jsp" style="text-decoration:none">Add Venue</a></button>
<button type="button" class="button"><a href="updateVenue.jsp" style="text-decoration:none">Update Venue</a></button>

</div>
	
   

</body>
</html>