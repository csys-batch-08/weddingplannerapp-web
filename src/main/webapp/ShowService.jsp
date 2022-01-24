<%@page import="com.weddingplanner.module.Services"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show service</title>
<link rel="stylesheet" href="style1.css">

</head>
<style>
 body
    {
        background-image: url("images/b3.jpg");
         background-size:1400px 653px;
    }
	img
	{
		height:250px;
		width:280px;
		overflow:hidden;
		margin-top:60px;
		margin-left:50px;
		border-radius:20px;
	}
	span{
		position : relative;
		top:30px;
		left: 60px;
	}
	table td{
		padding: 20px 25px;
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
<body>

<nav >
      <ul>
           <li><a href="userProfile.jsp" >My profile</a></li>
		   <li><a href="">about us</a></li>
		   <li><a href="">contact us</a></li>
			<li><a href="viewVenues.jsp">Venues</a></li>
			<li><a href="viewService.jsp">services</a></li>
            <li><a href="MyBooking.jsp">my Bookings</a></li>
        </ul>
       
	</nav>
	
    <%!ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
    List<Services> serviceList;%>
	<%
	String serviceType = request.getParameter("serviceType");
	session.setAttribute("serviceType", serviceType);%>
	
	<% serviceList=serviceDaoImpl.showServiceList(serviceType);%>
	 
<table>
<tbody>
	<tr>
	<% int count=0;
	for(Services service: serviceList){
	   			
	   	%>
	   	<td>
	   	<table id="service">
	   	<tbody>
	   		<tr>
	   	 <td><a href="service1.jsp?serviceName=<%=service.getServiceName()%>"><img src="images/<%=service.getServiceImages()%>" alt="hall"></a>
	   	    
	   	  
	   	   <span><%=service.getServiceName() %><br></span>
	   	   <span>package:<%=service.getServicePackage() %></span></td>
	   	   
	   	   
	   	  
	   	  

	   		
	   		</tr>
	   	</tbody>
	   	</table>
	   	</td>
	   	<%count++;
	   	   if(count==3){%>
	   	</tr>
	   	<tr>
	   	<%count=0;
	   	}}%>
	   </tr>
</tbody>
</table>
                


</body>
</html>