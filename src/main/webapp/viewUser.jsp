<%@page import="com.weddingplanner.module.User"%>
<%@page import="java.sql.Array"%>
<%@page import="com.weddingplanner.daoimpl.UserDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body
    {
        background-image: url("images/adminImage.jpg");
        background-size: cover;
    }
#allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
        }
        
   .table{
   width:380px;
   margin-left:140px;}
</style>
</head>
<body>
<% UserDaoimpl userdao = new UserDaoimpl();
   List<User> userList = new ArrayList<User>();
   userList = userdao.viewUser();
%>
<table class="table table-hover table-striped">
	<h1><b>All User List</b></h1>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>User name</th>
		<th>Phone number</th>
		<th>Address</th>
		<th>Email address</th>
		<th>Wallet</th>
	</tr>
	</thead>
	<br><br>
<tbody>
<%
int i = 0;
for (User viewUser: userList ) {
i++;

%>
<tr>


<td><%=i%></td>
<td><%=viewUser.getUserName()%></td>
<td><%=viewUser.getMobileNumber()%></td>
<td> <%=viewUser.getCity()%></td>
<td> <%=viewUser.getEmailId()%></td>
<td> <%=viewUser.getWallet()%></td>
</tr>

<%
}
%>
</tbody>
          </table>


</body>
</html>