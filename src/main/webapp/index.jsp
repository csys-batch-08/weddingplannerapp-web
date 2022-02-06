<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="style1.css">
<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

h3 {
	text-align: center;
}

body {
	background-image: url("images/login.jpeg");
	background-size: 1370px 653px;
}

.login-box {
	width: 420px;
	height: 280px;
	margin: auto;
	margin-top: 150px;
	border-radius: 6px;
	background-color: rgba(95, 166, 211, 0.5);
}

p a {
	text-decoration: none;
}

form {
	width: 300px;
	margin-left: 80px;
}

form label {
	display: flex;
	margin-top: 20px;
	padding-right: 100px;
	font-size: 18px;
}

form input {
	padding-right: 90px;
	margin-left: 1px;
	padding-top: 10px;
	border: none;
	border: 1px solid gray;
	border-radius: 6px;
	outline: none;
}

.button {
	width: 250px;
	height: 35px;
	margin-top: 20px;
	border: none;
	background-color: rgba(53, 138, 190, 0.589);
	color: black;
	font-size: 18px;
	border-radius: 5px;
}

button:hover {
	opacity: 0.5;
}

h1 {
	text-align: center;
}
</style>
</head>
<body class="bd">
	<div class="login-box">
		<div class="login">
			<h1>Login</h1>
			<form action="login" method="post">
				<label for="email">Email</label> 
				<input type="email" name="email" id="email" required> 
				<label for="showPassword">Password</label>
				<input type="password" name="password" id="showPassword" required><br>
				<input type="checkbox" onclick="myFunction()" id="showPassword">Show Password<br>
				<button class="button">Submit</button>
				<br>
           </form>
		</div>
	</div>
	<p class="para">
		Not have an account?<a href="register.jsp">Sign up here</a>
	</p>
	<c:if test="${sessionScope.login !=null}">
		<h3>${sessionScope.login}</h3>
	</c:if>
	<c:remove var="login" scope="session" />
	<script>
		function myFunction() {
			var x = document.getElementById("showPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>