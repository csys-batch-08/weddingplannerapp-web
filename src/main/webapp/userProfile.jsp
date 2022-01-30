
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
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
button a{
    text-decoration:none;
    color:black;
}
body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }

</style>
</head>
<body>
<c:forEach items="${userProfile }" var="viewUserProfile">


  <div class="profile">
	<h1><b>Profile</b></h1>
	
  		
		<h4>User name : ${viewUserProfile.userName }</h4>
		<h4>Phone number :${viewUserProfile.mobileNumber}</h4>
		<h4>City :${viewUserProfile.city}</h4>
		<h4>Email address :${viewUserProfile.emailId}</h4>
		<h4>Wallet :${viewUserProfile.wallet}</h4>
		<button class="button"><a href="index.jsp">Back</a></button>
		<button class="button"><a href="updateUserProfile.jsp">Edit</a></button>
	
</div>
</c:forEach>



</body>
</html>