<%@page import="com.weddingplanner.module.Services"%>
<%@page import="java.util.*"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all services</title>
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
        margin-left:400px;
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
 
<table>
	<h1><b>All Service List</b></h1>
	<thead>
	<tr>
  		
		<th>service name</th>
		<th>service Package</th>
		<th>Availability</th>
	</tr>
	</thead>
	<br><br>
	<tbody>
	<c:forEach items="${serviceListAdmin}" var="serviceAdmin">

<tr>



<td>${serviceAdmin.serviceName}</td>
<td>${serviceAdmin.servicePackage}</td>
<td>${serviceAdmin.availability}</td>

</tr>
</c:forEach>

</tbody>
          </table><br>
<button type="button" class="button"><a href="Services.jsp" style="text-decoration:none">Add Service</a></button>
<button type="button" class="button"><a href="updateService.jsp" style="text-decoration:none">Update Service</a></button>

	
    

</body>
</html>