<%@page import="com.weddingplanner.module.Services"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>searchByprice</title>
<style>
body
    {
        background-image: url("images/back1.jpg");
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
	}	
	
  .button{
  padding: 6px 9px;
		border-radius: 4px;
  }  
  button a{
  text-decoration:none;
  }
 *{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
nav{
	width: 100%;
	height: 50px;
	background-color:rgba(102, 83, 83, 0.4);
	
	line-height: 50px;
	padding:0px 100px;
	position:fixed;
	z-index: 1;
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
	color:#fff;
	text-decoration: none;
	font-size: 15px;
	text-transform: uppercase;
	padding:0px 32px;
}
nav ul li a:hover{
	color:#c0d96f;
}
nav ul li .active{
	color:#c0d96f;
}
</style>
</head>
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
	Double servicePackage = (Double)session.getAttribute("serviceBookPackage");
	System.out.println(servicePackage);
	session.setAttribute("serviceType", servicePackage);%>
	
	<% serviceList=serviceDaoImpl.filterByPrice(servicePackage);%>
	 
<table>
<tbody>
	<tr>
	<% int count=0;
	for(Services service: serviceList){
	   				System.out.println(service.getServiceTypeImage());
	   	%>
	   	<td>
	   	<table id="service">
	   	<tbody>
	   		<tr>
	   	 <td><a href="service1.jsp?serviceName=<%=service.getServiceName()%>"><img src="images/<%=service.getServiceImages()%>" alt="hall"></a></td>
	   	 <td>    
	   	  <div class="service1">
	   	   service name:<%=service.getServiceName() %>
	   	   service package:<%=service.getServicePackage() %>
	   	   
	   	   
	   	  </div>
	   	  </td>

	   		
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