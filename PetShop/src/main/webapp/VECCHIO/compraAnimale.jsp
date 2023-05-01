<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Compra Animale</title>
</head>
<body>
  	<%@ page import="java.util.*" %>
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h1>Compra Animale</h1>
    
    <h2>Ciao ${utente.nome} ${utente.cognome}, per comprare l'animale devi completare i tuoi dati.</h2>
    
    <form action="UpdateUtenteServlet" method="post">
        <label for="telefono">Telefono:</label>
        <input type="text" id="telefono" name="telefono" value="${utente.telefono}" required placeholder="${utente.telefono}" ><br><br>
        <label for="citta">Città:</label>
        <input type="text" id="citta" name="citta" value="${utente.citta}" required placeholder="${utente.citta}" ><br><br>
        <label for="indirizzo">Indirizzo:</label>
        <input type="text" id="indirizzo" name="indirizzo" value="${utente.indirizzo}" required placeholder="${utente.indirizzo}" ><br><br>
        <input type="submit" value="Aggiorna dati">
    </form>
</body>
</html>
