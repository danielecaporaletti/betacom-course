<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuovo Utente - Pet Shop</title>
    <link rel="stylesheet" href="CSS/styleNuovoUtente.css">
</head>
<body>
    <h1>Nuovo Utente</h1>
    
    <c:if test="${not empty errorMessage}">
        <h4 class="error">${errorMessage}</h4>
    </c:if>
    
    <form action="CreaUtenteServlet" method="post">
        <p>Email: <input type="text" name="email" required></p>
        <p>Password: <input type="password" name="password" required></p>
        <p>Nome: <input type="text" name="nome" required></p>
        <p>Cognome: <input type="text" name="cognome" required></p>
        <p>Telefono: <input type="text" name="telefono"></p>
        <p>Ruolo:
            <select name="role">
                <option value="MANAGER">Manager</option>
                <option value="GUEST">Guest</option>
            </select>
        </p>
        <p>Stato:
            <select name="status">
                <option value="ACTIVE">Attivo</option>
                <option value="DISABLE">Disabilitato</option>
            </select>
        </p>
        <input type="submit" value="Crea Utente">
    </form>
    <p><a href="home.jsp">Torna alla Home</a></p>
</body>
</html>
