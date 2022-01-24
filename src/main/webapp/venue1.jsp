<%@page import="com.weddingplanner.module.Venues"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.VenuesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!
VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
List<Venues> showVenue;%>
<%/*  String venueName=(String)session.getAttribute("venuename");
showVenue=venueDaoImpl.allVenue(venueName); */
 String venuename=request.getParameter("venueName");

Venues venue= venueDaoImpl.allVenue(venuename);
 
 int venueId=venueDaoImpl.findVenueId(venue.getVenueName());
 
 double venuepackage=venueDaoImpl.findPackage(venueId);
 int advanceAmount=(int)(venuepackage*1/2);
 
 session.setAttribute("venuename",venuename );
 session.setAttribute("venueId", venueId);
 session.setAttribute("venuepackage", venuepackage);
 session.setAttribute("advanceAmount", advanceAmount);
 
%>


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
   <td><img src="images/<%=venue.getVenueImages()%>" alt="hall"></td>
    
            <td> <h1> <%=venue.getVenueName() %></h1>
              <pre><i class="fas fa-map-marker-alt"></i> <%=venue.getVenueArea()%>,<%=venue.getVenueCity() %>                <i class="fas fa-hotel"></i> <%=venue.getVenueType() %></pre>
             <pre><i class="fas fa-phone"></i> <%=venue.getContactNumber() %>                           <i class="fas fa-rupee-sign"></i><%=venue.getVenuePackage() %> </pre>  <br>
            venue vendor name:<%=venue.getVenueVendorName() %><br><br>
             <%
		session.setAttribute("venueName",venue.getVenueName() );
		%>
		
        For booking click here: <button class="button"><a href="bookvenue.jsp">book</a></button></td>
        </tr>
  </tbody>          
  </table>                            
</body>
</html>