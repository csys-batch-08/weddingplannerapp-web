<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
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
        <a  href="FilterCity.jsp"><button class="button">search</button></a>
        </form>
        
	</nav>
	


<%!VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
List<Venues> showVenue;%>
<%showVenue=venueDaoImpl.showVenue();        
%>
<%int count=0;
for(Venues venue: showVenue){
   //System.out.println(venue.getVenueImages());
 %>  
  
  

<div class="venue">
      <div class="for-inline">
        <div class="image-container">
             <a href="venue1.jsp?venueName=<%=venue.getVenueName()%>">
              <img src="images/<%=venue.getVenueImages()%>" alt="hall" name="image"></a>
            <div class="title">
                <h2> <%=venue.getVenueName() %></h2>
                
           </div>
           <div class="pre">
             <pre><i class="fas fa-map-marker-alt"></i> <%=venue.getVenueCity() %>          <i class="fas fa-hotel"></i> <%=venue.getVenueType() %></pre>
             </div>   
           </div>
       </div>
      </div>


       <%} %>

<script>
</script>
</body>
</html>