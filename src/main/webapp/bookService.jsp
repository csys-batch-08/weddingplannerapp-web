<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book service</title>

<style>
  body
    {
        background-image: url("images/b3.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:450px;
    margin:auto;
    margin-top:30px;
    background-color:rgba(195, 160, 202, 0.589);
    border-radius:15px;
    
}
h1{
    text-align:center;
    padding-top:-15px;
}
form{
    padding:30px 20px;
    width:300px;
    margin-left:30px;
    text-align:center;
}
form label{
    display:flex;
    margin-top:30px;
    font-size:18px;
    margin-left:30px;
   
}
form input{
    width:300px;
    padding:7px;
    border:none;
    border:1px solid gray;
    border-radius: 6px;
    outline:none;
}
.button{
 padding:7px 50px;
 border-radius:4px;
 background-color:rgba(131, 72, 143, 0.5);
 border:1px solid violet;
 cursor:pointer;
 display:inline-flex;
 
}
button a{
    text-decoration:none;
    color:black;
}
 
  </style>
</head>
<body>
<form action="addToService" class="login-box" method="post">
		
		
		
    <h1>Book service</h1>
          <label>service Name:</label>
            <input type="text" id="name" class="text" name="servicename" value="${serviceName}"  placeholder="" required>
            <label>service Package:</label>
            <input type="text" id="venuePackage" class="text" name="servicepackage" value="${servicePackage}"  placeholder="" required>
            <label>Advance amount:</label>
           <input type="text" id="advancePackage" class="text" name="advancepackageService" value="${advanceServiceAmount}"  placeholder="" required>

             <label>Event date</label>
            <input type="date"  name="datefield" id="datefield" required><br><br>
            <a href="viewServices.jsp"><button class="button">Back</button></a>
             <button type="submit" class="button">Book</button>
           
            </form>

 <script type="text/javascript">
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
if(dd<10){
  dd='0'+dd
} 
if(mm<10){
  mm='0'+mm
} 
today = yyyy+'-'+mm+'-'+dd;
document.getElementById("datefield").setAttribute("min", today);

</script>

</body>
</html>