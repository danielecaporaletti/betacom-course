<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Home</title>
</head>
<body>
  <%@ page import="java.util.*" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%
    Map<String, Double> animali = new HashMap<>();
    animali.put("GATTO", 100.0);
    animali.put("TOPO", 50.0);
    animali.put("ELEFANTE", 5000.0);
    animali.put("GIRAFFA", 2000.0);
    animali.put("CANE", 150.0);
    animali.put("COCCODRILLO", 2500.0);

    request.setAttribute("animali", animali);
  %>
  <h1>Lista Animali</h1>
  <table>
    <tr>
      <th>Animale</th>
      <th>Prezzo</th>
      <th>Azione</th>
    </tr>
    <c:forEach var="entry" items="${animali}">
      <tr>
        <td>${entry.key}</td>
        <td>${entry.value}</td>
        <td>
          <form action="CompraAnimaleServlet" method="post">
            <input type="hidden" name="animale" value="${entry.key}" />
            <input type="submit" value="Comprami" />
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>