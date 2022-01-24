<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<link rel="stylesheet" href="style1.css">
</head>
<style>
body{
    background-image: url("images/login.jpeg");
    background-size:1370px 653px;  
}
.signup-box{
    width:420px;
    height:500px;
    margin:auto;
    margin-top:60px;
    background-color: rgba(95, 166, 211, 0.5);
    border-radius:15px;
}
form{
    width:300px;
    margin-left:70px;
}
form label{
    display:flex;
    margin-top:20px;
  
    font-size:18px;
}
form input{
    
    padding-right:90px;
    margin-left:1px;
	padding-top:10px;
    border:none;
    border:1px solid gray;
    border-radius: 6px;
    outline:none;
}
.button{
    width: 200px;
    height:35px;
    margin-top: 20px;
   margin-left:30px;
    border:none;
    background-color: rgba(53, 138, 190, 0.589);
    color:black;
    font-size:18px;
    border-radius:5px;
}
p{
    text-align: center;
    color:black;
    font-size: 15px;
    margin-top: 20px;
    font-weight:bold;
}
p a{
   text-decoration:none;
}
button:hover
{
	opacity:0.5; 
}

</style>
<body>
<div class="signup-box">
        <h1>Sign Up</h1>
        <form action="Register" method="post">
            <label>Name</label>
            <input type="text" id="name"  name="username" placeholder="" pattern="[A-Za-z]{3,}" required>
            <label>Mobile number</label>
            <input type="text" id="number" name="phonenumber" placeholder="" pattern="[6-9][0-9]{9}" required>
            <label>city</label>
            <input type="text" id="city" name="city" placeholder="" pattern="[A-Za-z0]{4,25}" required>
            <label>Email</label>
            <input type="email" id="email" name="email" placeholder="" pattern="[a-z]+[a-z0-9]+[@][a-z]+[.][a-z]+" required>
            <label>Password</label>
            <input type="password" id="password" name="password" placeholder="" pattern="[A-Z]+[a-z]+[@#$]+[0-9]+{8,20}" required>
            <button class="button">Submit</button>
        </form>
    </div>
    <p>Already have an account?<a href="login.jsp">Login here</a></p>
</body>
</html>