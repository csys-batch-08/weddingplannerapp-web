<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>venues</title>
<script src="https://kit.fontawesome.com/ae23c8822d.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="style1.css">

<style>
img{
   width:500px;
   height:400px;
   margin-top:150px;
   margin-right:50px;
   margin-left:100px;
   border-radius:20px;
}
h1{
   font-size:50px;
   margin-top:-10px;
}
pre{
  margin-top:20px;   
}
a{
  text-decoration: none;
  color:white;

}
 body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
   
.button {
  background-color:gray;
  text-color:white;
  
  border: none;
  color: white;
  padding: 7px 28px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  border-radius:10px;
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
	
    <table>
    <tbody>
    <tr>
     <c:out  value="${venueShow}" />
    
   <td><img src="images/${venueShow.venueImages}" alt="hall"></td>
    
            <td> <h1> ${venueShow.venueName}</h1>
              <pre><i class="fas fa-map-marker-alt"></i>${venueShow.venueArea},${venueShow.venueCity}                <i class="fas fa-hotel"></i> ${venueShow.venueType}</pre>
             <pre><i class="fas fa-phone"></i> ${venueShow.contactNumber}                           <i class="fas fa-rupee-sign"></i>${venueShow.venuePackage} </pre>  <br>
            venue vendor name:${venueShow.venueVendorName}<br><br>
             
		
        For booking click here: <button class="button"><a href="bookvenue.jsp">book</a></button></td>
     
        </tr>
       
  </tbody>          
  </table>  
                        
</body>
</html>