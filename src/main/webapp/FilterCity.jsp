
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>venueCity</title>
<link rel="stylesheet" href="style1.css">
<script src="https://kit.fontawesome.com/ae23c8822d.js" crossorigin="anonymous"></script>
<style>
    body
    {
        background-image: url("images/back1.jpg");
        background-size: cover;
    }
    nav a{
        float:center;
        text-decoration: none;
        color:black;
        background-colour:white;
        padding-right: 17px;
        font-size: 17px;
        margin-top: 10px;
    }
    </style>
</head>
<body>
 <nav>
       <input type="text" name="search" class="search">
      <a href="filter.jsp"><button>search</button></a>
     <a href="viewVenues.jsp">Venues</a>
        <a href="viewService.jsp">Services</a>
        <a href="">About us</a>
        <a href="">Contact us</a>
        <a href="login.jsp">Logout</a>
       
        <a href="myBooking.jsp">My booking</a>
        
    </nav>
<c:set var="i" value="0"/>
<c:forEach items="${searchCity}" var="filterVenueCity">
<c:set var="i"  value="${i+1}"/>

          
<div class="venue">
      <div class="for-inline">
        <div class="image-container">
             <a href="ChooseVenueServlet?venueName=${filterVenueCity.venueName}"><img src="images/${filterVenueCity.venueImages}" alt="hall"></a>
            <div class="title">
                <h2> venue name:${filterVenueCity.venueName }</h2>
                
           </div>
              <pre><i class="fas fa-map-marker-alt"></i> ${filterVenueCity.venueCity }   <i class="fas fa-hotel"></i> ${filterVenueCity.venueType}</pre>
        
           </div>
       </div>
      </div>
     
</c:forEach>
        
             

</body>
</html>