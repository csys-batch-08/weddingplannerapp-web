<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
</head>
<body>
<form action="updateProfile" method="post">
     <label>Name</label>
     <input type="text" id="name"  name="username" placeholder="" pattern="[A-Za-z]{3,}" required>
     <label>Mobile number</label>
     <input type="text" id="number" name="phonenumber" placeholder="" pattern="[6-9][0-9]{9}" required>
     <label>city</label>
     <input type="text" id="city" name="city" placeholder="" pattern="[A-Za-z0]{4,25}" required>
     <input type="submit" value="submit">
 </form>    
</body>
</html>