<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Ratings</title>
<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}

.login-box {
	width: 390px;
	height: 380px;
	margin: auto;
	margin-top: 30px;
	background-color: rgba(195, 160, 202, 0.589);
	border-radius: 15px;
}

h1 {
	text-align: center;
	padding-top: -15px;
}

form {
	padding: 30px 20px;
	width: 300px;
	margin-left: 30px;
	text-align: center;
}

form label {
	display: flex;
	margin-top: 30px;
	font-size: 18px;
	margin-left: 30px;
}

form input {
	width: 300px;
	padding: 7px;
	border: none;
	border: 1px solid gray;
	border-radius: 6px;
	outline: none;
}

.button {
	padding: 7px 50px;
	border-radius: 4px;
	background-color: rgba(131, 72, 143, 0.5);
	border: 1px solid violet;
	cursor: pointer;
	display: inline-flex;
}

button a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<form action="ratings" method="post" class="login-box">
		<h1>Ratings</h1>
		<label for="name">service name</label> 
		<input type="text" id="name" name="venuename" value="${serviceName}" required> 
		<label for="rating">Rating</label>
		<div class="form-group">
			<input type="text" name="rating" pattern="[0-5]+" placeholder="give out of 5" id="rating" required><br>
		</div>
		<label for="review">Review</label> 
		<input type="text" name="review" placeholder="write review" id="review" required><br> <br>
		<a href="viewService.jsp"><button class="button">Back</button></a>
		<button type="submit" class="button">Ok</button>
	</form>
</body>
</html>