<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cambia Password - Pet Shop</title>
    <link rel="stylesheet" href="CSS/styleCambiaPassword.css">
</head>
<body>
    <h1>Questo è il tuo primo accesso al portale, per favore cambia la password</h1>
    
    <form action="CambiaPasswordServlet" method="post">
        <p>Password attuale: <input type="password" name="oldPassword" required></p>
        <p>Nuova password: <input type="password" name="newPassword" required></p>
        <p>Conferma nuova password: <input type="password" name="confirmNewPassword" required></p>
        <input type="submit" value="Cambia Password">
    </form>
</body>
</html>
