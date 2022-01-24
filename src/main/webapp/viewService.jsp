<%@page import="com.weddingplanner.module.Services"%>
<%@page import="java.util.List"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<%!
ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
List<Services> showservices ;%>
<%showservices=serviceDaoImpl.showServiceType(); 
%>

<nav>
		<ul>
           <li><a href="userProfile.jsp" >My profile</a></li>
		   <li><a href="">about us</a></li>
		   <li><a href="">contact us</a></li>
			<li><a href="viewVenues.jsp">Venues</a></li>
			<li><a href="viewService.jsp">services</a></li>
            <li><a href="MyBooking.jsp">my Bookings</a></li>
        </ul>
          <form action="filterPrice" method="post" >
      <input type="text" name="byPrice" class="search">  
      <a  href="FilterPrice.jsp"><button class="button">search</button></a>
      </form>
        
	</nav>
<table>
<tbody>
	   <tr>
         
         
				<% int count=0;
					for(Services service: showservices){
	   			
                	%>
                    <td>
                        <table>
                            <tbody>
                                <tr>
                                    <td><a href="ShowService.jsp?serviceType=<%=service.getServiceType()%>"><img src="images/<%=service.getServiceTypeImage()%>" alt="hall"></a></td>  
                                   <span>  <%=service.getServiceType() %></span> 
                                                                      
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                       <% count ++;
                       if(count==4){ %> 
                    	   </tr>
                    	   <tr>              
                     <%count=0; }}%>  
                       
                </tr>
</tbody>
</table>

</body>
</html>