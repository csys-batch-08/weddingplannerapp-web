<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ratings</title>
<style>
body
    {
        background-image: url("images/back1.jpg");
        background-size: cover;
    }
 .login-box{
   width:390px;
    height:280px;
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

 
</style>
</head>
<body>
   <form action="ratings" method="post" class="login-box">
   <h1>Ratings</h1>
   <label>service name</label>
      <input type="text" id="name"  name="venuename" value="<%=session.getAttribute("serviceName")%>"  placeholder="" required>
     <label>Rating</label>
     <div class="form-group">
          <input type="text" name="rating" pattern = "[0-5]+" placeholder="give out of 5" required><br><br>

        </div>
      <label>Review</label>
      <input type="text" name="review" placeholder="write review" required>
      <input type="submit" value ="submit">
   </form>

</body>
</html>