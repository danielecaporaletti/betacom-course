<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ESEMPI JSP</title>
</head>
<body>
<%! int fontSize; %>
	<%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
         <font color = "green" size = "<%= fontSize %>">
            Academy Java
      </font><br />
      <%}%>
   </body> 
</html>