<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Venues</title>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<style>
body {
	background-image: url("images/adminImage.jpg");
	background-size: cover;
}

.login-box {
	width: 390px;
	height: 850px;
	margin: auto;
	margin-top: 3px;
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
	background-color: violet;
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
   <form action="insert" method="post" class="login-box">
		<h1>venue details</h1>
		<label for="venueName">venue name:</label> 
		<input type="text" name="venueName" id="venueName" required><br> 
		<label for="venueArea">venue area:</label> 
		<input type="text" name="venueArea" id="venueArea" required><br>
		<label for="venueCity">venue city:</label> 
		<input type="text" name="city" id="venueCity" required><br> 
		<label for="venueType">venue type:</label>
		<input type="text" name="venueType" id="venueType" required><br>
		<label for="vendorName">venue vendor name:</label> 
		<input type="text" name="vendorName" id="vendorName" required><br> 
		<label for="contactNumber">contact number:</label> 
		<input type="text" name="contactNumber" pattern="[6-9][0-9]{9}" id="contactNumber" required><br> 
		<label for="venuePackage">venue Package:</label> 
		<input type="text" name="venuePackage" pattern="[0-9]+" id="venuePackage" required><br> 
		<label for="availability">availability:</label> 
		<input type="text" name="availability" id="availability" required><br> 
		<label for="image">venue Image:</label> 
		<input type="file" name="image" id="image" required><br><br> 
		<label for="description">description:</label> 
		<input type="text" name="description" id="description" required><br>
		<a href="viewVenueAdmin.jsp"><button class="button">Back</button></a>
		<button type="submit" class="button">Add</button>
	</form>
	<script src="message.js"></script>
	<c:if test="${param.infomsg!=null}">
		<script type="text/javascript">
			popupMessages('Successfully Added')
		</script>
	</c:if>
</body>
</html>