<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>venues</title>
<link rel="stylesheet" href="style1.css">
<script src="https://kit.fontawesome.com/ae23c8822d.js" crossorigin="anonymous"></script>
<style>
 body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
    .search{
    	padding: 7px;
    }
   
    .button{
  padding: 6px 9px;
		border-radius: 4px;
  }  
  button a{
  text-decoration:none;
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
        <form action="filterCity" method="post">
        <input type="text" name="search" class="search" >  
       <button class="button">search</button>
        </form>
        
	</nav>
	




 <c:forEach items="${showVenue}" var="venue">

<div class="venue">
      <div class="for-inline">
        <div class="image-container">
             <a href="ChooseVenueServlet?venueName=${venue.venueName}">
              <img src="images/${venue.venueImages }" alt="hall" name="image"></a>
            <div class="title">
              <h2>  ${venue.venueName}</h2>
                
           </div>
           <div class="pre">
             <pre><i class="fas fa-map-marker-alt"></i> ${venue.venueCity}         <i class="fas fa-hotel"></i> ${venue.venueType} </pre>
             </div>   
           </div>
       </div>
      </div>

</c:forEach> 
      

<script>
</script>
</body>
</html>