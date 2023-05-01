<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista Clienti</title>
    <link rel="stylesheet" href="CSS/styleListaClienti.css">
</head>
<body>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 	<%@page import="it.betacom.entity.*,it.betacom.service.*,java.util.*"%>
	 
    <h1>Lista Clienti</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Telefono</th>
                <th>Città</th>
                <th>Indirizzo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clienti}" var="cliente">
                <tr>
                    <td>${cliente.id}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.cognome}</td>
                    <td>${cliente.telefono}</td>
                    <td>${cliente.citta}</td>
                    <td>${cliente.indirizzo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
     
</body>
</html>
