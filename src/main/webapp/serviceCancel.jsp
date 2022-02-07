<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>cancelService</title>
<style>
body {
	background-image: url("assets/images/b3.jpg");
	background-size: cover;
}

.set {
	text-align: center;
	font-size: 30px;
	margin-top: 250px;
	font-weight: bold;
}

.button {
	padding: 4px 7px;
	border-radius: 4px;
}

button a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="set">
		Your Wallet Amount:${cancelWallet }<br> 20% of amount is deducted
		After refund Wallet balance:${RefundBalance }<br>
		<h2>${serviceCancelled}</h2>
		<a href=viewService.jsp><button>Back</button></a>
	</div>
</body>
</html>