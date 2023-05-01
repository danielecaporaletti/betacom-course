<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Home</title>
  <link rel="stylesheet" href="CSS/styleHome.css">
</head>
<body>
    <c:set var="user" value="${sessionScope.utente}" />
    <h1>BENVENUTO ${user.username}</h1>
    <h4><a href="ListaClientiServlet">Lista Clienti</a></h4>
    <h4><a href="ListaAnimaliServlet">Lista Animali</a></h4>
    
    <c:if test="${user.role == 'MANAGER'}">
        <h4><a href="ListaPetShopUserServlet">Lista Utenti</a></h4>
    </c:if>
    <p><a href="LogoutServlet">Esci</a></p>
</body>
</html>
