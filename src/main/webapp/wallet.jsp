<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wallet message</title>
</head>
<body>
Total amount:<%=session.getAttribute("amount")%>
<% String booked=(String) session.getAttribute("recharged");%>
          <h2><%=booked%></h2>
          <% session.removeAttribute("recharged"); %>
            <a href=index.jsp>Home</a>

</body>
</html>