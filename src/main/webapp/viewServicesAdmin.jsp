<%@page import="com.weddingplanner.module.Services"%>
<%@page import="java.util.*"%>
<%@page import="com.weddingplanner.daoimpl.ServicesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all services</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
table{
        margin-left:300px;

}
#allusers table,th,tr,td{
        border:  solid black;
        border-collapse: collapse;
        padding: 10px;
        border:none;
        }
 button{
 text decoration:none;
 text-align:center;
 float:center;
 margin-left:300px;
 
 }
 h1{
 margin-top:75px;
 text-align:center;
 }
</style>
</head>
<body>
 <% ServicesDaoimpl serviceDao = new ServicesDaoimpl();
   List<Services> serviceList = new ArrayList<Services>();
   serviceList =serviceDao.showServices();
%>  
    
<table>
	<h1><b>All Service List</b></h1>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>service name</th>
		<th>service Package</th>
		<th>Availability</th>
	</tr>
	</thead>
	<br><br>
	<tbody>
<%
int i = 0;
for (Services viewService: serviceList ) {
i++;

%>
<tr>


<td><%=i%></td>
<td><%=viewService.getServiceName()%></td>
<td><%=viewService.getServicePackage()%></td>
<td><%=viewService.getAvailability() %></td>

</tr>

<%
}
%>
</tbody>
          </table><br>
<button type="button"><a href="Services.jsp" style="text-decoration:none">Add Service</a></button>
<button type="button"><a href="updateService.jsp" style="text-decoration:none">Update Service</a></button>

	
    

</body>
</html>