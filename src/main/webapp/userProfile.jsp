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
<title>profile</title>
<style>
.profile{
border:2px solid violet;
margin:100px 500px;
padding:10px 30px;
background-color:rgba(135, 70, 148, 0.589);
}
h1{
 text-align:center;
}
.button{
 padding:7px 50px;
 border-radius:4px;
 background-color:violet;
 border:1px solid violet;
 cursor:pointer;
 display:inline-flex;
 
}
body
    {
        background-image: url("images/back1.jpg");
        background-size: cover;
    }

</style>
</head>
<body>
<% int userId=(int)session.getAttribute("id");
	UserDaoimpl userdao = new UserDaoimpl();
   List<User> userList = new ArrayList<User>();
   userList = userdao.currentuserprofile(userId);
%>

<%
int i = 0;
for (User currentuserprofile: userList ) {
i++;

%>
  <div class="profile">
	<h1><b>Profile</b></h1>
	
  		
		<h4>User name : <%=currentuserprofile.getUserName()%></h4>
		<h4>Phone number :<%=currentuserprofile.getMobileNumber()%></h4>
		<h4>City :<%=currentuserprofile.getCity()%></h4>
		<h4>Email address :<%=currentuserprofile.getEmailId()%></h4>
		<h4>Wallet :<%=currentuserprofile.getWallet()%></h4>
		<button class="button"><a href="index.jsp">Back</a></button>
		<button class="button"><a href="UpdateUserProfile.jsp">Edit</a></button>
	
</div>
<%
}
%>


</body>
</html>