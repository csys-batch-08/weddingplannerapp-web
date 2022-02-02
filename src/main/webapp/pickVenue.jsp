
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    


<!DOCTYPE html>
<html lang="en">
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
           <li><a href="ViewVenuesServlet">Venues</a></li>
        <li><a href="ViewServiceServlet">Services</a></li>
        <li><a href="aboutUs.jsp">About us</a></li>
        <li><a href="contactUs.jsp">Contact us</a></li>
        <li><a href="UserProfileServlet">My Profile</a></li>
        <li><a href="MyBookingServlet">My booking</a></li>
        </ul>
        
	</nav>
	
    <table>
    <caption></caption>
    <tbody>
    <tr>
    <c:set var="venueShow" scope="session" value="${venueShow}" />
     
    
   <th id="tableHead"><img src="images/${venueShow.venueImages}" alt="hall"></td>
    
            <td> <h1> ${venueShow.venueName}</h1>
              <pre><em class="fas fa-map-marker-alt"></em>${venueShow.venueArea},${venueShow.venueCity}                <em class="fas fa-hotel"></em> ${venueShow.venueType}</pre>
             <pre><em class="fas fa-phone"></em> ${venueShow.contactNumber}                           <em class="fas fa-rupee-sign"></em>${venueShow.venuePackage} </pre>  <br>
            venue vendor name:${venueShow.venueVendorName}<br><br>
             
		
        For booking click here: <button class="button"><a href="bookVenue.jsp">book</a></button></td>
     
        </tr>
       
  </tbody>          
  </table>  
                        
</body>
</html>