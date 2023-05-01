<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifica Utente - Pet Shop</title>
    <link rel="stylesheet" href="CSS/styleModificaUtente.css">
</head>
<body>
    <h1>Modifica Utente</h1>
    <form action="SelezionaUtenteServlet" method="get">
        <p>Seleziona utente:
            <select name="userId" onchange="this.form.submit()">
                <option value="">-- Scegli un utente --</option>
                <c:forEach items="${userList}" var="userOption">
                    <option value="${userOption.id}" <c:if test="${userOption.id == user.id}">selected</c:if>>${userOption.username}</option>
                </c:forEach>
            </select>
        </p>
    </form>
    <c:if test="${not empty user}">
        <form action="ModificaUtenteServlet" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <p>Username: <input type="text" name="username" value="${user.username}" required></p>
            <p>Password: <input type="password" name="password" value="${user.password}" required></p>
            <p>Nome: <input type="text" name="nome" value="${user.nome}" required></p>
            <p>Cognome: <input type="text" name="cognome" value="${user.cognome}" required></p>
            <p>Telefono: <input type="text" name="telefono" value="${user.telefono}"></p>
            <p>Ruolo:
                <select name="role">
                    <option value="MANAGER" <c:if test="${user.role == 'MANAGER'}">selected</c:if>>Manager</option>
                    <option value="GUEST" <c:if test="${user.role == 'GUEST'}">selected</c:if>>Guest</option>
                </select>
            </p>
            <p>Stato:
                <select name="status">
                    <option value="ACTIVE" <c:if test="${user.status == 'ACTIVE'}">selected</c:if>>Attivo</option>
                    <option value="DISABLE" <c:if test="${user.status == 'DISABLE'}">selected</c:if>>Disabilitato</option>
                </select>
            </p>
            <input type="submit" value="Modifica Utente">
        </form>
    </c:if>
    <p><a href="ListaPetShopUserServlet">Torna alla lista utenti</a></p>
    <p><a href="home.jsp">Torna alla Home</a></p>
</body>
</html>
