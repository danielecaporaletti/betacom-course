<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>PetShop</title>
	</head>
	<body>
		<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
		<% if (errorMessage != null) { %>
		    <p style="color:red;"><%= errorMessage %></p>
		<% } %>
	
		<h1 align=center>Accedi</h1>
		<form action="LoginServlet" method="post">
			<table align="center">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Accedi"></td>
				</tr>
			</table>
		</form>
		<h1 align=center><a href="registrati.jsp">Registrati</a></h1>
		
	
	</body>
</html>