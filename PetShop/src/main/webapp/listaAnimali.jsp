<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Lista animali</title>
    <link rel="stylesheet" href="CSS/styleListaAnimali.css">
</head>
<body>
    <h1>Lista animali</h1>
    <table border="1">
        <tr>
            <th>Matricola</th>
            <th>Tipo animale</th>
            <th>Nome</th>
            <th>Data acquisto</th>
            <th>Prezzo</th>
            <th>Cliente</th>
        </tr>
        <c:forEach items="${animali}" var="animale">
            <tr>
                <td>${animale.matricola}</td>
                <td>${animale.tipoAnimale}</td>
                <td>${animale.nome}</td>
				<td class="date">${fn:replace(animale.dataAcquisto, '-', '/')}</td>
                <td><fmt:formatNumber value="${animale.prezzo}" type="currency"/></td>
                <td>${animale.cliente.nome}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
