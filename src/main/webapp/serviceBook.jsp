<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Service booked</title>
</head>
<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}

nav a {
	float: center;
	text-decoration: none;
	color: black;
	background-colour: white;
	padding-right: 17px;
	font-size: 17px;
	margin-top: 10px;
}

.set {
	text-align: center;
	font-size: 30px;
	margin-top: 250px;
}

.button {
	padding: 4px 7px;
	border-radius: 4px;
}

button a {
	text-decoration: none;
}
</style>
<body>
	<div class="set">
		Your Wallet Amount:${userWalletBalance }<br> Amount
		deducted:${serviceAdvance}<br> After deduction Wallet
		balance:${servicePayBalance}
		<h2>${servicebooked }</h2>

		<a href=home.jsp><button class="button">Back</button></a>
	</div>
</body>
</html>