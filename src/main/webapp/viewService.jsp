
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>service</title>
<link rel="stylesheet" href="style1.css">


<style>
 body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
    form input{
    margin-left:-52px;
    padding:7px;
    border:none;
    border:1px solid gray;
    border-radius: 6px;
    outline:none;
}
	img
	{
		height:250px;
		width:280px;
		overflow:hidden;
		margin-top:40px;
		display:block;
		border-radius:20px;
	}
	span{
		position : relative;
		top:360px;
		left: 50px;
	
	}
	table td{
		padding: 30px 10px;
		font-weight:bold;
	
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
			<li><a href="viewVenuesServlet">Venues</a></li>
			<li><a href="viewService.jsp">services</a></li>
            <li><a href="MyBooking.jsp">my Bookings</a></li>
        </ul>
          <form action="filterPrice" method="post" >
      <input type="text" name="byPrice" class="search">  
      <button class="button">search</button>
      </form>
        
	</nav>
<table>
<tbody>
	   <tr>
         
           <c:set var="count" value="1"/>
           <c:forEach items="${viewServices}" var="services">
				
                    <td>
                        <table>
                            <tbody>
                                <tr>
                                    <td><a href="ShowServiceServlet?serviceType=${services.serviceType}"><img src="images/${services.serviceTypeImage}" alt="hall"></a></td>  
                                   <span>${services.serviceType}</span> 
                                                                      
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                      <c:choose>
                      <c:when test="${count==4}">
                      <c:set var="count" value="1"/>
                    	   </tr>
                    	   <tr>              
                     </c:when>
                     <c:otherwise>
                     <c:set var="count" value="${count+1}"/>
                     </c:otherwise> 
                     </c:choose> 
                     </c:forEach>
                       
                </tr>
</tbody>
</table>

</body>
</html>