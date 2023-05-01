<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista Utenti - Pet Shop</title>
    <link rel="stylesheet" href="CSS/styleListaPetShopUser.css">
</head>
<body>
    <h1>Lista Utenti</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Telefono</th>
                <th>Ruolo</th>
                <th>Stato</th>
                <th>Azione</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.nome}</td>
                    <td>${user.cognome}</td>
                    <td>${user.telefono}</td>
                    <td>${user.role}</td>
                    <td>${user.status}</td>
                    <td>
                        <c:choose>
                            <c:when test="${user.status == 'ACTIVE'}">
                                <form action="DisabilitaUtenteServlet" method="post">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <input type="submit" value="Disabilita">
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="AbilitaUtenteServlet" method="post">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <input type="submit" value="Abilita">
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="nuovoUtente.jsp">Crea nuovo utente</a></p>
    <p><a href="ModificaUtenteServlet">Modifica utente</a></p>
    <p><a href="home.jsp">Torna alla Home</a></p>
</body>
</html>
